package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackDivideInteger extends ABIntegerCallback {

	private ABIntegerCallback value1;
	private ABIntegerCallback value2;
	
	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return value1.callback(caster, localStore, castId) / value2.callback(caster, localStore, castId);
	}

}
