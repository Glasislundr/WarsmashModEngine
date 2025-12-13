package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.logical;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionBool extends ABBooleanCallback {

	private ABBooleanCallback bool;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return bool.callback(caster, localStore, castId);
	}

}
