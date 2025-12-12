package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionAddAbility implements ABSingleAction {

	private ABUnitCallback unit;
	private ABAbilityCallback ability;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final CAbility theAbility = this.ability.callback(caster, localStore, castId);
		CUnit theUnit = caster;
		if (unit != null) {
			theUnit = unit.callback(caster, localStore, castId);
		}
		if (theAbility != null) {
			theUnit.add(localStore.game, theAbility);
			localStore.put(ABLocalStoreKeys.LASTADDEDABILITY, theAbility);
		}
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "AddUnitAbilityAU(" + jassTextGenerator.getTriggerLocalStore() + ", "
				+ this.unit.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.ability.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
