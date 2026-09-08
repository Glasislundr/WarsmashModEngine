package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.badlogic.gdx.math.Rectangle;
import com.etheller.warsmash.util.WarsmashConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructableEnumFunction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItem;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItemEnumFunction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnitEnumFunction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTargetVisitor;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.timers.CTimed;

public class ABAuraEffect implements CTimed {
	private static final Rectangle recycleRect = new Rectangle();
	private static final AuraUnitFunc recycleUnitFunc = new AuraUnitFunc();
	private static final AuraDestFunc recycleDestFunc = new AuraDestFunc();
	private static final AuraItemFunc recycleItemFunc = new AuraItemFunc();

	// These three cannot be static, because there is a chance that leaving one aura
	// could cause a unit to leave another, nesting emptyAura calls
	private final List<CUnit> recycleUnitList = new ArrayList<>();
	private final List<CDestructable> recycleDestList = new ArrayList<>();
	private final List<CItem> recycleItemList = new ArrayList<>();

	private final int LEAVE_GROUP_TICKS = (int) (3 / WarsmashConstants.SIMULATION_STEP_TIME);
	private final int ENTER_GROUP_TICKS = (int) (0.4 / WarsmashConstants.SIMULATION_STEP_TIME);

	private ABLocalDataStore localStore;
	private AbilityTarget origin;
	private CUnit originUnit;
	private CDestructable originDest;
	private CItem originItem;

	private ABBooleanCallback condition;
	private List<ABAction> enterActions;
	private List<ABAction> leaveActions;
	private boolean resetAuraOnLevelup;
	private List<ABAction> changeLevelActions;
	private List<ABAction> changeLevelPerUnitActions;

	private int castId;
	private boolean running = false;
	private int leaveFireTick;
	private int enterFireTick;
	private Set<CUnit> auraGroup;
	private Set<CDestructable> auraDestGroup;
	private Set<CItem> auraItemGroup;
	private int lastSeenLevel;
	private int currentLevel;
	private float range;

	private boolean affectsUnits = true;
	private boolean affectsCorpses = false;
	private boolean affectsDests = false;
	private boolean affectsItems = false;

	public ABAuraEffect(ABLocalDataStore localStore, final int castId, AbilityTarget origin, float range,
			ABBooleanCallback condition, List<ABAction> enterActions, List<ABAction> leaveActions,
			boolean resetAuraOnLevelup, List<ABAction> changeLevelActions, List<ABAction> changeLevelPerUnitActions,
			int currentLevel) {
		super();
		this.localStore = localStore;
		this.origin = origin;
		this.originUnit = this.origin.visit(AbilityTargetVisitor.UNIT);
		this.originItem = this.origin.visit(AbilityTargetVisitor.ITEM);
		this.originDest = this.origin.visit(AbilityTargetVisitor.DESTRUCTABLE);
		this.condition = condition;
		this.enterActions = enterActions;
		this.leaveActions = leaveActions;
		this.resetAuraOnLevelup = resetAuraOnLevelup;
		this.changeLevelActions = changeLevelActions;
		this.changeLevelPerUnitActions = changeLevelPerUnitActions;
		this.castId = castId;
		this.lastSeenLevel = currentLevel;
		this.currentLevel = currentLevel;
		this.range = range;
		this.auraGroup = new HashSet<>();
		this.auraDestGroup = new HashSet<>();
		this.auraItemGroup = new HashSet<>();
	}

	@Override
	public void start(CSimulation game) {
		this.running = true;
		this.leaveFireTick = game.getGameTurnTick();
		this.enterFireTick = this.leaveFireTick;
		game.registerTimer(this);
	}

	@Override
	public void pause(CSimulation game) {
		emptyAura(game);
		game.unregisterTimer(this);
		this.running = false;
	}

	@Override
	public void resume(CSimulation game) {
		this.start(game);
	}

	@Override
	public void kill(CSimulation game) {
		emptyAura(game);
		game.unregisterTimer(this);
		this.running = false;
		this.localStore = null;
		this.enterActions = null;
		this.leaveActions = null;
		this.changeLevelActions = null;
		this.changeLevelPerUnitActions = null;
		this.auraGroup = null;
	}

	@Override
	public int getEngineFireTick() {
		return Math.min(this.leaveFireTick, this.enterFireTick);
	}

