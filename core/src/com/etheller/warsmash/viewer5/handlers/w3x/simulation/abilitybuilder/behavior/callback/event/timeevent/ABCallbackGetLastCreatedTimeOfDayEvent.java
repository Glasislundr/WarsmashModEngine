package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.timeevent;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABTimeOfDayEvent;

public class ABCallbackGetLastCreatedTimeOfDayEvent extends ABTimeOfDayEventCallback {

	@Override
	public ABTimeOfDayEvent callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return (ABTimeOfDayEvent) localStore.get(ABLocalStoreKeys.LASTCREATEDTODEVENT);
	}

}
