package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAbilityEffectReactionListener;

public class ABCallbackGetLastCreatedAbilityEffectReactionListener extends ABAbilityEffectReactionListenerCallback {

	@Override
	public ABAbilityEffectReactionListener callback(CUnit caster, ABLocalDataStore localStore,
			final int castId) {
		return (ABAbilityEffectReactionListener) localStore.get(ABLocalStoreKeys.LASTCREATEDAbERL);
	}

}
