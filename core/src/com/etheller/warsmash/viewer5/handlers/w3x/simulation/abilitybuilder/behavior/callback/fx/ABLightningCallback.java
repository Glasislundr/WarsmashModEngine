package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.fx;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponentLightning;

public abstract class ABLightningCallback implements ABCallback {

	abstract public SimulationRenderComponentLightning callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId);
}
