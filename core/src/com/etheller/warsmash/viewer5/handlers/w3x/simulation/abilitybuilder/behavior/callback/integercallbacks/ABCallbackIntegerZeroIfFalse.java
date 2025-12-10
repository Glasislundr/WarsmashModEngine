package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackIntegerZeroIfFalse extends ABIntegerCallback {

	private ABIntegerCallback value;
	private ABBooleanCallback bool;
	
	@Override
	public Integer callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		if (bool == null || !bool.callback(game, caster, localStore, castId)) {
			return 0;
		}
		return value.callback(game, caster, localStore, castId);
	}

}
