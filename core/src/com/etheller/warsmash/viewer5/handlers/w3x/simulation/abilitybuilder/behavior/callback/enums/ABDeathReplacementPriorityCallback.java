package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitDeathReplacementEffectPriority;

public abstract class ABDeathReplacementPriorityCallback implements ABCallback {

	abstract public CUnitDeathReplacementEffectPriority callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId);
}
