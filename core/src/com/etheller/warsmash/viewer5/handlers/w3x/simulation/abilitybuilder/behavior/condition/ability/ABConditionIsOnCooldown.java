package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ability;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIsOnCooldown extends ABBooleanCallback {

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		ABAbilityBuilderAbility ability = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);

		return ability.getCooldownRemainingTicks(localStore.game, caster) > 0;
	}

}
