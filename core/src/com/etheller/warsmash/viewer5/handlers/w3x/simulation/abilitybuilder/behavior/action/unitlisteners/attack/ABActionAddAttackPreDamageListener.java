
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.attack;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums.ABAttackPreDamageListenerPriorityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener.ABAttackPreDamageListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionAddAttackPreDamageListener implements ABAction {

	private ABUnitCallback targetUnit;
	private ABAttackPreDamageListenerPriorityCallback priority;
	private ABAttackPreDamageListenerCallback listener;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		CUnit target = targetUnit.callback(caster, localStore, castId);

		target.addPreDamageListener(priority.callback(caster, localStore, castId),
				listener.callback(caster, localStore, castId));
	}
}