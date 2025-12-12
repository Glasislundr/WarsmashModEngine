package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetUnitType extends ABIDCallback {

	private ABUnitCallback unit;

	@Override
	public War3ID callback(CUnit caster, LocalDataStore localStore, final int castId) {
		if (unit == null) {
			return caster.getTypeId();
		}
		return unit.callback(caster, localStore, castId).getTypeId();
	}

}
