package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.item;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item.ABItemCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionItemIsCharged extends ABCondition {

	private ABItemCallback item;
	
	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		if (item == null) {
			AbilityBuilderAbility ability = (AbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);

			return ability.getItem().getItemType().getNumberOfCharges() > 0;
		} else {
			return item.callback(caster, localStore, castId).getItemType().getNumberOfCharges() > 0;
		}
	}

}
