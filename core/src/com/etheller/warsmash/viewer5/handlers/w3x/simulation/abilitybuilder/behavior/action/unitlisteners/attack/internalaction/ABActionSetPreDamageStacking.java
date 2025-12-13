
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.attack.internalaction;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

public class ABActionSetPreDamageStacking implements ABAction {

	private ABBooleanCallback allowStacking;
	private ABBooleanCallback allowSamePriorityStacking;

	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		CDamageCalculation damage = ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId));

		if (allowStacking != null && !allowStacking.callback(caster, localStore, castId)) {
			damage.preventAllOtherModifications();
		}
		if (allowSamePriorityStacking != null
				&& !allowSamePriorityStacking.callback(caster, localStore, castId)) {
			damage.preventOtherModificationsWithSamePriority();
		}
	}
}