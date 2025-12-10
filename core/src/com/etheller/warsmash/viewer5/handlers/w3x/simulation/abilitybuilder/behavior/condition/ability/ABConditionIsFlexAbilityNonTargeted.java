package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ability;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.CAbilityAbilityBuilderActiveFlexTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsFlexAbilityNonTargeted extends ABCondition {

	@Override
	public Boolean callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		CAbilityAbilityBuilderActiveFlexTarget ability = (CAbilityAbilityBuilderActiveFlexTarget) localStore.get(ABLocalStoreKeys.ISFLEXABILITY);

		return !ability.isTargetedSpell();
	}

}
