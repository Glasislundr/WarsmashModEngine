package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetDyingUnit extends ABUnitCallback {

	@Override
	public CUnit callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (CUnit) localStore.get(ABLocalStoreKeys.DYINGUNIT + castId);
	}

}
