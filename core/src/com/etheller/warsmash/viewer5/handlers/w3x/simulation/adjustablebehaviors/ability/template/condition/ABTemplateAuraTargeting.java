package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.condition;

import java.util.EnumSet;
import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABAttackRangeTargetExclusion;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CTargetType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.CUnitTypeJass;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.BooleanAbilityTargetCheckReceiver;

public class ABTemplateAuraTargeting extends ABBooleanCallback {

	private ABBooleanCallback condition;
	private boolean excludeMelee = false;
	private boolean excludeRange = false;
	private boolean excludeNoAttacks = false;

	public ABTemplateAuraTargeting(ABBooleanCallback condition,
			ABAttackRangeTargetExclusion attackRangeTargetExcludes) {
		this.condition = condition;
		if (attackRangeTargetExcludes != null) {
			this.excludeMelee = attackRangeTargetExcludes.isExcludeMelee();
			this.excludeRange = attackRangeTargetExcludes.isExcludeRange();
			this.excludeNoAttacks = attackRangeTargetExcludes.isExcludeNoAttack();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean callback(CUnit auraUnit, ABLocalDataStore localStore, int castId) {
		if ((this.excludeMelee && auraUnit.isUnitType(CUnitTypeJass.MELEE_ATTACKER))
				|| (this.excludeRange && auraUnit.isUnitType(CUnitTypeJass.RANGED_ATTACKER))
				|| (this.excludeNoAttacks && !auraUnit.isUnitType(CUnitTypeJass.MELEE_ATTACKER)
						&& !auraUnit.isUnitType(CUnitTypeJass.RANGED_ATTACKER))) {
			return false;
		}

		if (this.condition != null) {
			return condition.callback(auraUnit, localStore, castId);
		} else {
			List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
					.get(ABLocalStoreKeys.LEVELDATA);
			EnumSet<CTargetType> targetsAllowed = levelData.get(localStore.getLevelDataInstanceLevel(castId))
					.getTargetsAllowed();
			return auraUnit.canBeTargetedBy(localStore.game, localStore.originUnit, false, targetsAllowed,
					BooleanAbilityTargetCheckReceiver.<CWidget>getInstance().reset());
		}
	}

}
