package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit.alliance;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.CAllianceType;

public class ABConditionIsUnitShareSpells extends ABBooleanCallback {

	private ABUnitCallback caster;
	private ABUnitCallback unit;

	@Override
	public Boolean callback(CUnit casterUnit, ABLocalDataStore localStore, final int castId) {
		CUnit theUnit = unit.callback(casterUnit, localStore, castId);
		CUnit theCaster = casterUnit;
		if (caster != null) {
			theCaster = caster.callback(casterUnit, localStore, castId);
		}
		
		if (theUnit != null) {
			return localStore.game.getPlayer(theUnit.getPlayerIndex()).hasAlliance(theCaster.getPlayerIndex(), CAllianceType.SHARED_SPELLS);
		}
		return false;
	}

}
