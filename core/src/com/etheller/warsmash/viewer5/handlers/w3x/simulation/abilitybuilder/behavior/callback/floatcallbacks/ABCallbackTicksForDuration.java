package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.util.WarsmashConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackTicksForDuration extends ABFloatCallback {

	private ABFloatCallback duration;

	@Override
	public Float callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return duration.callback(caster, localStore, castId) / WarsmashConstants.SIMULATION_STEP_TIME;
	}

}
