package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetBuffUniqueValueFloat extends ABFloatCallback {

	private ABBuffCallback buff;
	private ABStringCallback key;
	
	private ABBooleanCallback allowNull;

	@Override
	public Float callback(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final String keyS = key.callback(caster, localStore, castId);
		final CBuff theBuff = buff.callback(caster, localStore, castId);
		Float theVal = theBuff.getUniqueValue(keyS, Float.class);
		if (theVal != null || (allowNull != null && allowNull.callback(caster, localStore, castId))) {
			return theVal;
		}
		return 0.0f;
	}

}
