package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.ABDestructableCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveDestructable implements ABAction {

	private ABDestructableCallback dest;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		localStore.game.removeDestructable(dest.callback(caster, localStore, castId));
	}

}
