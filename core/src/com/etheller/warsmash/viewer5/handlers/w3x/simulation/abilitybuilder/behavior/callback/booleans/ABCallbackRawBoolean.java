package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackRawBoolean extends ABCondition {

	private Boolean value;

	@Override
	public Boolean callback(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		return this.value;
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return this.value.toString();
	}

}
