package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetLastCreatedDestructable extends ABDestructableCallback {

	@Override
	public CDestructable callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		return (CDestructable) localStore.get(ABLocalStoreKeys.LASTCREATEDDESTRUCTABLE);
	}

}
