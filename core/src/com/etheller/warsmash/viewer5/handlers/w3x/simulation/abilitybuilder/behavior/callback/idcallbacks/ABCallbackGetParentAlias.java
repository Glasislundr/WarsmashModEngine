package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetParentAlias extends ABIDCallback {

	@SuppressWarnings("unchecked")
	@Override
	public War3ID callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (War3ID) ((LocalDataStore) localStore.get(ABLocalStoreKeys.PARENTLOCALSTORE))
				.get(ABLocalStoreKeys.ALIAS);
	}

}
