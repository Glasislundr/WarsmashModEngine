package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.uniquevalue;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buff.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionBuffRemoveUniqueValue implements ABAction {

	private ABBuffCallback buff;
	private ABStringCallback key;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CBuff theAbility = buff.callback(caster, localStore, castId);
		theAbility.removeUniqueValue(key.callback(caster, localStore, castId));
	}

}
