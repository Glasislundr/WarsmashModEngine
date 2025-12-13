package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemod;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABCallbackGetLastCreatedStateModBuff extends ABStateModBuffCallback {

	@Override
	public StateModBuff callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (StateModBuff) localStore.get(ABLocalStoreKeys.LASTCREATEDSMB);
	}

}
