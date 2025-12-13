package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAttackPreDamageListener;

public class ABCallbackGetStoredAttackPreDamageListenerByKey extends ABAttackPreDamageListenerCallback {
	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public ABAttackPreDamageListener callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if (instanceValue == null || instanceValue.callback(caster, localStore, castId)) {
			return (ABAttackPreDamageListener) localStore.get(
					ABLocalStoreKeys.combineUserInstanceKey(key.callback(caster, localStore, castId), castId));
		} else {
			return (ABAttackPreDamageListener) localStore
					.get(ABLocalStoreKeys.combineUserKey(key.callback(caster, localStore, castId), castId));
		}
	}

}
