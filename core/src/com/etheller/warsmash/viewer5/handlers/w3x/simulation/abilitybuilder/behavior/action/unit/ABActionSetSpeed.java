package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionSetSpeed implements ABAction {

	private ABUnitCallback unit;
	private ABIntegerCallback value;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, final int castId) {
		final CUnit targetUnit = this.unit.callback(caster, localStore, castId);
		targetUnit.setSpeed(value.callback(caster, localStore, castId));
	}

}
