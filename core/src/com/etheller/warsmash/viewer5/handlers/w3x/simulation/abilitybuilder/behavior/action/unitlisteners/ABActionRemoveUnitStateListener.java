
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.ABUnitStateListenerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveUnitStateListener implements ABAction {

	private ABUnitCallback unit;
	private ABUnitStateListenerCallback listener;

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnit target = unit.callback(caster, localStore, castId);

		target.removeStateListener(listener.callback(caster, localStore, castId));
	}
}