package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackGetAbilityArea extends ABFloatCallback {

	private ABAbilityCallback ability;
	
	@Override
	public Float callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if (ability == null) {
			ABAbilityBuilderAbility abil = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
			return abil.getArea();
		} else {
			CAbility abil = ability.callback(caster, localStore, castId);
			if (abil instanceof ABAbilityBuilderAbility) {
				return ((ABAbilityBuilderAbility)abil).getArea();
			} else {
				return 0f;
			}
		}
	}

}
