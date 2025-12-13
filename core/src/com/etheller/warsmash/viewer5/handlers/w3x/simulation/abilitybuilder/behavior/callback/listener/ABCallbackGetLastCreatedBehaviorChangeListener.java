package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABBehaviorChangeListener;

public class ABCallbackGetLastCreatedBehaviorChangeListener extends ABBehaviorChangeListenerCallback {

	@Override
	public ABBehaviorChangeListener callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (ABBehaviorChangeListener) localStore.get(ABLocalStoreKeys.LASTCREATEDBCL);
	}

}
