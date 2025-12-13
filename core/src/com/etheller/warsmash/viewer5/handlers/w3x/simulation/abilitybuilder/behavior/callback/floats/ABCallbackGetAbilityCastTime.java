package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import java.util.List;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetAbilityCastTime extends ABFloatCallback {

	@SuppressWarnings("unchecked")
	@Override
	public Float callback(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		ABAbilityBuilderAbility ability = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		if (ability != null) {
			return ability.getCastTime();
		} else {
			final List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
					.get(ABLocalStoreKeys.LEVELDATA);
			return levelData.get(((int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL)) - 1).getCastTime();
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "GetAbilityCastTimeAU(" + jassTextGenerator.getTriggerLocalStore() + ")";
	}

}
