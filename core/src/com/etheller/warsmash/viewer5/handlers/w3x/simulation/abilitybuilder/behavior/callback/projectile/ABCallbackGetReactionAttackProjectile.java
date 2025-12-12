package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.projectile;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CProjectile;

public class ABCallbackGetReactionAttackProjectile extends ABProjectileCallback {

	@Override
	public CProjectile callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (CProjectile) localStore.get(ABLocalStoreKeys.ATTACKPROJ+castId);
	}

}
