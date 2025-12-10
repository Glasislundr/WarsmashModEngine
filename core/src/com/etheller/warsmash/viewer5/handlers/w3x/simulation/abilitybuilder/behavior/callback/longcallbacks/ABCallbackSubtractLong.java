package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackSubtractLong extends ABLongCallback {

	private ABLongCallback value1;
	private ABLongCallback value2;
	
	@Override
	public Long callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return value1.callback(game, caster, localStore, castId) - value2.callback(game, caster, localStore, castId);
	}

}
