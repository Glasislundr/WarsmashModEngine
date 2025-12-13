package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetAliasAsString extends ABStringCallback {

	@Override
	public String callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return ((War3ID) localStore.get(ABLocalStoreKeys.ALIAS)).asStringValue();
	}

}
