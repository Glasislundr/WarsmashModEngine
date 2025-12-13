package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.attack;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttack;

public class ABConditionIsAttackProjectile extends ABBooleanCallback {

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return ((CUnitAttack) localStore.get(ABLocalStoreKeys.THEATTACK + castId)).getWeaponType().isProjectile();
	}

}
