package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABUnitStateListener;

public class ABCallbackGetStoredUnitStateListenerByKey extends ABUnitStateListenerCallback {
	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public ABUnitStateListener callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if (instanceValue == null || instanceValue.callback(caster, localStore, castId)) {
			return (ABUnitStateListener) localStore.get(
					ABLocalStoreKeys.combineUserInstanceKey(key.callback(caster, localStore, castId), castId));
		} else {
			return (ABUnitStateListener) localStore
					.get(ABLocalStoreKeys.combineUserKey(key.callback(caster, localStore, castId), castId));
		}
	}

}
