
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.state;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener.ABUnitStateListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionRemoveUnitStateListener implements ABAction {

	private ABUnitCallback unit;
	private ABUnitStateListenerCallback listener;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CUnit target = unit.callback(caster, localStore, castId);

		target.removeStateListener(listener.callback(caster, localStore, castId));
	}
}