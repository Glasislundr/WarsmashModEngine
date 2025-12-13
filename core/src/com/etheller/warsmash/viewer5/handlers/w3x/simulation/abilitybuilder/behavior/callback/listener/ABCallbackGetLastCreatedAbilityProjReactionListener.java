package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAbilityProjReactionListener;

public class ABCallbackGetLastCreatedAbilityProjReactionListener extends ABAbilityProjReactionListenerCallback {

	@Override
	public ABAbilityProjReactionListener callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (ABAbilityProjReactionListener) localStore.get(ABLocalStoreKeys.LASTCREATEDAbPRL);
	}

}
