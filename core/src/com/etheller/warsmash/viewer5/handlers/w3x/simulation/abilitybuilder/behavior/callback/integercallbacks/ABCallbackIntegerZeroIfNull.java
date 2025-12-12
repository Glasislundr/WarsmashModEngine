package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackIntegerZeroIfNull extends ABIntegerCallback {

	private ABIntegerCallback value;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		Integer v = value.callback(caster, localStore, castId);
		return v == null ? 0 : v;
	}

}
