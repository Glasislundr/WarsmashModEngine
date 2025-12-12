package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionFinishChanneling implements ABSingleAction {

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		localStore.put(ABLocalStoreKeys.CHANNELING, false);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.setUserData(ABLocalStoreKeys.CHANNELING, JassTextGeneratorType.Boolean, "false");
	}
}
