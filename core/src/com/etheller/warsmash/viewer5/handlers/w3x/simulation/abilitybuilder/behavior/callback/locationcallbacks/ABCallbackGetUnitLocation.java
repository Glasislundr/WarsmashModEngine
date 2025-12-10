package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitLocation extends ABLocationCallback {

	private ABUnitCallback unit;

	@Override
	public AbilityPointTarget callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		final CUnit theUnit = this.unit.callback(game, caster, localStore, castId);

		return new AbilityPointTarget(theUnit.getX(), theUnit.getY());
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "GetUnitLoc(" + this.unit.generateJassEquivalent(jassTextGenerator) + ")";
	}

}
