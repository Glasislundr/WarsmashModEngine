package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.eventcallbacks.timeeventcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABTimeOfDayEvent;

public class ABCallbackInlineConditionTimeOfDayEvent extends ABTimeOfDayEventCallback {

	private ABCondition condition;
	private ABTimeOfDayEventCallback pass;
	private ABTimeOfDayEventCallback fail;

	@Override
	public ABTimeOfDayEvent callback(CUnit caster, LocalDataStore localStore, int castId) {
		if (condition != null && condition.callback(caster, localStore, castId)) {
			return pass.callback(caster, localStore, castId);
		}
		return fail.callback(caster, localStore, castId);
	}

}
