package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackCreateLocationFromXY extends ABLocationCallback {

	private ABFloatCallback x;
	private ABFloatCallback y;
	
	@Override
	public AbilityPointTarget callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return new AbilityPointTarget(x.callback(caster, localStore, castId), y.callback(caster, localStore, castId));
	}

}
