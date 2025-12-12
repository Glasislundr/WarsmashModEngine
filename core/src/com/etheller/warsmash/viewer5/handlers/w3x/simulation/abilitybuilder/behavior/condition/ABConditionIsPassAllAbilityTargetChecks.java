package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderActiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget.ABWidgetCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.BooleanAbilityTargetCheckReceiver;

public class ABConditionIsPassAllAbilityTargetChecks extends ABCondition {

	private ABUnitCallback caster;
	private ABWidgetCallback target;

	@Override
	public Boolean callback(CUnit casterUnit, LocalDataStore localStore, final int castId) {
		CUnit theCaster = casterUnit;

		if (caster != null) {
			theCaster = caster.callback(casterUnit, localStore, castId);
		}

		AbilityBuilderActiveAbility abil = (AbilityBuilderActiveAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		final BooleanAbilityTargetCheckReceiver<CWidget> booleanTargetReceiver = BooleanAbilityTargetCheckReceiver
				.<CWidget>getInstance().reset();

		abil.checkCanTarget(localStore.game, theCaster, abil.getBaseOrderId(),
				((Boolean) localStore.get(ABLocalStoreKeys.combineKey(ABLocalStoreKeys.ISAUTOCAST, castId))),
				target.callback(casterUnit, localStore, castId), booleanTargetReceiver);

		if (booleanTargetReceiver.isTargetable()) {
			return true;
		}
		return false;
	}

}
