package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.environment.PathingGrid.MovementType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitTypeMovementType extends ABMovementTypeCallback {

	private ABIDCallback type;

	@Override
	public MovementType callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		War3ID theType = type.callback(caster, localStore, castId);
		return localStore.game.getUnitData().getUnitType(theType).getMovementType();
	}

}
