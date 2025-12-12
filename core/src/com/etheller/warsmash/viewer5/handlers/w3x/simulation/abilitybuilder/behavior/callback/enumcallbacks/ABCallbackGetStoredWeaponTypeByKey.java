package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CWeaponType;

public class ABCallbackGetStoredWeaponTypeByKey extends ABWeaponTypeCallback {

	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public CWeaponType callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		if ((this.instanceValue == null) || this.instanceValue.callback(caster, localStore, castId)) {
			return (CWeaponType) localStore.get(ABLocalStoreKeys
					.combineUserInstanceKey(this.key.callback(caster, localStore, castId), castId));
		} else {
			return (CWeaponType) localStore
					.get(ABLocalStoreKeys.combineUserKey(this.key.callback(caster, localStore, castId), castId));
		}
	}

}
