package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue.ABUnitQueueCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitQueueSize extends ABIntegerCallback {

	private ABUnitQueueCallback queue;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return queue.callback(caster, localStore, castId).size();
	}

}
