package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.fxcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponentLightning;

public class ABCallbackGetLastCreatedLightningEffect extends ABLightningCallback {

	@Override
	public SimulationRenderComponentLightning callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (SimulationRenderComponentLightning) localStore.get(ABLocalStoreKeys.LASTCREATEDLIGHTNING);
	}

}
