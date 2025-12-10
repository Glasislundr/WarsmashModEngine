package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackCreateOwnershipData extends ABLongCallback {

	private ABIntegerCallback priority;
	private ABIntegerCallback playerId;

	@Override
	public Long callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		long ply = playerId.callback(game, caster, localStore, castId);
		int val = Math.min(priority.callback(game, caster, localStore, castId), 15) & 0b1111;
		return val + (ply << 4);
	}

}
