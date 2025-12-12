package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.abilities;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionAbilityRemoveUniqueFlag implements ABSingleAction {

	private ABAbilityCallback ability;
	private ABStringCallback flag;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final CAbility theAbility = this.ability.callback(caster, localStore, castId);
		if (theAbility instanceof AbilityBuilderAbility) {
			((AbilityBuilderAbility) theAbility).removeUniqueFlag(flag.callback(caster, localStore, castId));
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "JASSTODO";
	}
}
