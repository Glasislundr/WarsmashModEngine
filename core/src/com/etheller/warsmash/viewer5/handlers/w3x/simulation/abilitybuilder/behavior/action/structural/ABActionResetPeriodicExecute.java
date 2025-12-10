package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.structural;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionResetPeriodicExecute implements ABAction {

	private ABCallback unique;

	@Override
	public void runAction(CSimulation game, CUnit caster, LocalDataStore localStore, int castId) {
		if (this.unique != null) {
			localStore.remove(ABLocalStoreKeys.PERIODICNEXTTICK + castId + "$"
					+ this.unique.callback(game, caster, localStore, castId));
		} else {
			localStore.remove(ABLocalStoreKeys.PERIODICNEXTTICK + castId);
		}
	}

}
