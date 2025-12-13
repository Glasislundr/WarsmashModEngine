package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetAbilityHeroDuration extends ABFloatCallback {

	@SuppressWarnings("unchecked")
	@Override
	public Float callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
				.get(ABLocalStoreKeys.LEVELDATA);
		return levelData.get(((int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL)) - 1).getDurationHero();
	}

}
