
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attackmodifier;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAttackModifier;

public class ABActionCreateAttackModifier implements ABAction {

	private ABIntegerCallback priority;
	private ABCondition preLaunchCondition;
	private List<ABAction> preLaunchModification;
	private ABCondition condition;
	private List<ABAction> modification;

	private ABBooleanCallback useCastId;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		boolean isUseCastId = true;
		if (useCastId != null) {
			isUseCastId = useCastId.callback(caster, localStore, castId);
		}
		ABAttackModifier modifier = new ABAttackModifier(localStore, castId, priority, preLaunchCondition,
				preLaunchModification, condition, modification, isUseCastId);

		localStore.put(ABLocalStoreKeys.LASTCREATEDAMod, modifier);
	}
}