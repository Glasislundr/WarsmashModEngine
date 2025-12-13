package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackDegToRad extends ABFloatCallback {

	private ABFloatCallback angle;

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (float) StrictMath.toRadians(angle.callback(caster, localStore, castId));
	}

}
