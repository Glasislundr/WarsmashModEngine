package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.list.ABSortableListCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetIntegerFromList extends ABIntegerCallback {

	private ABSortableListCallback<Integer> list;
	private ABIntegerCallback index;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return list.callback(caster, localStore, castId).get(index.callback(caster, localStore, castId));
	}

}
