package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.membership;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIsUnitInRangeOfUnit extends ABCondition {

	private ABUnitCallback caster;
	private ABUnitCallback target;
	private ABFloatCallback range;

	@Override
	public Boolean callback(CUnit casterUnit, ABLocalDataStore localStore, final int castId) {
		return caster.callback(casterUnit, localStore, castId).canReach(
				target.callback(casterUnit, localStore, castId),
				range.callback(casterUnit, localStore, castId));
	}

}
