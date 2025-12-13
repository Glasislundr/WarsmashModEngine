
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attackmodifier.internal;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitAttackSettings;

public class ABActionAttackModifierSetAttackImpactZ implements ABAction {

	private ABFloatCallback impactZ;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		CUnitAttackSettings settings = (CUnitAttackSettings) localStore.get(ABLocalStoreKeys.ATTACKSETTINGS + castId);
		if (impactZ != null) {
			settings.setImpactZ(impactZ.callback(caster, localStore, castId));
		}
	}
}