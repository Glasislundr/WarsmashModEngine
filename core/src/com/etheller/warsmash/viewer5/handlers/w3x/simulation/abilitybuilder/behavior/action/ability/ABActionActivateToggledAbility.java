package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderActiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionActivateToggledAbility implements ABSingleAction {

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		AbilityBuilderActiveAbility ability = (AbilityBuilderActiveAbility) localStore
				.get(ABLocalStoreKeys.ABILITY);
		ability.activate(localStore.game, caster);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "AbilityActivate(" + jassTextGenerator.getCaster() + ", " + jassTextGenerator
				.getUserDataExpr("AB_LOCAL_STORE_KEY_TOGGLEDABILITY", JassTextGeneratorType.AbilityHandle) + ")";
	}
}
