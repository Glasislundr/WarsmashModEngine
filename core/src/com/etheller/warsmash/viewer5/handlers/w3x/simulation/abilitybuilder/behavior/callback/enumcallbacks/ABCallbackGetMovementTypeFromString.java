package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.environment.PathingGrid.MovementType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetMovementTypeFromString extends ABMovementTypeCallback {

	private ABStringCallback id;

	@Override
	public MovementType callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		return MovementType.valueOf(this.id.callback(caster, localStore, castId));
	}

}
