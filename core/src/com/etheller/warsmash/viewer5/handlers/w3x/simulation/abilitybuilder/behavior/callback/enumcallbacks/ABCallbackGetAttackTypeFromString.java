package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CAttackType;

public class ABCallbackGetAttackTypeFromString extends ABAttackTypeCallback {

	private ABStringCallback id;
	
	@Override
	public CAttackType callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return CAttackType.valueOf(id.callback(caster, localStore, castId));
	}

}
