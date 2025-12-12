package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackInlineConditionDestructable extends ABDestructableCallback {

	private ABCondition condition;
	private ABDestructableCallback pass;
	private ABDestructableCallback fail;
	
	@Override
	public CDestructable callback(CUnit caster, LocalDataStore localStore, int castId) {
		if (condition != null && condition.callback(caster, localStore, castId)) {
			return pass.callback(caster, localStore, castId);
		}
		return fail.callback(caster, localStore, castId);
	}

}
