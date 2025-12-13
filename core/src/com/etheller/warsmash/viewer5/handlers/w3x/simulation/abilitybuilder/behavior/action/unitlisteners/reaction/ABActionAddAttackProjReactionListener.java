
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.reaction;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener.ABAttackProjReactionListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionAddAttackProjReactionListener implements ABAction {

	private ABUnitCallback targetUnit;
	private ABAttackProjReactionListenerCallback listener;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CUnit target = targetUnit.callback(caster, localStore, castId);
		
		target.addAttackProjReactionListener(listener.callback(caster, localStore, castId));
	}
}