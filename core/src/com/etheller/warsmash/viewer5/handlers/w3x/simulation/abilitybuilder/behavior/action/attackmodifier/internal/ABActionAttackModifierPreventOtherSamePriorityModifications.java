
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attackmodifier.internal;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitPriorityLoopData;

public class ABActionAttackModifierPreventOtherSamePriorityModifications implements ABAction {

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnitPriorityLoopData loop = (CUnitPriorityLoopData) localStore.get(ABLocalStoreKeys.ATTACKMODLOOP + castId);
		if (loop != null)
			loop.preventOtherModificationsWithSamePriority();
	}
}