package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackPi extends ABFloatCallback {

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (float) StrictMath.PI;
	}

}
