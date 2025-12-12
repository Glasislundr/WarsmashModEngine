package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitCurrentHp extends ABFloatCallback {

	private ABUnitCallback unit;

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return unit == null ? caster.getLife() : this.unit.callback(caster, localStore, castId).getLife();
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "GetUnitState(" + this.unit.generateJassEquivalent(jassTextGenerator) + ", UNIT_STATE_LIFE)";
	}

}
