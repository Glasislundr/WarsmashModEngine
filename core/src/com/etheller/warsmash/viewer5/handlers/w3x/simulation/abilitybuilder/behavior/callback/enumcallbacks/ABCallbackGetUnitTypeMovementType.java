package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.environment.PathingGrid.MovementType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitTypeMovementType extends ABMovementTypeCallback {

	private ABIDCallback type;

	@Override
	public MovementType callback(final CSimulation game, final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		War3ID theType = type.callback(game, caster, localStore, castId);
		return game.getUnitData().getUnitType(theType).getMovementType();
	}

}
