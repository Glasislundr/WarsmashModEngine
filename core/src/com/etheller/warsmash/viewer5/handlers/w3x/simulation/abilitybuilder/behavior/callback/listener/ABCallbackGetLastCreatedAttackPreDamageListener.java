package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listener;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAttackPreDamageListener;

public class ABCallbackGetLastCreatedAttackPreDamageListener extends ABAttackPreDamageListenerCallback {

	@Override
	public ABAttackPreDamageListener callback(CUnit caster, ABLocalDataStore localStore,
			final int castId) {
		return (ABAttackPreDamageListener) localStore.get(ABLocalStoreKeys.LASTCREATEDAPrDL);
	}

}
