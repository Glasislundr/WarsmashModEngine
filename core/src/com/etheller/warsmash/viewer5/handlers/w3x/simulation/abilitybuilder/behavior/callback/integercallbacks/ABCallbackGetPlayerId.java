package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.player.ABPlayerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetPlayerId extends ABIntegerCallback {

	private ABPlayerCallback player;
	
	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return player.callback(caster, localStore, castId).getId();
	}

}
