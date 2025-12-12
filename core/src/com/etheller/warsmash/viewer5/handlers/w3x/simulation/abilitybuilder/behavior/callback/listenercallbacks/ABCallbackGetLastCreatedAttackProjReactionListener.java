package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAttackProjReactionListener;

public class ABCallbackGetLastCreatedAttackProjReactionListener extends ABAttackProjReactionListenerCallback {

	@Override
	public ABAttackProjReactionListener callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (ABAttackProjReactionListener) localStore.get(ABLocalStoreKeys.LASTCREATEDAtkPRL);
	}

}
