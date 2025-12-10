package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackInlineConditionBoolean extends ABBooleanCallback {

	private ABCondition condition;
	private ABBooleanCallback pass;
	private ABBooleanCallback fail;

	@Override
	public Boolean callback(CSimulation game, CUnit caster, LocalDataStore localStore, int castBoolean) {
		if (condition != null && condition.callback(game, caster, localStore, castBoolean)) {
			return pass.callback(game, caster, localStore, castBoolean);
		}
		return fail.callback(game, caster, localStore, castBoolean);
	}

}
