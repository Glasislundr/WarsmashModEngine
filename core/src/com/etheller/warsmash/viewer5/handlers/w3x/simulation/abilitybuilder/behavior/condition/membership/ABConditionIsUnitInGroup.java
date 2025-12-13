package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.membership;

import java.util.Set;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitgroup.ABUnitGroupCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIsUnitInGroup extends ABBooleanCallback {

	private ABUnitGroupCallback group;
	private ABUnitCallback unit;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		Set<CUnit> groupSet = group.callback(caster, localStore, castId);
		CUnit rUnit = unit.callback(caster, localStore, castId);
		return groupSet.contains(rUnit);
	}

}
