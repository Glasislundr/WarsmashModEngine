package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.list.ABListCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetLocationFromList extends ABLocationCallback {

	private ABListCallback<AbilityPointTarget> list;
	private ABIntegerCallback index;

	@Override
	public AbilityPointTarget callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return list.callback(caster, localStore, castId).get(index.callback(caster, localStore, castId));
	}

}
