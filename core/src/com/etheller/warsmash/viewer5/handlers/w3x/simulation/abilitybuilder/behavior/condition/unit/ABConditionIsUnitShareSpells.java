package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.CAllianceType;

public class ABConditionIsUnitShareSpells extends ABCondition {

	private ABUnitCallback caster;
	private ABUnitCallback unit;

	@Override
	public Boolean callback(CSimulation game, CUnit casterUnit, LocalDataStore localStore, final int castId) {
		CUnit theUnit = unit.callback(game, casterUnit, localStore, castId);
		CUnit theCaster = casterUnit;
		if (caster != null) {
			theCaster = caster.callback(game, casterUnit, localStore, castId);
		}
		
		if (theUnit != null) {
			return game.getPlayer(theUnit.getPlayerIndex()).hasAlliance(theCaster.getPlayerIndex(), CAllianceType.SHARED_SPELLS);
		}
		return false;
	}

}
