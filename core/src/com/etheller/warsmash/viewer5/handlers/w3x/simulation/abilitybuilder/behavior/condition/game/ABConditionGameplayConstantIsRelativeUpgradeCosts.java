package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.game;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionGameplayConstantIsRelativeUpgradeCosts extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return localStore.game.getGameplayConstants().isRelativeUpgradeCosts();
	}

}
