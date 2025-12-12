package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDefenseType;

public class ABCallbackGetUnitDefenseType extends ABDefenseTypeCallback {

	private ABUnitCallback unit;

	@Override
	public CDefenseType callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		return unit.callback(caster, localStore, castId).getDefenseType();
	}

}
