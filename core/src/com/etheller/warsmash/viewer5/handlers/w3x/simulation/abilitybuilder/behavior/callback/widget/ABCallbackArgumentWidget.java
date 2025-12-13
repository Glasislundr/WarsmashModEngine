package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackArgumentWidget extends ABWidgetCallback {

	private ABStringCallback name;

	@Override
	public CWidget callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		final String keyS = name.callback(caster, localStore, castId);
		ABCallback cbck = (ABCallback) localStore.get(ABLocalStoreKeys.combineArgumentKey(keyS));
		if (cbck != null && cbck instanceof ABWidgetCallback) {
			return ((ABWidgetCallback) cbck).callback(caster, localStore, castId);
		} else {
			System.err.println("Trying to run ReuseWidgetCallback, but key is missing or callback was the wrong type: " + keyS);
		}
		return null;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
