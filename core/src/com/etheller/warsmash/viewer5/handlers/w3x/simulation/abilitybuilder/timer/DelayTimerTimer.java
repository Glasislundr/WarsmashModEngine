package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.timer;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.timers.CTimer;

public class DelayTimerTimer extends CTimer {

	private CTimer timer;
	LocalDataStore localStore;

	public DelayTimerTimer(CTimer timer, LocalDataStore localStore, float delay) {
		super();
		this.timer = timer;
		this.localStore = localStore;
		this.setRepeats(false);
		this.setTimeoutTime(delay);
	}

	public void onFire(CSimulation game) {
		localStore.put(ABLocalStoreKeys.ACTIVE_ALTITUDE_ADJUSTMENT, timer);
		timer.start(game);
	}

}
