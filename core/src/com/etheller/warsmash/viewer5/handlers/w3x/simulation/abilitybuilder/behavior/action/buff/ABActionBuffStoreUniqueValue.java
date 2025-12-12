package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionBuffStoreUniqueValue implements ABAction {

	private ABBuffCallback buff;
	private ABStringCallback key;
	private ABCallback valueToStore;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CBuff theAbility = buff.callback(caster, localStore, castId);
		theAbility.addUniqueValue(valueToStore.callback(caster, localStore, castId), key.callback(caster, localStore, castId));
	}

}
