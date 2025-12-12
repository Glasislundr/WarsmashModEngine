package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.environment.PathingGrid.MovementType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetStoredMovementTypeByKey extends ABMovementTypeCallback {

	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public MovementType callback(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		if ((this.instanceValue == null) || this.instanceValue.callback(caster, localStore, castId)) {
			return (MovementType) localStore.get(ABLocalStoreKeys
					.combineUserInstanceKey(this.key.callback(caster, localStore, castId), castId));
		}
		else {
			return (MovementType) localStore
					.get(ABLocalStoreKeys.combineUserKey(this.key.callback(caster, localStore, castId), castId));
		}
	}

}
