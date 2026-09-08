package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.aura;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer.ABAuraEffect;

public class ABCallbackGetStoredAuraByKey extends ABAuraCallback {

	private ABStringCallback key;
	private ABBooleanCallback instanceValue;

	@Override
	public ABAuraEffect callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		if ((this.instanceValue == null) || this.instanceValue.callback(caster, localStore, castId)) {
			return localStore.get(
					ABLocalStoreKeys.combineUserInstanceKey(this.key.callback(caster, localStore, castId), castId),
					ABAuraEffect.class);
		} else {
			return localStore.get(
					ABLocalStoreKeys.combineUserKey(this.key.callback(caster, localStore, castId), castId),
					ABAuraEffect.class);
		}
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "TODOJASS";
	}

}
