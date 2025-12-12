package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.player;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.CPlayer;

public class ABCallbackGetOwnerOfUnit extends ABPlayerCallback {

	private ABUnitCallback unit;

	@Override
	public CPlayer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return localStore.game.getPlayer(unit.callback(caster, localStore, castId).getPlayerIndex());
	}

}
