package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CWeaponType;

public class ABCallbackRawWeaponType extends ABWeaponTypeCallback {

	private CWeaponType value;

	@Override
	public CWeaponType callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return value;
	}

}
