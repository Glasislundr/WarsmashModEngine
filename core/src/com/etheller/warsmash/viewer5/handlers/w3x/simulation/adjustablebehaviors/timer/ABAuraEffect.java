package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.badlogic.gdx.math.Rectangle;
import com.etheller.warsmash.util.WarsmashConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnitEnumFunction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.timers.CTimed;

public class ABAuraEffect implements CTimed {
	private static final Rectangle recycleRect = new Rectangle();
	private final int LEAVE_GROUP_TICKS = (int) (3 / WarsmashConstants.SIMULATION_STEP_TIME);
	private final int ENTER_GROUP_TICKS = (int) (0.4 / WarsmashConstants.SIMULATION_STEP_TIME);

	private ABLocalDataStore localStore;
	private AbilityTarget origin;

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
	private int lastSeenLevel;
	private int currentLevel;
	private float range;

	public ABAuraEffect(ABLocalDataStore localStore, final int castId, AbilityTarget origin, float range,
			ABBooleanCallback condition, List<ABAction> enterActions, List<ABAction> leaveActions,
			boolean resetAuraOnLevelup, List<ABAction> changeLevelActions, List<ABAction> changeLevelPerUnitActions,
			int currentLevel) {
		super();
		this.localStore = localStore;
		this.origin = origin;
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
					for (CUnit iter : new ArrayList<>(auraGroup)) {
						updateLevelOfAura(game, iter, this.lastSeenLevel, this.currentLevel);
					}
				}
				this.lastSeenLevel = this.currentLevel;
			}
			if (currentTick >= leaveFireTick) {
				for (CUnit iter : new ArrayList<>(auraGroup)) {
					if (!(condition.callback(iter, localStore, castId) && iter.canReach(this.origin, this.range))) {
						removeUnitFromAura(game, iter);
					}
				}
				this.leaveFireTick += LEAVE_GROUP_TICKS;
			}
			if (currentTick >= enterFireTick) {
				recycleRect.set(this.origin.getX() - this.range, this.origin.getY() - this.range, this.range * 2,
						this.range * 2);
				game.getWorldCollision().enumUnitsInRect(recycleRect, new CUnitEnumFunction() {
					@Override
					public boolean call(final CUnit enumUnit) {
						if (enumUnit.canReach(origin, range) && !auraGroup.contains(enumUnit)
								&& condition.callback(enumUnit, localStore, castId)) {
							addUnitToAura(game, enumUnit);
						}
						return false;
					}
				});
				this.enterFireTick += ENTER_GROUP_TICKS;
			}
			game.registerTimer(this);
		}
	}

	public void emptyAura(CSimulation game) {
		List<CUnit> unitList = new ArrayList<>(auraGroup);
		for (CUnit iter : unitList) {
			removeUnitFromAura(game, iter);
		}
	}

	public void addUnitToAura(CSimulation game, CUnit unit) {
		auraGroup.add(unit);
		if (enterActions != null) {
			for (ABAction action : enterActions) {
				action.runAction(unit, localStore, this.castId);
			}
		}
	}

	public void updateLevelOfAura(CSimulation game, CUnit unit, int prevLevel, int curLevel) {
		if (changeLevelPerUnitActions != null) {
			for (ABAction action : changeLevelPerUnitActions) {
				action.runAction(unit, localStore, this.castId);
			}
		}
	}

	public void removeUnitFromAura(CSimulation game, CUnit unit) {
		if (leaveActions != null) {
			for (ABAction action : leaveActions) {
				action.runAction(unit, localStore, this.castId);
			}
		}
		auraGroup.remove(unit);
	}

	public void setLevel(int level) {
		this.currentLevel = level;
	}

	public void setRange(float range) {
		this.range = range;
	}

}
