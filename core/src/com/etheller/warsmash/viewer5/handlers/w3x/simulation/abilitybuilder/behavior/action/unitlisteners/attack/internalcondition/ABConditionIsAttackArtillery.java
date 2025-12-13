package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.attack.internalcondition;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttack;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttackMissileLine;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttackMissileSplash;

public class ABConditionIsAttackArtillery extends ABCondition {
	
	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CUnitAttack attack = (CUnitAttack) localStore.get(ABLocalStoreKeys.THEATTACK+castId);
		if (attack instanceof CUnitAttackMissileSplash) {
			return ((CUnitAttackMissileSplash)attack).isArtillery();
		}
		if (attack instanceof CUnitAttackMissileLine) {
			return ((CUnitAttackMissileLine)attack).isArtillery();
		}
		return false;
	}

}
