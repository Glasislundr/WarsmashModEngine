package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.condition;

import java.util.EnumSet;
import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CTargetType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.BooleanAbilityTargetCheckReceiver;

public class ABTemplateAuraTargeting extends ABBooleanCallback {

	private ABBooleanCallback condition;

	public ABTemplateAuraTargeting(ABBooleanCallback condition) {
		this.condition = condition;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, int castId) {
		boolean valid = true;
		
		if (this.condition != null) {
			valid &= condition.callback(caster, localStore, castId);
		} else {
			List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
					.get(ABLocalStoreKeys.LEVELDATA);
			EnumSet<CTargetType> targetsAllowed = levelData.get(localStore.getLevelDataInstanceLevel(castId)).getTargetsAllowed();
			valid &= caster.canBeTargetedBy(localStore.game, localStore.originUnit, false, targetsAllowed,
					BooleanAbilityTargetCheckReceiver.<CWidget>getInstance().reset());
		}
		
		return valid;
	}

}
