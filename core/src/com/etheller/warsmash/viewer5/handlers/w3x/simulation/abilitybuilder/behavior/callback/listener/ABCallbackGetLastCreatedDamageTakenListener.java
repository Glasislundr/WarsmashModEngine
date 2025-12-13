package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABDamageTakenListener;

public class ABCallbackGetLastCreatedDamageTakenListener extends ABDamageTakenListenerCallback {

	@Override
	public ABDamageTakenListener callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (ABDamageTakenListener) localStore.get(ABLocalStoreKeys.LASTCREATEDDTL);
	}

}
