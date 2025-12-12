package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitgroupcallbacks;

import java.util.Set;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitGroupByName extends ABUnitGroupCallback {

	private String name;

	@SuppressWarnings("unchecked")
	@Override
	public Set<CUnit> callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (Set<CUnit>) localStore.get("_unitgroup_" + name);
	}
}
