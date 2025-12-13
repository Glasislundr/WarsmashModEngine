package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.item;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item.ABItemCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;

public class ABConditionItemIsCharged extends ABBooleanCallback {

	private ABItemCallback item;
	
	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if (item == null) {
			ABAbilityBuilderAbility ability = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);

			return ability.getItem().getItemType().getNumberOfCharges() > 0;
		} else {
			return item.callback(caster, localStore, castId).getItemType().getNumberOfCharges() > 0;
		}
	}

}
