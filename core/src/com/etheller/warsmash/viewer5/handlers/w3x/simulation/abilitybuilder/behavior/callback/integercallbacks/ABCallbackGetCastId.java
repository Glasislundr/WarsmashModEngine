package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetCastId extends ABIntegerCallback {

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return castId;
	}

}
