package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackIntegerToString extends ABStringCallback {
	
	private ABIntegerCallback value;
	
	@Override
	public String callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return "" + value.callback(caster, localStore, castId);
	}

}
