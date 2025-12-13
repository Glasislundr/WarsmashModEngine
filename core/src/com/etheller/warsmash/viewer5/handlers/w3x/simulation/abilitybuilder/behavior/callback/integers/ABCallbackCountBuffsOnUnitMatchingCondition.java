package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbilityCategory;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCountBuffsOnUnitMatchingCondition extends ABIntegerCallback {

	private ABUnitCallback unit;
	private ABCondition condition;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CUnit u = caster;
		if (unit != null) {
			u = unit.callback(caster, localStore, castId);
		}
		int c = 0;
		for (CAbility ability : u.getAbilities()) {
			if (ability.getAbilityCategory() == CAbilityCategory.BUFF) {
				CBuff buff = (CBuff) ability;
				localStore.put(ABLocalStoreKeys.MATCHINGBUFF, buff);
				if (condition != null && condition.callback(caster, localStore, castId)) {
					c++;
				}
			}
		}
		
		return c;
	}

}
