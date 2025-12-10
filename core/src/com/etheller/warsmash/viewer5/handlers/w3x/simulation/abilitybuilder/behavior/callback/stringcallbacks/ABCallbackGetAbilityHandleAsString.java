package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAbilityHandleAsString extends ABStringCallback {

	private ABAbilityCallback ability;

	@Override
	public String callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return "" + ability.callback(game, caster, localStore, castId).getHandleId();
	}

}
