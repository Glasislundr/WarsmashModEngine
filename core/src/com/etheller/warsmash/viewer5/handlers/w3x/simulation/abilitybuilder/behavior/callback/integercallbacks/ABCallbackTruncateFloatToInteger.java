package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackTruncateFloatToInteger extends ABIntegerCallback {

	private ABFloatCallback value;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return value.callback(caster, localStore, castId).intValue();
	}

}
