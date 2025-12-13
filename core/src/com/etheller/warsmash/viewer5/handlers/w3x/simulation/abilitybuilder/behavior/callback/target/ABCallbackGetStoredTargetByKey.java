package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.target;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetStoredTargetByKey extends ABTargetCallback {
	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public AbilityTarget callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if (instanceValue == null || instanceValue.callback(caster, localStore, castId)) {
			return (AbilityTarget) localStore.get(ABLocalStoreKeys.combineUserInstanceKey(key.callback(caster, localStore, castId), castId));
		} else {
			return (AbilityTarget) localStore.get(ABLocalStoreKeys.combineUserKey(key.callback(caster, localStore, castId), castId));
		}
	}

}
