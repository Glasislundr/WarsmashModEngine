package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackIntegerToBoolean extends ABCondition {

	private ABIntegerCallback value;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return this.value.callback(caster, localStore, castId) != 0;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return this.value.generateJassEquivalent(jassTextGenerator) + " != 0";
	}

}
