package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitgroup;

import java.util.Set;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public abstract class ABUnitGroupCallback implements ABCallback {

	abstract public Set<CUnit> callback(final CUnit caster, final ABLocalDataStore localStore, final int castId);
}
