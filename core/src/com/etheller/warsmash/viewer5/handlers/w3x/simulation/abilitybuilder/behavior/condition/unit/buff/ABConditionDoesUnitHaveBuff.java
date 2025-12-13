package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit.buff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionDoesUnitHaveBuff extends ABCondition {

	private ABUnitCallback unit;
	private ABIDCallback id;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CUnit theUnit = caster;
		if (unit != null) {
			theUnit = unit.callback(caster, localStore, castId);
		}
		if (theUnit != null) {
			for (CAbility ability : theUnit.getAbilities()) {
				if (ability instanceof CBuff) {
					if (((CBuff) ability).getAlias() == id.callback(caster, localStore, castId)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
