package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buff;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetLastCreatedBuff extends ABBuffCallback {

	@Override
	public CBuff callback(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		return (CBuff) localStore.get(ABLocalStoreKeys.LASTCREATEDBUFF);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_LASTCREATEDBUFF",
				JassTextGeneratorType.BuffHandle);
	}

}
