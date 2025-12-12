package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.item;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsItemAbility extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		AbilityBuilderAbility ability = (AbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);

		return ability.getItem() != null;
	}

}
