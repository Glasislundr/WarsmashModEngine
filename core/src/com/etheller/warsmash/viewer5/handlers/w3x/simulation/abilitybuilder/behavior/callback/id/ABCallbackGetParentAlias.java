package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;

public class ABCallbackGetParentAlias extends ABIDCallback {

	@Override
	public War3ID callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (War3ID) ((ABLocalDataStore) localStore.get(ABLocalStoreKeys.PARENTLOCALSTORE))
				.get(ABLocalStoreKeys.ALIAS);
	}

}
