package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.target.ABTargetCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCreateLocationFromTarget extends ABLocationCallback {

	private ABTargetCallback target;
	
	@Override
	public AbilityPointTarget callback(CUnit caster, LocalDataStore localStore, final int castId) {
		AbilityTarget tar = target.callback(caster, localStore, castId);
		return new AbilityPointTarget(tar.getX(), tar.getY());
	}

}
