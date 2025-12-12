package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalCallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

public class ABCallbackGetRawTotalDamageDealt extends ABFloatCallback {
	
	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC+castId)).computeRawTotalDamage();
	}

}
