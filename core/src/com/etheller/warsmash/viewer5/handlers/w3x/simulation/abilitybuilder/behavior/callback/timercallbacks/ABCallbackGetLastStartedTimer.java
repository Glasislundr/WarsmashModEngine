package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.timercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.timers.CTimer;

public class ABCallbackGetLastStartedTimer extends ABTimerCallback {

	@Override
	public CTimer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (CTimer) localStore.get(ABLocalStoreKeys.LASTSTARTEDTIMER);
	}

}
