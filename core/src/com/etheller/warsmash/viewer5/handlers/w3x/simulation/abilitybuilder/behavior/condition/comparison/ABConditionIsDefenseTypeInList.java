package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.comparison;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums.ABDefenseTypeCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDefenseType;

public class ABConditionIsDefenseTypeInList extends ABCondition {

	private ABDefenseTypeCallback defenseType;
	private List<ABDefenseTypeCallback> list;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, int castId) {
		CDefenseType theType = defenseType.callback(caster, localStore, castId);
		for (ABDefenseTypeCallback lType : list) {
			if (theType == lType.callback(caster, localStore, castId)) {
				return true;
			}
		}
		return false;
	}

}
