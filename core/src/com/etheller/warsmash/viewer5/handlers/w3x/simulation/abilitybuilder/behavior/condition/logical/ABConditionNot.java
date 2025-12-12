package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.logical;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionNot extends ABCondition {

	private ABCondition condition;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return !condition.callback(caster, localStore, castId);
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "not " + this.condition.generateJassEquivalent(jassTextGenerator);
	}

}
