package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.attacksettings;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitAttackSettings;

public class ABCallbackGetCurrentAttackSettings extends ABAttackSettingsCallback {

	@Override
	public CUnitAttackSettings callback(CUnit caster, LocalDataStore localStore, final int castId) {
		System.err.println("Getting: " + localStore.get(ABLocalStoreKeys.ATTACKSETTINGS+castId));
		return (CUnitAttackSettings) localStore.get(ABLocalStoreKeys.ATTACKSETTINGS+castId);
	}

}
