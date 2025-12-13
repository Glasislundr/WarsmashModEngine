package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionResurrect implements ABSingleAction {

	private ABUnitCallback target;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, final int castId) {
		final CUnit targetUnit = this.target.callback(caster, localStore, castId);
		if (targetUnit.isDead()) {
			targetUnit.resurrect(localStore.game);
		}
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "ResurrectUnit(" + this.target.generateJassEquivalent(jassTextGenerator) + ")";
	}

}
