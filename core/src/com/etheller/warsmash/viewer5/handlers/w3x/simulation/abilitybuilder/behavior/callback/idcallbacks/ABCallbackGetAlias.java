package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAlias extends ABIDCallback {

	@Override
	public War3ID callback(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		return (War3ID) localStore.get(ABLocalStoreKeys.ALIAS);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_ALIAS", JassTextGeneratorType.Integer);
	}

}
