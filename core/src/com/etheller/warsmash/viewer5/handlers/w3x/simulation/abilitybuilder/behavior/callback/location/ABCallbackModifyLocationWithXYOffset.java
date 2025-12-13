package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackModifyLocationWithXYOffset extends ABLocationCallback {

	private ABLocationCallback origin;
	private ABFloatCallback xdist;
	private ABFloatCallback ydist;
	
	@Override
	public AbilityPointTarget callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final AbilityPointTarget orig = this.origin.callback(caster, localStore, castId);
		orig.add(xdist.callback(caster, localStore, castId), ydist.callback(caster, localStore, castId));
		return orig;
	}

}
