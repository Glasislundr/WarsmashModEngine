
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.ABDamageTakenListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveDamageTakenListener implements ABAction {

	private ABUnitCallback targetUnit;
	private ABDamageTakenListenerCallback listener;

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnit target = targetUnit.callback(caster, localStore, castId);
		
		target.removeDamageTakenListener(listener.callback(caster, localStore, castId));
	}
}