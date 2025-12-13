package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit.state;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.CUnitTypeJass;

public class ABConditionIsUnitPolymorphed extends ABCondition {

	private ABUnitCallback unit;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CUnit theUnit = caster;
		if (unit != null) {
			theUnit = unit.callback(caster, localStore, castId);
		}
		if (theUnit != null) {
			return theUnit.isUnitType(CUnitTypeJass.POLYMORPHED);
		}
		return false;
	}

}
