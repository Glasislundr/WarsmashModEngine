package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CAttackType;

public class ABCallbackGetAttackTypeFromString extends ABAttackTypeCallback {

	private ABStringCallback id;
	
	@Override
	public CAttackType callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return CAttackType.valueOf(id.callback(caster, localStore, castId));
	}

}
