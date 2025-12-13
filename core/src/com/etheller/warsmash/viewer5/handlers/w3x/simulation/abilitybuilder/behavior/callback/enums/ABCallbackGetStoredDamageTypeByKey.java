package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CDamageType;

public class ABCallbackGetStoredDamageTypeByKey extends ABDamageTypeCallback {

	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public CDamageType callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		if ((this.instanceValue == null) || this.instanceValue.callback(caster, localStore, castId)) {
			return (CDamageType) localStore.get(ABLocalStoreKeys
					.combineUserInstanceKey(this.key.callback(caster, localStore, castId), castId));
		}
		else {
			return (CDamageType) localStore
					.get(ABLocalStoreKeys.combineUserKey(this.key.callback(caster, localStore, castId), castId));
		}
	}

}
