package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackFloatToString extends ABStringCallback {

	private ABFloatCallback value;

	@Override
	public String callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return "" + value.callback(caster, localStore, castId);
	}

}
