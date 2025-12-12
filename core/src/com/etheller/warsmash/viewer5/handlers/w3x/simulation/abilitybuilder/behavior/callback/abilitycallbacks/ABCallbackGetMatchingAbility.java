package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetMatchingAbility extends ABAbilityCallback {

	@Override
	public CAbility callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (CAbility) localStore.get(ABLocalStoreKeys.MATCHINGABILITY);
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_MATCHINGABILITY",
				JassTextGeneratorType.AbilityHandle);
	}

}
