package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.abilitydata;

import java.util.EnumSet;
import java.util.List;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderActiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CTargetType;

public class ABActionRemoveTargetAllowed implements ABSingleAction {

	private CTargetType targetType;

	@Override
	@SuppressWarnings("unchecked")
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		ABAbilityBuilderAbility ability = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		if (ability != null && ability instanceof ABAbilityBuilderActiveAbility) {
			((ABAbilityBuilderActiveAbility)ability).getTargetsAllowed().remove(this.targetType);
		} else {
			final List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
					.get(ABLocalStoreKeys.LEVELDATA);
			final EnumSet<CTargetType> targetsAllowed = levelData
					.get(((int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL)) - 1).getTargetsAllowed();
			targetsAllowed.remove(this.targetType);
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "AbilityTypeLevelDataRemoveTargetAllowed("
				+ jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_LEVELDATA",
						JassTextGeneratorType.AbilityTypeLevelDataHandle)
				+ ", "
				+ jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_CURRENTLEVEL", JassTextGeneratorType.Integer)
				+ " - 1, TARGET_TYPE_" + this.targetType.name() + ")";
	}
}
