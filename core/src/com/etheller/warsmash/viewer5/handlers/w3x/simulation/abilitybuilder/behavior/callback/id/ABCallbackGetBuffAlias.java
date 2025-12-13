package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buff.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetBuffAlias extends ABIDCallback {
	
	private ABBuffCallback buff;
	
	@Override
	public War3ID callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return buff.callback(caster, localStore, castId).getAlias();
	}

}