	@Override
	public void fire(CSimulation game) {
		if (running) {
			final int currentTick = game.getGameTurnTick();
			if (this.lastSeenLevel != this.currentLevel) {
				if (resetAuraOnLevelup) {
					this.emptyAura(game);
					this.leaveFireTick = currentTick + LEAVE_GROUP_TICKS;
					this.enterFireTick = currentTick;
				}
				if (changeLevelActions != null) {
					for (ABAction action : changeLevelActions) {
						action.runAction(localStore.originUnit, localStore, this.castId);
					}
				}
				if (!resetAuraOnLevelup) {
					if (auraGroup.size() > 0) {
						recycleUnitList.addAll(auraGroup);
						for (CUnit iter : recycleUnitList) {
							updateLevelOfAura(game, iter, this.lastSeenLevel, this.currentLevel);
						}
						recycleUnitList.clear();
					}
					if (auraDestGroup.size() > 0) {
						recycleDestList.addAll(auraDestGroup);
						for (CDestructable iter : recycleDestList) {
							updateLevelOfAura(game, iter, this.lastSeenLevel, this.currentLevel);
						}
						recycleDestList.clear();
					}
					if (auraItemGroup.size() > 0) {
						recycleItemList.addAll(auraItemGroup);
						for (CItem iter : recycleItemList) {
							updateLevelOfAura(game, iter, this.lastSeenLevel, this.currentLevel);
						}
						recycleItemList.clear();
					}
				}
				this.lastSeenLevel = this.currentLevel;
			}
			if (currentTick >= leaveFireTick) {
				// Every leaveFireTick, check for targets to remove from the aura
				if (this.range > 0) {
					// When we have a real range, we just iterate items in that range
					if (this.affectsUnits || this.affectsCorpses) {
						recycleUnitList.addAll(auraGroup);
						for (CUnit iter : recycleUnitList) {
							if (!(iter.canReach(this.origin, this.range)
									&& condition.callback(iter, localStore, castId))) {
								removeFromAura(game, iter);
							}
						}
						recycleUnitList.clear();
					}
					if (this.affectsDests) {
						recycleDestList.addAll(auraDestGroup);
						for (CDestructable iter : recycleDestList) {
							localStore.put(ABLocalStoreKeys.AURADEST, iter);
							if (!(iter.distance(this.origin.getX(), this.origin.getY()) <= this.range
									&& condition.callback(null, localStore, castId))) {
								removeFromAura(game, iter);
							}
							localStore.remove(ABLocalStoreKeys.AURADEST);
						}
						recycleDestList.clear();
					}
					if (this.affectsItems) {
						recycleItemList.addAll(auraItemGroup);
						for (CItem iter : recycleItemList) {
							localStore.put(ABLocalStoreKeys.AURAITEM, iter);
							if (!(iter.distance(this.origin.getX(), this.origin.getY()) <= this.range
									&& condition.callback(null, localStore, castId))) {
								removeFromAura(game, iter);
							}
							localStore.remove(ABLocalStoreKeys.AURAITEM);
						}
						recycleItemList.clear();
					}
				} else {
					// If we have no range, we check for any non-origin targets and remove them
					if (this.affectsUnits || this.affectsCorpses) {
						recycleUnitList.addAll(auraGroup);
						for (CUnit iter : recycleUnitList) {
							if (iter != this.originUnit) {
								removeFromAura(game, iter);
							}
						}
						recycleUnitList.clear();
					}
					if (this.affectsDests) {
						recycleDestList.addAll(auraDestGroup);
						for (CDestructable iter : recycleDestList) {
							if (iter != this.originDest) {
								removeFromAura(game, iter);
							}
						}
						recycleDestList.clear();
					}
					if (this.affectsItems) {
						recycleItemList.addAll(auraItemGroup);
						for (CItem iter : recycleItemList) {
							if (iter != this.originItem) {
								removeFromAura(game, iter);
							}
						}
						recycleItemList.clear();
					}
				}
				this.leaveFireTick += LEAVE_GROUP_TICKS;
			}
			if (currentTick >= enterFireTick) {
				// Every enterFireTick, check for targets to add to the aura
				recycleRect.set(this.origin.getX() - this.range, this.origin.getY() - this.range, this.range * 2,
						this.range * 2);
				if (range > 0) {
					// If range > 0, then iterate for targets and add those that match the condition
					if (this.affectsUnits) {
						recycleUnitFunc.reset(game, localStore, this, origin, range, auraGroup, condition, castId);
						game.getWorldCollision().enumUnitsInRect(recycleRect, recycleUnitFunc);
					}
					if (this.affectsCorpses) {
						recycleUnitFunc.reset(game, localStore, this, origin, range, auraGroup, condition, castId);
						game.getWorldCollision().enumCorpsesInRect(recycleRect, recycleUnitFunc);

					}
					if (this.affectsDests) {
						recycleDestFunc.reset(game, localStore, this, origin, range, auraDestGroup, condition, castId);
						game.getWorldCollision().enumDestructablesInRect(recycleRect, recycleDestFunc);
					}
					if (this.affectsItems) {
						recycleItemFunc.reset(game, localStore, this, origin, range, auraItemGroup, condition, castId);
						game.getWorldCollision().enumItemsInRect(recycleRect, recycleItemFunc);
					}
				} else {
					// if range <= 0, can only affect the origin widget (if one exists)
					if (this.originUnit != null
							&& ((this.affectsUnits && !this.originUnit.isDead())
									|| (this.affectsCorpses && this.originUnit.isDead()))
							&& !auraGroup.contains(this.originUnit)
							&& condition.callback(this.originUnit, localStore, castId)) {
						addToAura(game, this.originUnit);
					}
					if (this.affectsDests && this.originDest != null && !auraDestGroup.contains(this.originDest)) {
						localStore.put(ABLocalStoreKeys.AURADEST, this.originDest);
						if (condition.callback(null, localStore, castId)) {
							addToAura(game, this.originDest);
						}
						localStore.remove(ABLocalStoreKeys.AURADEST);
					}
					if (this.affectsItems && this.originItem != null && !auraItemGroup.contains(this.originItem)) {
						localStore.put(ABLocalStoreKeys.AURAITEM, this.originItem);
						if (condition.callback(null, localStore, castId)) {
							addToAura(game, this.originItem);
						}
						localStore.remove(ABLocalStoreKeys.AURAITEM);
					}
				}
				this.enterFireTick += ENTER_GROUP_TICKS;
			}
			game.registerTimer(this);
		}
	}

