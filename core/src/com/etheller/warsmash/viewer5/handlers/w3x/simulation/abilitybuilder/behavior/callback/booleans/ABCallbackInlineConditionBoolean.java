package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackInlineConditionBoolean extends ABBooleanCallback {

	private ABCondition condition;
	private ABBooleanCallback pass;
	private ABBooleanCallback fail;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, int castBoolean) {
		if (condition != null && condition.callback(caster, localStore, castBoolean)) {
			return pass.callback(caster, localStore, castBoolean);
		}
		return fail.callback(caster, localStore, castBoolean);
	}

}
