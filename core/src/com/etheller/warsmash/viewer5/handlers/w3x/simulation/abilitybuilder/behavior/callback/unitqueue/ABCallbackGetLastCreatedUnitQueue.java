package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue;

import java.util.Queue;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetLastCreatedUnitQueue extends ABUnitQueueCallback {

	@SuppressWarnings("unchecked")
	@Override
	public Queue<CUnit> callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return (Queue<CUnit>) localStore.get(ABLocalStoreKeys.LASTCREATEDUNITQUEUE);
	}

}
