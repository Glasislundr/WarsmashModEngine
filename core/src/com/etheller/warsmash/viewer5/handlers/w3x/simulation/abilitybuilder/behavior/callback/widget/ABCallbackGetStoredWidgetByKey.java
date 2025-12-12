package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetStoredWidgetByKey extends ABWidgetCallback {

	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public CWidget callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		if ((this.instanceValue == null) || this.instanceValue.callback(caster, localStore, castId)) {
			return (CWidget) localStore.get(ABLocalStoreKeys
					.combineUserInstanceKey(this.key.callback(caster, localStore, castId), castId));
		} else {
			return (CWidget) localStore
					.get(ABLocalStoreKeys.combineUserKey(this.key.callback(caster, localStore, castId), castId));
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
