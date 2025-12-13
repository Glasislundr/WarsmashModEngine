package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetUnitCastPoint extends ABFloatCallback {

	private ABUnitCallback unit;
	
	@Override
	public Float callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return unit.callback(caster, localStore, castId).getUnitType().getCastPoint();
	}

}
