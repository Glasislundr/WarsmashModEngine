
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks.ABDeathReplacementPriorityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.ABDeathReplacementCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveDeathReplacementEffect implements ABAction {

	private ABUnitCallback target;
	private ABDeathReplacementPriorityCallback priority;
	private ABDeathReplacementCallback listener;

	public void runAction(final CSimulation game, final CUnit caster,
			final LocalDataStore localStore, final int castId) {
		target.callback(game, caster, localStore, castId).removeDeathReplacementEffect(
				priority.callback(game, caster, localStore, castId), listener.callback(game, caster, localStore, castId));
	}
}