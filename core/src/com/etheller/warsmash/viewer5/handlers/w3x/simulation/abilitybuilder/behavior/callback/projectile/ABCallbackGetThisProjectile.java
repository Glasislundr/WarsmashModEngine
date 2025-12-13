package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.projectile;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CProjectile;

public class ABCallbackGetThisProjectile extends ABProjectileCallback {

	@Override
	public CProjectile callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (CProjectile) localStore.get(ABLocalStoreKeys.THISPROJECTILE+castId);
	}

}
