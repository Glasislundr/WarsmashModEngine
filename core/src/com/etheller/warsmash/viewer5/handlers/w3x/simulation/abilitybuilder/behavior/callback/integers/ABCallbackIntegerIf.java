package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackIntegerIf extends ABIntegerCallback {

	private ABIntegerCallback value1;
	private ABIntegerCallback value2;
	private ABCondition condition;
	
	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		if (condition == null || !condition.callback(caster, localStore, castId)) {
			return value2.callback(caster, localStore, castId);
		}
		return value1.callback(caster, localStore, castId);
	}

}
