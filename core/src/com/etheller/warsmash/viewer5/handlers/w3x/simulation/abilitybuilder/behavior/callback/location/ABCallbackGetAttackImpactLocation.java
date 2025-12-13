package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetAttackImpactLocation extends ABLocationCallback {

	@Override
	public AbilityPointTarget callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return  (AbilityPointTarget) localStore.get(ABLocalStoreKeys.ATTACKIMPACTLOCATION+castId);
	}

}
