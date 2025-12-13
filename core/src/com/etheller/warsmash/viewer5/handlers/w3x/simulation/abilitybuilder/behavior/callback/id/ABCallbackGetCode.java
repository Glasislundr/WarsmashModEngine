package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetCode extends ABIDCallback {

	private ABAbilityCallback ability;
	
	@Override
	public War3ID callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		if (ability != null) {
			return ability.callback(caster, localStore, castId).getCode();
		}
		return (War3ID) localStore.get(ABLocalStoreKeys.CODE);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_ALIAS", JassTextGeneratorType.Integer);
	}

}
