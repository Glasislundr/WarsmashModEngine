package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackNegativeFloat extends ABFloatCallback {

	private ABFloatCallback value;

	@Override
	public Float callback(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		return -1 * this.value.callback(caster, localStore, castId);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "-(" + this.value.generateJassEquivalent(jassTextGenerator) + ")";
	}

}
