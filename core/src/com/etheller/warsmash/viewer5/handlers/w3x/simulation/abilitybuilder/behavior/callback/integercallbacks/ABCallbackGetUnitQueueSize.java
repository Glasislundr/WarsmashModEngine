package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue.ABUnitQueueCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitQueueSize extends ABIntegerCallback {

	private ABUnitQueueCallback queue;

	@Override
	public Integer callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return queue.callback(game, caster, localStore, castId).size();
	}

}
