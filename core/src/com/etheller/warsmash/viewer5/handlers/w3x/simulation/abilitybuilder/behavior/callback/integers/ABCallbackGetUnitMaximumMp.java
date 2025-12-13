package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitMaximumMp extends ABIntegerCallback {

	private ABUnitCallback unit;

	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return unit == null ? caster.getMaximumMana()
				: unit.callback(caster, localStore, castId).getMaximumMana();
	}

}
