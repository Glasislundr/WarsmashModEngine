package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbilityDisableType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionClickEnableAbility implements ABSingleAction {

	private ABAbilityCallback ability;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		if (this.ability != null) {
			final CAbility abil = ability.callback(caster, localStore, castId);
			if (abil != null) {
				abil.setClickDisabled(false, CAbilityDisableType.ABILITYINTERNAL);
			}
		} else {
			final ABAbilityBuilderAbility abil = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
			abil.setClickDisabled(false, CAbilityDisableType.ABILITYINTERNAL);
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		if (this.ability != null) {
			return "TODOJASS";
		} else {
			return "TODOJASS";
		}
	}
}
