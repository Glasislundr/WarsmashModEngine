package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalCallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks.ABAttackTypeCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CAttackType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CAttackProjectile;

public class ABCallbackGetReactionAttackProjectileAttackType extends ABAttackTypeCallback {

	@Override
	public CAttackType callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return ((CAttackProjectile) localStore.get(ABLocalStoreKeys.ATTACKPROJ + castId)).getUnitAttack()
				.getAttackType();
	}

}
