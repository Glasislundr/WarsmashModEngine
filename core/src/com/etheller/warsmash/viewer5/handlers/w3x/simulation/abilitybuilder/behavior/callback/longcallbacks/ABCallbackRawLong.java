package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackRawLong extends ABLongCallback {

	private Long value;

	@Override
	public Long callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return value;
	}

}
