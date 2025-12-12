package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.environment.PathingGrid;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCreateDetectorData extends ABLongCallback {

	private ABIntegerCallback detectionLevel;
	private ABFloatCallback range;
	
	@Override
	public Long callback(CUnit caster, LocalDataStore localStore, final int castId) {
		long rng = Math.min(PathingGrid.getFogOfWarDistance(range.callback(caster, localStore, castId)), 8388607);
		byte val = detectionLevel.callback(caster, localStore, castId).byteValue();
		return val + (rng<<8);
	}

}
