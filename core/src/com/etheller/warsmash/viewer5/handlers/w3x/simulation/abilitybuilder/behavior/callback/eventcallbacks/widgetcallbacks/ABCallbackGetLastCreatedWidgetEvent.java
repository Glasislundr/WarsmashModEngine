package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.eventcallbacks.widgetcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABWidgetEvent;

public class ABCallbackGetLastCreatedWidgetEvent extends ABWidgetEventCallback {

	@Override
	public ABWidgetEvent callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return (ABWidgetEvent) localStore.get(ABLocalStoreKeys.LASTCREATEDWIDEVENT);
	}

}
