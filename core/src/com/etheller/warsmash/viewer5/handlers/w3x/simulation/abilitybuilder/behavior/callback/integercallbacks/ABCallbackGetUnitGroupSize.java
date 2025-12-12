package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitgroupcallbacks.ABUnitGroupCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitGroupSize extends ABIntegerCallback {

	private ABUnitGroupCallback group;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return group.callback(caster, localStore, castId).size();
	}

}
