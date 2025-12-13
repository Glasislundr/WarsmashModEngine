package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItem;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackArgumentItem extends ABItemCallback {

	private ABStringCallback name;

	@Override
	public CItem callback(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		final String keyS = name.callback(caster, localStore, castId);
		ABCallback cbck = (ABCallback) localStore.get(ABLocalStoreKeys.combineArgumentKey(keyS));
		if (cbck != null && cbck instanceof ABItemCallback) {
			return ((ABItemCallback) cbck).callback(caster, localStore, castId);
		} else {
			System.err.println(
					"Trying to run ReuseItemCallback, but key is missing or callback was the wrong type: " + keyS);
		}
		return null;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
