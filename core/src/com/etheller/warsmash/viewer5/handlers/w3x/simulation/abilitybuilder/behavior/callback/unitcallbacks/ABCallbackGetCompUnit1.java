package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetCompUnit1 extends ABUnitCallback {

	@Override
	public CUnit callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		return (CUnit) localStore.get(ABLocalStoreKeys.COMPUNIT1);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_COMPUNIT1", JassTextGeneratorType.UnitHandle);
	}

}
