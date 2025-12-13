package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackSin extends ABFloatCallback {

	private ABFloatCallback angle;

	@Override
	public Float callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (float) StrictMath.sin(angle.callback(caster, localStore, castId));
	}

}
