package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAttackEvasionListener;

public class ABCallbackGetLastCreatedEvasionListener extends ABEvasionListenerCallback {

	@Override
	public ABAttackEvasionListener callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (ABAttackEvasionListener) localStore.get(ABLocalStoreKeys.LASTCREATEDAEL);
	}

}
