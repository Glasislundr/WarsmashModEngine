
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks.ABAttackPreDamageListenerPriorityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.ABAttackPreDamageListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveAttackPreDamageListener implements ABAction {

	private ABUnitCallback targetUnit;
	private ABAttackPreDamageListenerPriorityCallback priority;
	private ABAttackPreDamageListenerCallback listener;

	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		CUnit target = targetUnit.callback(caster, localStore, castId);

		target.removePreDamageListener(priority.callback(caster, localStore, castId),
				listener.callback(caster, localStore, castId));
	}
}