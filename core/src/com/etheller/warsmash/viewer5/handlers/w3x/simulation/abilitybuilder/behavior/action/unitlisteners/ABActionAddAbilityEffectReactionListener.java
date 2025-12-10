
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.ABAbilityEffectReactionListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionAddAbilityEffectReactionListener implements ABAction {

	private ABUnitCallback targetUnit;
	private ABAbilityEffectReactionListenerCallback listener;

	public void runAction(final CSimulation game, final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnit target = targetUnit.callback(game, caster, localStore, castId);

		target.addAbilityEffectReactionListener(listener.callback(game, caster, localStore, castId));
	}
}