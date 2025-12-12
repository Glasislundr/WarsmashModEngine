
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalActions;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

public class ABActionPreDamageListenerLockDamageModifications implements ABAction {

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CDamageCalculation damage = ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId));
		damage.lock();
	}
}