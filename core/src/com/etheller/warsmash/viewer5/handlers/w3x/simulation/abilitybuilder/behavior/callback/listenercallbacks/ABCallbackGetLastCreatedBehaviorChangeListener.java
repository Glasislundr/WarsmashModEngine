package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABBehaviorChangeListener;

public class ABCallbackGetLastCreatedBehaviorChangeListener extends ABBehaviorChangeListenerCallback {

	@Override
	public ABBehaviorChangeListener callback(CSimulation game, CUnit caster, LocalDataStore localStore,
			final int castId) {
		return (ABBehaviorChangeListener) localStore.get(ABLocalStoreKeys.LASTCREATEDBCL);
	}

}
