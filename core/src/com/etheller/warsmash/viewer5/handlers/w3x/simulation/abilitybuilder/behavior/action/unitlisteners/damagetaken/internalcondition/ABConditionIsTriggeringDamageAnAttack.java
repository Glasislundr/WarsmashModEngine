package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.damagetaken.internalcondition;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

public class ABConditionIsTriggeringDamageAnAttack extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId)).getPrimaryDamageFlags()
				.isAttack();
	}

}
