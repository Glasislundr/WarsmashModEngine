
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.ABAttackPostDamageListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionAddAttackPostDamageListener implements ABAction {

	private ABUnitCallback unit;
	private ABAttackPostDamageListenerCallback listener;

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnit target = unit.callback(caster, localStore, castId);
		
		target.addPostDamageListener(listener.callback(caster, localStore, castId));
	}
}