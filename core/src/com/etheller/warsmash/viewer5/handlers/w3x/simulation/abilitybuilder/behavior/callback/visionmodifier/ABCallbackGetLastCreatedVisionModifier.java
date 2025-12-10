package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.visionmodifier;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.vision.CFogModifier;

public class ABCallbackGetLastCreatedVisionModifier extends ABVisionModifierCallback {

	@Override
	public CFogModifier callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return (CFogModifier) localStore.get(ABLocalStoreKeys.LASTCREATEDVISIONMODIFIER);
	}

}
