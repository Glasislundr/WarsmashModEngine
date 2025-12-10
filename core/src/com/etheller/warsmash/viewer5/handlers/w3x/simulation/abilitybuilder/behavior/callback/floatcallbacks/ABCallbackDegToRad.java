package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackDegToRad extends ABFloatCallback {

	private ABFloatCallback angle;

	@Override
	public Float callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return (float) StrictMath.toRadians(angle.callback(game, caster, localStore, castId));
	}

}
