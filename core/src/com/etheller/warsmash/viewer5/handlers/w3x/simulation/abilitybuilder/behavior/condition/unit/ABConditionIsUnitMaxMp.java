package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit;

import java.util.Map;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;

public class ABConditionIsUnitMaxMp extends ABCondition {

	private ABUnitCallback unit;

	@Override
	public Boolean callback(CSimulation game, CUnit caster, Map<String, Object> localStore, final int castId) {
		CUnit theUnit = unit.callback(game, caster, localStore, castId);
		if (theUnit != null) {
			return theUnit.getMana() >= theUnit.getMaximumMana();
		}
		return false;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "IsUnitMaxMpAU(" + this.unit.generateJassEquivalent(jassTextGenerator) + ")";
	}

}
