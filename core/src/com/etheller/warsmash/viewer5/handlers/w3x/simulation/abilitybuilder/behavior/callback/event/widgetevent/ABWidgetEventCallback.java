package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.widgetevent;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABWidgetEvent;

public abstract class ABWidgetEventCallback implements ABCallback {

	abstract public ABWidgetEvent callback(final CUnit caster, final ABLocalDataStore localStore, final int castId);

}
