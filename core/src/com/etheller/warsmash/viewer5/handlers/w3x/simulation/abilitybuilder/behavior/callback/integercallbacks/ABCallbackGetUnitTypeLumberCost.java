package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitTypeLumberCost extends ABIntegerCallback {

	private ABIDCallback id;
	
	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return localStore.game.getUnitData().getUnitType(id.callback(caster, localStore, castId)).getLumberCost();
	}

}
