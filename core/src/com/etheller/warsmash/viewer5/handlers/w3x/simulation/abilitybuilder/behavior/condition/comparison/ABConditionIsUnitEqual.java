package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.comparison;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIsUnitEqual extends ABBooleanCallback {

	private ABUnitCallback unit1;
	private ABUnitCallback unit2;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CUnit lUnit = unit1.callback(caster, localStore, castId);
		CUnit rUnit = unit2.callback(caster, localStore, castId);
		if (lUnit == null) {
			if (rUnit == null) {
				return true;
			}
			return false;
		}
		return lUnit.equals(rUnit);
	}

}
