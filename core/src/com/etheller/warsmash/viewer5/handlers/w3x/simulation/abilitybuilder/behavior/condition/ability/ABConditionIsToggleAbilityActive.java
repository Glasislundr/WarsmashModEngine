package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ability;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderActiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsToggleAbilityActive extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		AbilityBuilderActiveAbility ability = (AbilityBuilderActiveAbility) localStore.get(ABLocalStoreKeys.ABILITY);

		return ability.isActive();
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "IsToggleAbilityActive("
				+ jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_ABILITY", JassTextGeneratorType.AbilityHandle)
				+ ")";
	}

}
