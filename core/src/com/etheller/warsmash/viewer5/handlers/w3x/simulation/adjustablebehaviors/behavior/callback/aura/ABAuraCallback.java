package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.aura;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer.ABAuraEffect;

public abstract class ABAuraCallback implements ABCallback {

	abstract public ABAuraEffect callback(final CUnit caster, final ABLocalDataStore localStore, final int castId);

}
