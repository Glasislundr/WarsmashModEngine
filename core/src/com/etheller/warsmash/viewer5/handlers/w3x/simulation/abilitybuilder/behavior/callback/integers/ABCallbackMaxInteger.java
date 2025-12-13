package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackMaxInteger extends ABIntegerCallback {

	private ABIntegerCallback value1;
	private ABIntegerCallback value2;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return Math.max(value1.callback(caster, localStore, castId),
				value2.callback(caster, localStore, castId));
	}

}
