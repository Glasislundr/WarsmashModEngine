package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.widgetevent;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABWidgetEvent;

public class ABCallbackInlineConditionWidgetEvent extends ABWidgetEventCallback {

	private ABCondition condition;
	private ABWidgetEventCallback pass;
	private ABWidgetEventCallback fail;
	
	@Override
	public ABWidgetEvent callback(CUnit caster, ABLocalDataStore localStore, int castId) {
		if (condition != null && condition.callback(caster, localStore, castId)) {
			return pass.callback(caster, localStore, castId);
		}
		return fail.callback(caster, localStore, castId);
	}

}
