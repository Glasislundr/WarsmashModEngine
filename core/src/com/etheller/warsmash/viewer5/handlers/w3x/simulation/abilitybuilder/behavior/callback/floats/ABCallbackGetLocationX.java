package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetLocationX extends ABFloatCallback {

	private ABLocationCallback location;

	@Override
	public Float callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return location.callback(caster, localStore, castId).getX();
	}

}