	public void emptyAura(CSimulation game) {
		if (auraGroup.size() > 0) {
			recycleUnitList.addAll(auraGroup);
			for (CUnit iter : recycleUnitList) {
				removeFromAura(game, iter);
			}
			recycleUnitList.clear();
		}
		if (auraDestGroup.size() > 0) {
			recycleDestList.addAll(auraDestGroup);
			for (CDestructable iter : recycleDestList) {
				removeFromAura(game, iter);
			}
			recycleDestList.clear();
		}
		if (auraItemGroup.size() > 0) {
			recycleItemList.addAll(auraItemGroup);
			for (CItem iter : recycleItemList) {
				removeFromAura(game, iter);
			}
			recycleItemList.clear();
		}
	}

	public void addToAura(CSimulation game, CUnit unit) {
		auraGroup.add(unit);
		if (enterActions != null) {
			for (ABAction action : enterActions) {
				action.runAction(unit, localStore, this.castId);
			}
		}
	}

	public void addToAura(CSimulation game, CDestructable dest) {
		auraDestGroup.add(dest);
		if (enterActions != null) {
			localStore.put(ABLocalStoreKeys.AURADEST, dest);
			for (ABAction action : enterActions) {
				action.runAction(null, localStore, this.castId);
			}
			localStore.remove(ABLocalStoreKeys.AURADEST);
		}
	}

	public void addToAura(CSimulation game, CItem item) {
		auraItemGroup.add(item);
		if (enterActions != null) {
			localStore.put(ABLocalStoreKeys.AURAITEM, item);
			for (ABAction action : enterActions) {
				action.runAction(null, localStore, this.castId);
			}
			localStore.remove(ABLocalStoreKeys.AURAITEM);
		}
	}

	public void updateLevelOfAura(CSimulation game, CUnit unit, int prevLevel, int curLevel) {
		if (changeLevelPerUnitActions != null) {
			for (ABAction action : changeLevelPerUnitActions) {
				action.runAction(unit, localStore, this.castId);
			}
		}
	}

	public void updateLevelOfAura(CSimulation game, CDestructable dest, int prevLevel, int curLevel) {
		if (changeLevelPerUnitActions != null) {
			localStore.put(ABLocalStoreKeys.AURADEST, dest);
			for (ABAction action : changeLevelPerUnitActions) {
				action.runAction(null, localStore, this.castId);
			}
			localStore.remove(ABLocalStoreKeys.AURADEST);
		}
	}

	public void updateLevelOfAura(CSimulation game, CItem item, int prevLevel, int curLevel) {
		if (changeLevelPerUnitActions != null) {
			localStore.put(ABLocalStoreKeys.AURAITEM, item);
			for (ABAction action : changeLevelPerUnitActions) {
				action.runAction(null, localStore, this.castId);
			}
			localStore.remove(ABLocalStoreKeys.AURAITEM);
		}
	}

	public void removeFromAura(CSimulation game, CUnit unit) {
		if (leaveActions != null) {
			for (ABAction action : leaveActions) {
				action.runAction(unit, localStore, this.castId);
			}
		}
		auraGroup.remove(unit);
	}

	public void removeFromAura(CSimulation game, CDestructable dest) {
		if (leaveActions != null) {
			localStore.put(ABLocalStoreKeys.AURADEST, dest);
			for (ABAction action : leaveActions) {
				action.runAction(null, localStore, this.castId);
			}
			localStore.remove(ABLocalStoreKeys.AURADEST);
		}
		auraDestGroup.remove(dest);
	}

