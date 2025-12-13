package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.datastore;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionDeleteStoredKey implements ABAction {

	private ABStringCallback key;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		localStore.remove(key.callback(caster, localStore, castId));
	}
}
