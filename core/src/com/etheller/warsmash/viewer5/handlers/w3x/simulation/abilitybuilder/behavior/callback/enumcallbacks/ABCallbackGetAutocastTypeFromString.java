package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.autocast.AutocastType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAutocastTypeFromString extends ABAutocastTypeCallback {

	private ABStringCallback id;
	
	@Override
	public AutocastType callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return AutocastType.valueOf(id.callback(caster, localStore, castId));
	}

}
