package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitDeathReplacementEffectPriority;

public class ABCallbackRawDeathEffectPriority extends ABDeathReplacementPriorityCallback {

	private CUnitDeathReplacementEffectPriority priority;
	
	@Override
	public CUnitDeathReplacementEffectPriority callback(CUnit caster, LocalDataStore localStore,
			final int castId) {
		return priority;
	}

}
