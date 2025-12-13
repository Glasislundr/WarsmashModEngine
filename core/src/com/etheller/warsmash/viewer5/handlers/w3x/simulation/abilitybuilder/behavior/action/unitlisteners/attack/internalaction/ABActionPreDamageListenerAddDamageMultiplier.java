
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.attack.internalaction;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

public class ABActionPreDamageListenerAddDamageMultiplier implements ABAction {

	private ABFloatCallback value;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CDamageCalculation damage = ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId));
		damage.addDamageMultiplier(value.callback(caster, localStore, castId));
	}
}