package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemodcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABCallbackGetLastCreatedStateModBuff extends ABStateModBuffCallback {

	@Override
	public StateModBuff callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return (StateModBuff) localStore.get(ABLocalStoreKeys.LASTCREATEDSMB);
	}

}
