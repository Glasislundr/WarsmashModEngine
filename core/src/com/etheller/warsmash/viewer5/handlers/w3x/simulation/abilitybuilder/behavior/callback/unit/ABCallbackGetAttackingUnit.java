package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetAttackingUnit extends ABUnitCallback {

	@Override
	public CUnit callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (CUnit) localStore.get(ABLocalStoreKeys.ATTACKINGUNIT+castId);
	}

}
