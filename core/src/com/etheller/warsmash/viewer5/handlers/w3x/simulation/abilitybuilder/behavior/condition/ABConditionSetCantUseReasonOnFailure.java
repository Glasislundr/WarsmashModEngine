package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.CommandStringErrorKeysEnum;

public class ABConditionSetCantUseReasonOnFailure extends ABCondition {

	private ABCondition condition;
	private CommandStringErrorKeysEnum reason;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		boolean result = condition.callback(caster, localStore, castId);
		if (!result) {
			localStore.put(ABLocalStoreKeys.CANTUSEREASON, reason.getKey());
		}
		return result;
	}

}
