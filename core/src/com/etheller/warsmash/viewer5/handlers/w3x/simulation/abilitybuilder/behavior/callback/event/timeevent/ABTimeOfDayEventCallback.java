package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.timeevent;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABTimeOfDayEvent;

public abstract class ABTimeOfDayEventCallback implements ABCallback {

	abstract public ABTimeOfDayEvent callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId);

}
