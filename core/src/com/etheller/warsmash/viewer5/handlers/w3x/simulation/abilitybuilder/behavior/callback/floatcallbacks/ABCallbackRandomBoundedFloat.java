package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackRandomBoundedFloat extends ABFloatCallback {

	private ABFloatCallback bound;

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return localStore.game.getSeededRandom().nextFloat(bound.callback(caster, localStore, castId));
	}

}
