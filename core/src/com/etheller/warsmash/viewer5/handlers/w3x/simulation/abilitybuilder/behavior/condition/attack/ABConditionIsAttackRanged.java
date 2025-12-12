package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.attack;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttack;

public class ABConditionIsAttackRanged extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return ((CUnitAttack) localStore.get(ABLocalStoreKeys.THEATTACK + castId)).getWeaponType().isRanged();
	}

}
