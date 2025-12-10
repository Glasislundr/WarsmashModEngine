package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCreateDetectedData extends ABLongCallback {

	private ABIntegerCallback detectionLevel;
	private ABIntegerCallback playerDetectedData;
	
	@Override
	public Long callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		long ply = playerDetectedData.callback(game, caster, localStore, castId);
		byte val = detectionLevel.callback(game, caster, localStore, castId).byteValue();
		return val + (ply<<8);
	}

}
