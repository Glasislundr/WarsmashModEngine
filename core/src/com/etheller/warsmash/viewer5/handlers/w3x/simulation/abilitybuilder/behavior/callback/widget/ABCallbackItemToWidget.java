package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item.ABItemCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackItemToWidget extends ABWidgetCallback {

	private ABItemCallback item;
	
	@Override
	public CWidget callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return item.callback(caster, localStore, castId);
	}

}
