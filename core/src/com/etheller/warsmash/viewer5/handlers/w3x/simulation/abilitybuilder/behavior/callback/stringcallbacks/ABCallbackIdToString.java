package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackIdToString extends ABStringCallback {
	
	private ABIDCallback value;
	
	@Override
	public String callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return value.callback(caster, localStore, castId).asStringValue();
	}

}
