package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitHandleAsString extends ABStringCallback {
	
	private ABUnitCallback unit;
	
	@Override
	public String callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return "" + unit.callback(caster, localStore, castId).getHandleId();
	}

}
