package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.autocast.AutocastType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackConditionalAutocastType extends ABAutocastTypeCallback {

	private ABCondition condition;
	private ABAutocastTypeCallback value1;
	private ABAutocastTypeCallback value2;

	@Override
	public AutocastType callback(CUnit caster, LocalDataStore localStore, final int castId) {
		if (condition.callback(caster, localStore, castId)) {
			return value1.callback(caster, localStore, castId);
		}
		return value2.callback(caster, localStore, castId);
	}

}
