package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item.ABItemCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetItemType extends ABIDCallback {

	private ABItemCallback item;

	@Override
	public War3ID callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return item.callback(caster, localStore, castId).getTypeId();
	}

}
