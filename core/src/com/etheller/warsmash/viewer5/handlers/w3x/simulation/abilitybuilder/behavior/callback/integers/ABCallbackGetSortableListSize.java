package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.list.ABSortableListCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetSortableListSize extends ABIntegerCallback {

	private ABSortableListCallback<?> list;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return list.callback(caster, localStore, castId).size();
	}

}
