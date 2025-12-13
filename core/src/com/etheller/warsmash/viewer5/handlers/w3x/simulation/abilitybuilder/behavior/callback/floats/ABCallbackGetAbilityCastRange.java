package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAbilityCastRange extends ABFloatCallback {

	private ABAbilityCallback ability;

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		if (ability == null) {
			AbilityBuilderAbility abil = (AbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
			return abil.getCastRange();
		} else {
			CAbility abil = ability.callback(caster, localStore, castId);
			if (abil instanceof AbilityBuilderAbility) {
				return ((AbilityBuilderAbility) abil).getCastRange();
			} else {
				return 0f;
			}
		}
	}

}
