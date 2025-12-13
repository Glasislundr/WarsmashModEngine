
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attackmodifier.internal;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitPriorityLoopData;

public class ABActionAttackModifierPreventOtherModifications implements ABAction {

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		CUnitPriorityLoopData loop = (CUnitPriorityLoopData) localStore.get(ABLocalStoreKeys.ATTACKMODLOOP + castId);
		if (loop != null)
			loop.preventAllOtherModifications();
	}
}