package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitstate;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.timercallbacks.ABTimerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.timers.CTimer;

public class ABActionSetUnitFadeTimer implements ABAction {

	private ABUnitCallback targetUnit;
	private ABTimerCallback timer;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final CUnit target = this.targetUnit.callback(caster, localStore, castId);
		final CTimer theTimer = this.timer.callback(caster, localStore, castId);

		target.setFadeTimer(theTimer);
	}
}