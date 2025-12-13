package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.ABDestructableCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionKillDestructable implements ABAction {

	private ABDestructableCallback dest;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		dest.callback(caster, localStore, castId).setLife(localStore.game, 0);
	}

}
