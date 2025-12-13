package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.numeric;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIntegerNe extends ABCondition {

	private ABIntegerCallback value1;
	private ABIntegerCallback value2;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		Integer v1 = value1.callback(caster, localStore, castId);
		Integer v2 = value2.callback(caster, localStore, castId);
		return !v1.equals(v2);
	}

}
