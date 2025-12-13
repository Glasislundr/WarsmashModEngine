package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.timeevent;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABTimeOfDayEvent;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser.ABAbilityBuilderConfiguration;

public class ABCallbackReuseTimeOfDayEvent extends ABTimeOfDayEventCallback {

	private ABStringCallback name;

	@Override
	public ABTimeOfDayEvent callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		final ABAbilityBuilderConfiguration config = ((ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY))
				.getConfig();
		final String keyS = name.callback(caster, localStore, castId);
		if (config.getReuseCallbacks() != null) {
			ABCallback callback = config.getReuseCallbacks().get(keyS);
			if (callback != null && callback instanceof ABTimeOfDayEventCallback) {
				return ((ABTimeOfDayEventCallback) callback).callback(caster, localStore, castId);
			} else {
				System.err.println("Trying to run ReuseTimeOfDayEventCallback, but key is missing or callback was the wrong type: " + keyS);
			}
		} else {
			System.err.println("Trying to run ReuseTimeOfDayEventCallback, but none defined");
		}
		return null;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
