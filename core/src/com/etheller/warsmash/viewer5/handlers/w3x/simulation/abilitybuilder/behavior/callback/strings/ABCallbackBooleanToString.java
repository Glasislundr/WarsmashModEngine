package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackBooleanToString extends ABStringCallback {

	private ABBooleanCallback value;

	@Override
	public String callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return "" + value.callback(caster, localStore, castId);
	}

}
