package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructablebuff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackMatchingDestructableBuff extends ABDestructableBuffCallback {

	@Override
	public CDestructableBuff callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (CDestructableBuff) localStore.get(ABLocalStoreKeys.MATCHINGDESTBUFF);
	}

}
