package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItem;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAbilityTargetedItem extends ABItemCallback {

	@Override
	public CItem callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (CItem) localStore.get(ABLocalStoreKeys.ABILITYTARGETEDITEM + castId);
	}

}
