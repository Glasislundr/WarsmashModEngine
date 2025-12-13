package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitgroup;

import java.util.Set;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetLastCreatedUnitGroup extends ABUnitGroupCallback {

	@SuppressWarnings("unchecked")
	@Override
	public Set<CUnit> callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (Set<CUnit>) localStore.get(ABLocalStoreKeys.LASTCREATEDUNITGROUP);
	}

}
