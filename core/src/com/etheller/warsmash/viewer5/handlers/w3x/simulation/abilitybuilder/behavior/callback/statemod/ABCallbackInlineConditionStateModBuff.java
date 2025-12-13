package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemod;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABCallbackInlineConditionStateModBuff extends ABStateModBuffCallback {

	private ABCondition condition;
	private ABStateModBuffCallback pass;
	private ABStateModBuffCallback fail;
	
	@Override
	public StateModBuff callback(CUnit caster, ABLocalDataStore localStore, int castId) {
		if (condition != null && condition.callback(caster, localStore, castId)) {
			return pass.callback(caster, localStore, castId);
		}
		return fail.callback(caster, localStore, castId);
	}

}
