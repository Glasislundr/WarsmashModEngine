package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.GetABAbilityByRawcodeVisitor;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAbilityById extends ABAbilityCallback {

	private ABIDCallback id;
	private ABUnitCallback unit;

	@Override
	public CAbility callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CUnit theUnit = caster;
		if (this.unit != null) {
			theUnit = this.unit.callback(caster, localStore, castId);
		}
		return theUnit.getAbility(
				GetABAbilityByRawcodeVisitor.getInstance().reset(this.id.callback(caster, localStore, castId)));
	}

}
