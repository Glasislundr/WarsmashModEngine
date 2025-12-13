package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnitType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.handler.RandomTypeHandler;

public class ABCallbackRandomMechanicalCritterId extends ABIDCallback {

	@Override
	public War3ID callback(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnitType id = RandomTypeHandler.getRandomMechanicalCritterType(localStore.game);
		if (id == null) {
			return null;
		}
		return id.getTypeId();
	}

}
