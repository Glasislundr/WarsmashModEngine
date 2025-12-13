package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABUnitStateListener;

public class ABCallbackGetLastCreatedUnitStateListener extends ABUnitStateListenerCallback {

	@Override
	public ABUnitStateListener callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (ABUnitStateListener) localStore.get(ABLocalStoreKeys.LASTCREATEDUSL);
	}

}
