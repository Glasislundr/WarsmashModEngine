package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetDistanceBetweenUnits extends ABFloatCallback {

	private ABUnitCallback origin;
	private ABUnitCallback target;
	
	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CUnit o = origin.callback(caster, localStore, castId);
		CUnit t = target.callback(caster, localStore, castId);
		
		return (float) o.distance(t);
	}

}
