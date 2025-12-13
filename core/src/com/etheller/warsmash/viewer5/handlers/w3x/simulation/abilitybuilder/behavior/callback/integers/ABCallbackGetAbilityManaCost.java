package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderActiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetAbilityManaCost extends ABIntegerCallback {

	private ABAbilityCallback ability;

	@Override
	public Integer callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if (ability == null) {
			ABAbilityBuilderActiveAbility abil = (ABAbilityBuilderActiveAbility) localStore.get(ABLocalStoreKeys.ABILITY);
			return abil.getChargedManaCost();
		} else {
			CAbility abil = ability.callback(caster, localStore, castId);
			if (abil instanceof ABAbilityBuilderActiveAbility) {
				return ((ABAbilityBuilderActiveAbility) abil).getChargedManaCost();
			} else {
				return 0;
			}
		}
	}

}
