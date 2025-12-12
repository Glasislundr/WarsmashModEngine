package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbilityCategory;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionDoesUnitHaveAbilityMatchingCondition extends ABCondition {

	private ABUnitCallback unit;
	private ABBooleanCallback condition;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CUnit theUnit = caster;
		if (unit != null) {
			theUnit = unit.callback(caster, localStore, castId);
		}
		if (theUnit != null) {
			for (CAbility ability : theUnit.getAbilities()) {
				if (CAbilityCategory.BUFF != ability.getAbilityCategory()) {
					localStore.put(ABLocalStoreKeys.MATCHINGABILITY, ability);
					if (condition.callback(caster, localStore, castId)) {
						localStore.remove(ABLocalStoreKeys.MATCHINGABILITY);
						return true;
					}
				}
			}
		}
		localStore.remove(ABLocalStoreKeys.MATCHINGABILITY);
		return false;
	}

}
