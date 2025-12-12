package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionSetHp implements ABSingleAction {

	private ABUnitCallback target;
	private ABFloatCallback amount;
	private ABBooleanCallback isPercent;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, final int castId) {
		boolean percent = false;
		if (this.isPercent != null) {
			percent = this.isPercent.callback(caster, localStore, castId);
		}
		if (percent) {
			final CUnit targetUnit = this.target.callback(caster, localStore, castId);
			targetUnit.setCurrentHp(localStore.game,
					this.amount.callback(caster, localStore, castId) * targetUnit.getMaximumLife());
		}
		else {
			this.target.callback(caster, localStore, castId).setCurrentHp(localStore.game,
					this.amount.callback(caster, localStore, castId));
		}
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		String percentExpression = "false";
		if (this.isPercent != null) {
			percentExpression = this.isPercent.generateJassEquivalent(jassTextGenerator);
		}
		return "SetUnitHpAU(" + this.target.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.amount.generateJassEquivalent(jassTextGenerator) + ", " + percentExpression + ")";
	}
}
