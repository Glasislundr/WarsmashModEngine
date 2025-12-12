package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitHandleAsInteger extends ABIntegerCallback {
	
	private ABUnitCallback unit;
	
	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return unit.callback(caster, localStore, castId).getHandleId();
	}

}
