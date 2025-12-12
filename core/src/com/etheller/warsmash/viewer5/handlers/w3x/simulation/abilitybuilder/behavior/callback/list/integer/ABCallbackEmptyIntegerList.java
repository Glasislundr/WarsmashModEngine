package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.list.integer;

import java.util.ArrayList;
import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackEmptyIntegerList extends ABIntegerListCallback {

	@Override
	public List<Integer> callback(CUnit caster, LocalDataStore localStore, int castId) {
		return new ArrayList<>();
	}

}
