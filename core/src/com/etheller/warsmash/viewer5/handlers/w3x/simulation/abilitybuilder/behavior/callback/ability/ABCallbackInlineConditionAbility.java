package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackInlineConditionAbility extends ABAbilityCallback {

	private ABCondition condition;
	private ABAbilityCallback pass;
	private ABAbilityCallback fail;
	
	@Override
	public CAbility callback(CUnit caster, ABLocalDataStore localStore, int castId) {
		if (condition != null && condition.callback(caster, localStore, castId)) {
			return pass.callback(caster, localStore, castId);
		}
		return fail.callback(caster, localStore, castId);
	}

}
