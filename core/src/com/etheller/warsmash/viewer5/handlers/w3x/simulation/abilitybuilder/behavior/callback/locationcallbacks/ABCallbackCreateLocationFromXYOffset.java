package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCreateLocationFromXYOffset extends ABLocationCallback {

	private ABLocationCallback origin;
	private ABFloatCallback xdist;
	private ABFloatCallback ydist;

	@Override
	public AbilityPointTarget callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		final AbilityPointTarget orig = this.origin.callback(game, caster, localStore, castId);
		return new AbilityPointTarget((float) (orig.x + xdist.callback(game, caster, localStore, castId)),
				(float) (orig.y + ydist.callback(game, caster, localStore, castId)));
	}

}
