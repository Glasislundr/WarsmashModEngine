package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.attack.internalcallback;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitAttackSettings;

public class ABCallbackGetAttackMaximumSplashRadius extends ABIntegerCallback {
	
	@Override
	public Integer callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CUnitAttackSettings settings = (CUnitAttackSettings) localStore.get(ABLocalStoreKeys.ATTACKSETTINGS+castId);
		return Math.max(settings.getAreaOfEffectFullDamage(), Math.max(settings.getAreaOfEffectMediumDamage(), settings.getAreaOfEffectSmallDamage()));
	}

}
