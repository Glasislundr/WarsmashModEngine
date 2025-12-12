package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemodcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public abstract class ABStateModBuffCallback implements ABCallback {

	abstract public StateModBuff callback(final CUnit caster, final LocalDataStore localStore, final int castId);
}
