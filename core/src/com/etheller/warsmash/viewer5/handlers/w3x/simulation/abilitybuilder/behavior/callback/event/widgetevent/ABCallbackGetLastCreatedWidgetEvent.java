package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.widgetevent;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABWidgetEvent;

public class ABCallbackGetLastCreatedWidgetEvent extends ABWidgetEventCallback {

	@Override
	public ABWidgetEvent callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (ABWidgetEvent) localStore.get(ABLocalStoreKeys.LASTCREATEDWIDEVENT);
	}

}
