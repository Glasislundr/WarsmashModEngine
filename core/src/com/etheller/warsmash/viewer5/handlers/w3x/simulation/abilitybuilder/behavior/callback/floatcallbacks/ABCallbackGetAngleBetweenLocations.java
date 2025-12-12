package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAngleBetweenLocations extends ABFloatCallback {

	private ABLocationCallback origin;
	private ABLocationCallback target;

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		final AbilityPointTarget o = this.origin.callback(caster, localStore, castId);
		final AbilityPointTarget t = this.target.callback(caster, localStore, castId);

		final double dx = t.getX() - o.getX();
		final double dy = t.getY() - o.getY();
		return (float) StrictMath.atan2(dy, dx);
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "AngleBetweenPointsAU(" + this.origin.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.target.generateJassEquivalent(jassTextGenerator) + ")";
	}

}
