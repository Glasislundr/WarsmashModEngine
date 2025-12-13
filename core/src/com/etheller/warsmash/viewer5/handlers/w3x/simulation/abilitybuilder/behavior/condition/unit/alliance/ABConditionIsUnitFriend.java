package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit.alliance;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.CAllianceType;

public class ABConditionIsUnitFriend extends ABCondition {

	private ABUnitCallback self;
	private ABUnitCallback unit;

	@Override
	public Boolean callback(CUnit casterUnit, ABLocalDataStore localStore, final int castId) {
		CUnit theUnit = unit.callback(casterUnit, localStore, castId);
		CUnit theCaster = casterUnit;
		if (this.self != null) {
			theCaster = this.self.callback(casterUnit, localStore, castId);
		}

		if (theUnit != null) {
			return localStore.game.getPlayer(theUnit.getPlayerIndex()).hasAlliance(theCaster.getPlayerIndex(),
					CAllianceType.SHARED_SPELLS);
		}
		return false;
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		String casterExpr;
		if (this.self == null) {
			casterExpr = jassTextGenerator.getCaster();
		} else {
			casterExpr = this.self.generateJassEquivalent(jassTextGenerator);
		}
		return "IsUnitEnemy(" + this.unit.generateJassEquivalent(jassTextGenerator) + ", GetOwningPlayer(" + casterExpr
				+ "))";
	}

}
