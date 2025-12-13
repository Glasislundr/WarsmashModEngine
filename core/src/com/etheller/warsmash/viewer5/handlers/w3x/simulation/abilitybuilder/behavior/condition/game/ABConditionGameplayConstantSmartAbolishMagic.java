package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.game;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionGameplayConstantSmartAbolishMagic extends ABCondition {

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return localStore.game.getGameplayConstants().isAbolishMagicSmartDispel();
	}

}
