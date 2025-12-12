
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attack.internal;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitAttackSettings;

public class ABActionAttackModifierSetAttackDeathTime implements ABAction {

	private ABFloatCallback deathTime;

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnitAttackSettings settings = (CUnitAttackSettings) localStore.get(ABLocalStoreKeys.ATTACKSETTINGS + castId);
		if (deathTime != null) {
			settings.setArtDeathTime(deathTime.callback(caster, localStore, castId));
		}
	}
}