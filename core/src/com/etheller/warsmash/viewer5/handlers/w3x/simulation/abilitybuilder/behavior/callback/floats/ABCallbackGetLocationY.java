package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetLocationY extends ABFloatCallback {

	private ABLocationCallback location;
	
	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return location.callback(caster, localStore, castId).getY();
	}

}
