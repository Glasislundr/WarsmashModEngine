package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.projectile;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser.ABAbilityBuilderConfiguration;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CProjectile;

public class ABCallbackReuseProjectile extends ABProjectileCallback {

	private ABStringCallback name;

	@Override
	public CProjectile callback(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		final ABAbilityBuilderConfiguration config = ((ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY))
				.getConfig();
		final String keyS = name.callback(caster, localStore, castId);
		if (config.getReuseCallbacks() != null) {
			ABCallback callback = config.getReuseCallbacks().get(keyS);
			if (callback != null && callback instanceof ABProjectileCallback) {
				return ((ABProjectileCallback) callback).callback(caster, localStore, castId);
			} else {
				System.err.println(
						"Trying to run ReuseProjectileCallback, but key is missing or callback was the wrong type: "
								+ keyS);
			}
		} else {
			System.err.println("Trying to run ReuseProjectileCallback, but none defined");
		}
		return null;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
