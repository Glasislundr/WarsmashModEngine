package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buff.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetBuffHandleAsInteger extends ABIntegerCallback {

	private ABBuffCallback buff;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return buff.callback(caster, localStore, castId).getHandleId();
	}

}
