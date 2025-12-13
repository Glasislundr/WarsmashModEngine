package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetProjectileDestructableTargets extends ABIntegerCallback {

	@Override
	public Integer callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (Integer) localStore.get(ABLocalStoreKeys.PROJECTILEDESTTARGETS + castId);
	}

}
