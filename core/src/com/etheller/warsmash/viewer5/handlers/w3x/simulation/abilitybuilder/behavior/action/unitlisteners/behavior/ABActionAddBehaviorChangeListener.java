
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.behavior;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener.ABBehaviorChangeListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionAddBehaviorChangeListener implements ABAction {

	private ABUnitCallback unit;
	private ABBehaviorChangeListenerCallback listener;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CUnit target = unit.callback(caster, localStore, castId);
		
		target.addBehaviorChangeListener(listener.callback(caster, localStore, castId));
	}
}