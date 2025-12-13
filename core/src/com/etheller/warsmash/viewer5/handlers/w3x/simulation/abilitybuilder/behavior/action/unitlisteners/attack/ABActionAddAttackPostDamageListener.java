
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.attack;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener.ABAttackPostDamageListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionAddAttackPostDamageListener implements ABAction {

	private ABUnitCallback unit;
	private ABAttackPostDamageListenerCallback listener;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CUnit target = unit.callback(caster, localStore, castId);
		
		target.addPostDamageListener(listener.callback(caster, localStore, castId));
	}
}