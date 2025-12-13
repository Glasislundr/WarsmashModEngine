package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ability;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderActiveFlexTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIsFlexAbilityPointTarget extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		ABAbilityBuilderActiveFlexTarget ability = (ABAbilityBuilderActiveFlexTarget) localStore.get(ABLocalStoreKeys.ISFLEXABILITY);

		return ability.isPointTarget();
	}

}
