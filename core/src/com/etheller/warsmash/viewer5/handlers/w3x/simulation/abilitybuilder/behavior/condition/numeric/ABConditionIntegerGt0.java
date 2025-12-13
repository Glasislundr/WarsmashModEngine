package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.numeric;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIntegerGt0 extends ABCondition {

	private ABIntegerCallback value;
	
	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		Integer v1 = value.callback(caster, localStore, castId);
		return v1 > 0;
	}

}
