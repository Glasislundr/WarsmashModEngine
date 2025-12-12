package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition;

import java.util.EnumSet;
import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderActiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.ABDestructableCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.CAbilityTypeAbilityBuilderLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CTargetType;

public class ABConditionIsDestructableValidTarget extends ABCondition {

	private ABUnitCallback caster;
	private ABDestructableCallback target;

	@SuppressWarnings("unchecked")
	@Override
	public Boolean callback(CUnit casterUnit, LocalDataStore localStore, final int castId) {
		CUnit theCaster = casterUnit;

		EnumSet<CTargetType> targetsAllowed = null;
		AbilityBuilderAbility ability = (AbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		if (ability != null && ability instanceof AbilityBuilderActiveAbility) {
			targetsAllowed = ((AbilityBuilderActiveAbility)ability).getTargetsAllowed();
		} else {
			List<CAbilityTypeAbilityBuilderLevelData> levelData = (List<CAbilityTypeAbilityBuilderLevelData>) localStore
					.get(ABLocalStoreKeys.LEVELDATA);
			targetsAllowed = levelData.get(((int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL))-1)
					.getTargetsAllowed();
		}
		
		if (targetsAllowed.isEmpty()) {
			return true;
		}
		if (caster != null) {
			theCaster = caster.callback(casterUnit, localStore, castId);
		}

		return target.callback(casterUnit, localStore, castId).canBeTargetedBy(localStore.game, theCaster,
				targetsAllowed);
	}

}
