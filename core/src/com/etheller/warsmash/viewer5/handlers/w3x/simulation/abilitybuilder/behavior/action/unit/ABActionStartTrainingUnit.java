package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionStartTrainingUnit implements ABSingleAction {

	private ABUnitCallback unit;
	private ABIDCallback id;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final CUnit theUnit = this.unit.callback(caster, localStore, castId);
		theUnit.queueTrainingUnit(localStore.game, this.id.callback(caster, localStore, castId));
		theUnit.notifyOrdersChanged();
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "StartTrainingUnit(" + this.unit.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.id.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
