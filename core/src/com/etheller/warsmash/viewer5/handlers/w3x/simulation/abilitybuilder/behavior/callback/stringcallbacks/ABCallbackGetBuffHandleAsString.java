package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetBuffHandleAsString extends ABStringCallback {
	
	private ABBuffCallback buff;
	
	@Override
	public String callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return "" + buff.callback(caster, localStore, castId).getHandleId();
	}

}
