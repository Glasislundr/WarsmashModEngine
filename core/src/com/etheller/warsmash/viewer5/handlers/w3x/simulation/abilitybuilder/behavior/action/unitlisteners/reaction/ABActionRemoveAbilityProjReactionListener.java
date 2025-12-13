
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.reaction;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener.ABAbilityProjReactionListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionRemoveAbilityProjReactionListener implements ABAction {

	private ABUnitCallback targetUnit;
	private ABAbilityProjReactionListenerCallback listener;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		CUnit target = targetUnit.callback(caster, localStore, castId);

		target.removeAbilityProjReactionListener(listener.callback(caster, localStore, castId));
	}
}