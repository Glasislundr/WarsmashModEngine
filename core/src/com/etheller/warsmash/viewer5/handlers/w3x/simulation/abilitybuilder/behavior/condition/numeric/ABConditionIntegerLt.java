package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.numeric;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIntegerLt extends ABCondition {

	private ABIntegerCallback value1;
	private ABIntegerCallback value2;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		Integer v1 = value1.callback(caster, localStore, castId);
		Integer v2 = value2.callback(caster, localStore, castId);
		return v1 < v2;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return this.value1.generateJassEquivalent(jassTextGenerator) + " < "
				+ this.value2.generateJassEquivalent(jassTextGenerator);
	}

}
