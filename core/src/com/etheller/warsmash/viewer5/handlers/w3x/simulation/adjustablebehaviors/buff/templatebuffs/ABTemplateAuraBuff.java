package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.buff.templatebuffs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.buff.ABBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CEffectType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingFx;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABTemplateAuraBuff extends ABBuff {
	private Map<Integer, NonStackingFx> fx;
	private CEffectType artType = CEffectType.TARGET;

	private CUnit caster;

	private List<ABAction> onAddActions;
	private List<ABAction> onRemoveActions;
	private List<StateModBuff> stateMods = null;
	private List<NonStackingStatBuff> statBuffs = null;

	public ABTemplateAuraBuff(int handleId, War3ID alias, ABLocalDataStore localStore, CAbility sourceAbility,
			CUnit caster, List<StateModBuff> stateMods, List<NonStackingStatBuff> statBuffs,
			List<ABAction> onAddActions, List<ABAction> onRemoveActions, boolean leveled, boolean positive) {
		super(handleId, alias, alias, localStore, sourceAbility, caster);
		this.caster = caster;
		this.fx = new HashMap<>();
		this.setHero(caster.isHero());
		this.setLeveled(leveled);
		this.setPositive(positive);
		this.setAura(true);
		this.setLevel(null, null, 1);
		this.onAddActions = onAddActions;
		this.onRemoveActions = onRemoveActions;
		this.stateMods = stateMods;
		this.statBuffs = statBuffs;
	}

	public void setArtType(CEffectType artType) {
		this.artType = artType;
	}

	@Override
	public void onAdd(final CSimulation game, final CUnit unit) {
		if (artType != null && unit != this.caster && this.fx.get(unit.getHandleId()) == null) {
			this.fx.put(unit.getHandleId(), unit.addNonStackingFx(game, "aura", getAlias(), artType));
		}
		if (this.stateMods != null) {
			for (StateModBuff mod : this.stateMods) {
				unit.addStateModBuff(mod);
				unit.computeUnitState(game, mod.getBuffType());
			}
		}
		if (this.statBuffs != null) {
			for (NonStackingStatBuff buff : this.statBuffs) {
				unit.addNonStackingStatBuff(game, buff);
			}
		}
		if (onAddActions != null) {
			localStore.put(ABLocalStoreKeys.BUFF, this);
			for (ABAction action : onAddActions) {
				action.runAction(unit, localStore, ABConstants.AURA_CAST_ID);
			}
			localStore.remove(ABLocalStoreKeys.BUFF);
		}
	}

	@Override
	public void onRemove(final CSimulation game, final CUnit unit) {
		NonStackingFx theFx = this.fx.get(unit.getHandleId());
		if (theFx != null) {
			this.fx.remove(unit.getHandleId());
			unit.removeNonStackingFx(game, theFx);
		}
		if (onRemoveActions != null) {
			localStore.put(ABLocalStoreKeys.BUFF, this);
			for (ABAction action : onRemoveActions) {
				action.runAction(unit, localStore, ABConstants.AURA_CAST_ID);
			}
			localStore.remove(ABLocalStoreKeys.BUFF);
		}
		if (this.statBuffs != null) {
			for (NonStackingStatBuff buff : this.statBuffs) {
				unit.removeNonStackingStatBuff(game, buff);
			}
		}
		if (this.stateMods != null) {
			for (StateModBuff mod : this.stateMods) {
				unit.removeStateModBuff(mod);
				unit.computeUnitState(game, mod.getBuffType());
			}
		}
	}

	@Override
	public float getDurationRemaining(CSimulation game, final CUnit unit) {
		return 0;
	}

	@Override
	public float getDurationMax() {
		return 0;
	}

	@Override
	public int getExpireTick() {
		return 0;
	}

	@Override
	public void onTick(CSimulation game, CUnit unit) {
	}

	@Override
	public void onDeath(CSimulation game, CUnit cUnit) {
	}

}
