package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABDamageTakenModificationListener;

public class ABCallbackGetLastCreatedDamageTakenModificationListener extends ABDamageTakenModificationListenerCallback {

	@Override
	public ABDamageTakenModificationListener callback(CUnit caster, ABLocalDataStore localStore,
			final int castId) {
		return (ABDamageTakenModificationListener) localStore.get(ABLocalStoreKeys.LASTCREATEDDTML);
	}

}
