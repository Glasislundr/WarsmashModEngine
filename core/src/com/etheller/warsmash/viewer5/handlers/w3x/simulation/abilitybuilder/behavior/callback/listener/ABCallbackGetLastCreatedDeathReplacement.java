package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABDeathReplacementEffect;

public class ABCallbackGetLastCreatedDeathReplacement extends ABDeathReplacementCallback {

	@Override
	public ABDeathReplacementEffect callback(CUnit caster, ABLocalDataStore localStore,
			final int castId) {
		return (ABDeathReplacementEffect) localStore.get(ABLocalStoreKeys.LASTCREATEDDRE);
	}

}
