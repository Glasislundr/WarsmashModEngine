package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.orderid;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.orders.OrderIdUtils;

public class ABCallbackIdString extends ABOrderIdCallback {
	
	private ABStringCallback idString;
	
	@Override
	public Integer callback(CUnit caster, LocalDataStore localStore, final int castId) {
		return OrderIdUtils.getOrderId(idString.callback(caster, localStore, castId));
	}

}
