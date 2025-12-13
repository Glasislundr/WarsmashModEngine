package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.uniqueflag;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionDoesAbilityHaveUniqueFlag extends ABCondition {

	ABAbilityCallback ability;
	ABStringCallback flag;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CAbility theAbility = ability.callback(caster, localStore, castId);
		return theAbility.hasUniqueFlag(flag.callback(caster, localStore, castId));
	}

}
