package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDefenseType;

public class ABCallbackGetUnitDefenseType extends ABDefenseTypeCallback {

	private ABUnitCallback unit;

	@Override
	public CDefenseType callback(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		return unit.callback(caster, localStore, castId).getDefenseType();
	}

}
