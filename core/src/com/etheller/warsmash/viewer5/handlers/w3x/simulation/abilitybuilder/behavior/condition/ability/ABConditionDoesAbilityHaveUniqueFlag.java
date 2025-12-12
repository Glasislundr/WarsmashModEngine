package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ability;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionDoesAbilityHaveUniqueFlag extends ABCondition {

	ABAbilityCallback ability;
	ABStringCallback flag;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CAbility theAbility = ability.callback(caster, localStore, castId);
		return theAbility.hasUniqueFlag(flag.callback(caster, localStore, castId));
	}

}
