package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue.ABUnitQueueCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackPollUnitQueue extends ABUnitCallback {

	private ABUnitQueueCallback queue;
	
	@Override
	public CUnit callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return queue.callback(game, caster, localStore, castId).poll();
	}

}
