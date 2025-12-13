package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longs;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCreateDetectedData extends ABLongCallback {

	private ABIntegerCallback detectionLevel;
	private ABIntegerCallback playerDetectedData;
	
	@Override
	public Long callback(CUnit caster, LocalDataStore localStore, final int castId) {
		long ply = playerDetectedData.callback(caster, localStore, castId);
		byte val = detectionLevel.callback(caster, localStore, castId).byteValue();
		return val + (ply<<8);
	}

}
