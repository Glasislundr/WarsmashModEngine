package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit.buff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionDoesUnitHaveBuffMatchingCondition extends ABCondition {

	private ABUnitCallback unit;
	private ABBooleanCallback condition;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CUnit theUnit = caster;
		if (unit != null) {
			theUnit = unit.callback(caster, localStore, castId);
		}
		if (theUnit != null) {
			for (CAbility ability : theUnit.getAbilities()) {
				if (ability instanceof CBuff) {
					localStore.put(ABLocalStoreKeys.MATCHINGBUFF, ability);
					if (condition.callback(caster, localStore, castId)) {
						localStore.remove(ABLocalStoreKeys.MATCHINGBUFF);
						return true;
					}
					localStore.remove(ABLocalStoreKeys.MATCHINGBUFF);
				}
			}
		}
		return false;
	}

}