	public void removeFromAura(CSimulation game, CItem item) {
		if (leaveActions != null) {
			localStore.put(ABLocalStoreKeys.AURAITEM, item);
			for (ABAction action : leaveActions) {
				action.runAction(null, localStore, this.castId);
			}
			localStore.remove(ABLocalStoreKeys.AURAITEM);
		}
		auraItemGroup.remove(item);
	}

	public void setLevel(int level) {
		this.currentLevel = level;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public boolean isAffectsUnits() {
		return affectsUnits;
	}

	public void setAffectsUnits(boolean affectsUnits) {
		this.affectsUnits = affectsUnits;
	}

	public boolean isAffectsCorpses() {
		return affectsCorpses;
	}

	public void setAffectsCorpses(boolean affectsCorpses) {
		this.affectsCorpses = affectsCorpses;
	}

	public boolean isAffectsDests() {
		return affectsDests;
	}

	public void setAffectsDests(boolean affectsDests) {
		this.affectsDests = affectsDests;
	}

	public boolean isAffectsItems() {
		return affectsItems;
	}

	public void setAffectsItems(boolean affectsItems) {
		this.affectsItems = affectsItems;
	}

	private static class AuraUnitFunc implements CUnitEnumFunction {
		private CSimulation game;
		private ABLocalDataStore localStore;
		private ABAuraEffect aura;
		private AbilityTarget origin;
		private float range;
		private Set<CUnit> auraGroup;
		private int castId;
		private ABBooleanCallback condition;

		public void reset(CSimulation game, ABLocalDataStore localStore, ABAuraEffect aura, AbilityTarget origin,
				float range, Set<CUnit> auraGroup, ABBooleanCallback condition, int castId) {
			this.game = game;
			this.localStore = localStore;
			this.aura = aura;
			this.origin = origin;
			this.range = range;
			this.auraGroup = auraGroup;
			this.condition = condition;
			this.castId = castId;
		}

		@Override
		public boolean call(final CUnit enumUnit) {
			if (enumUnit.canReach(origin, range) && !auraGroup.contains(enumUnit)
					&& condition.callback(enumUnit, localStore, castId)) {
				this.aura.addToAura(game, enumUnit);
			}
			return false;
		}
	}

	private static class AuraDestFunc implements CDestructableEnumFunction {
		private CSimulation game;
		private ABLocalDataStore localStore;
		private ABAuraEffect aura;
		private AbilityTarget origin;
		private float range;
		private Set<CDestructable> auraDestGroup;
		private int castId;
		private ABBooleanCallback condition;

		public void reset(CSimulation game, ABLocalDataStore localStore, ABAuraEffect aura, AbilityTarget origin,
				float range, Set<CDestructable> auraDestGroup, ABBooleanCallback condition, int castId) {
			this.game = game;
			this.localStore = localStore;
			this.aura = aura;
			this.origin = origin;
			this.range = range;
			this.auraDestGroup = auraDestGroup;
			this.condition = condition;
			this.castId = castId;
		}

		@Override
		public boolean call(final CDestructable enumDest) {
			localStore.put(ABLocalStoreKeys.AURADEST, enumDest);
			if (enumDest.distance(origin.getX(), origin.getY()) <= range
					&& !auraDestGroup.contains(enumDest)
					&& condition.callback(null, localStore, castId)) {
				this.aura.addToAura(game, enumDest);
			}
			localStore.remove(ABLocalStoreKeys.AURADEST);
			return false;
		}
	}

	private static class AuraItemFunc implements CItemEnumFunction {
		private CSimulation game;
		private ABLocalDataStore localStore;
		private ABAuraEffect aura;
		private AbilityTarget origin;
		private float range;
		private Set<CItem> auraItemGroup;
		private int castId;
		private ABBooleanCallback condition;

		public void reset(CSimulation game, ABLocalDataStore localStore, ABAuraEffect aura, AbilityTarget origin,
				float range, Set<CItem> auraItemGroup, ABBooleanCallback condition, int castId) {
			this.game = game;
			this.localStore = localStore;
			this.aura = aura;
			this.origin = origin;
			this.range = range;
			this.auraItemGroup = auraItemGroup;
			this.condition = condition;
			this.castId = castId;
		}

		@Override
		public boolean call(final CItem enumItem) {
			localStore.put(ABLocalStoreKeys.AURAITEM, enumItem);
			if (enumItem.distance(origin.getX(), origin.getY()) <= range
					&& !auraItemGroup.contains(enumItem)
					&& condition.callback(null, localStore, castId)) {
				this.aura.addToAura(game, enumItem);
			}
			localStore.remove(ABLocalStoreKeys.AURAITEM);
			return false;
		}
	}

}
