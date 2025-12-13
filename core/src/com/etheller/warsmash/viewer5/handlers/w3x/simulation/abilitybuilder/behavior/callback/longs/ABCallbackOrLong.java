package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longs;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackOrLong extends ABLongCallback {

	private ABLongCallback value1;
	private ABLongCallback value2;
	
	@Override
	public Long callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return value1.callback(caster, localStore, castId) | value2.callback(caster, localStore, castId);
	}

}
