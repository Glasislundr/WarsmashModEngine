package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.reaction.internalcallback;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CAttackProjectile;

public class ABCallbackGetReactionAttackProjectileDamage extends ABFloatCallback {
	
	@Override
	public Float callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return ((CAttackProjectile) localStore.get(ABLocalStoreKeys.ATTACKPROJ+castId)).getDamage();
	}

}
