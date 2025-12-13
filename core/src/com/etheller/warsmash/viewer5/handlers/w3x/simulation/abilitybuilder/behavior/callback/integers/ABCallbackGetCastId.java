package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetCastId extends ABIntegerCallback {

	@Override
	public Integer callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return castId;
	}

}
