package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.fx;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponentLightning;

public class ABCallbackGetLastCreatedLightningEffect extends ABLightningCallback {

	@Override
	public SimulationRenderComponentLightning callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (SimulationRenderComponentLightning) localStore.get(ABLocalStoreKeys.LASTCREATEDLIGHTNING);
	}

}
