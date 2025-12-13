package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetAbilityCastTimeAsInteger extends ABIntegerCallback {

	@SuppressWarnings("unchecked")
	@Override
	public Integer callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		ABAbilityBuilderAbility ability = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		if (ability != null) {
			return (int) ability.getCastTime();
		} else {
			List<ABAbilityBuilderAbilityTypeLevelData>  levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore.get(ABLocalStoreKeys.LEVELDATA);
			return (int) levelData.get(((int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL))-1).getCastTime();
		}
	}

}
