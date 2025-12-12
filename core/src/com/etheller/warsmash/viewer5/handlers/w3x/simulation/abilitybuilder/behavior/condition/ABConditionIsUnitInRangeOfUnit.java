package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsUnitInRangeOfUnit extends ABCondition {

	private ABUnitCallback caster;
	private ABUnitCallback target;
	private ABFloatCallback range;

	@Override
	public Boolean callback(CUnit casterUnit, LocalDataStore localStore, final int castId) {
		return caster.callback(casterUnit, localStore, castId).canReach(
				target.callback(casterUnit, localStore, castId),
				range.callback(casterUnit, localStore, castId));
	}

}
