package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDefenseType;

public class ABCallbackGetDefenseTypeFromString extends ABDefenseTypeCallback {

	private ABStringCallback id;

	@Override
	public CDefenseType callback(final CSimulation game, final CUnit caster,
			final LocalDataStore localStore,
			final int castId) {
		return CDefenseType.valueOf(this.id.callback(game, caster, localStore, castId));
	}

}
