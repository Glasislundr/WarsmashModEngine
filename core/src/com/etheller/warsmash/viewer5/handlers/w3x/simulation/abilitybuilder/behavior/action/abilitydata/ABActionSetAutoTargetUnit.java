package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.abilitydata;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionSetAutoTargetUnit implements ABSingleAction {

	private ABUnitCallback unit;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		localStore.put(ABLocalStoreKeys.ABILITYTARGETEDUNIT + castId,
				this.unit.callback(caster, localStore, castId));
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return jassTextGenerator.setUserData(
				ABLocalStoreKeys.ABILITYTARGETEDUNIT + " + " + jassTextGenerator.getCastId(),
				JassTextGeneratorType.UnitHandle, this.unit.generateJassEquivalent(jassTextGenerator));
	}
}
