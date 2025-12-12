package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.targetcallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackArgumentTarget extends ABTargetCallback {

	private ABStringCallback name;

	@Override
	public AbilityTarget callback(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final String keyS = name.callback(caster, localStore, castId);
		ABCallback cbck = (ABCallback) localStore.get(ABLocalStoreKeys.combineArgumentKey(keyS));
		if (cbck != null && cbck instanceof ABTargetCallback) {
			return ((ABTargetCallback) cbck).callback(caster, localStore, castId);
		} else {
			System.err.println("Trying to run ReuseTargetCallback, but key is missing or callback was the wrong type: " + keyS);
		}
		return null;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
