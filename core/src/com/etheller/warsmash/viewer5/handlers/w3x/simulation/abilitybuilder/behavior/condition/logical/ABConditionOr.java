package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.logical;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionOr extends ABCondition {

	private List<ABCondition> conditions;

	@Override
	public Boolean callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		boolean result = false;
		if (conditions != null) {
			for (ABCondition cond : conditions) {
				if (!result) {
					result = result || cond.callback(game, caster, localStore, castId);
				}
			}
		}
		return result;
	}

}
