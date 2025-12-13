package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.behavior;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionAttemptToResumePreviousBehavior implements ABAction {

	private ABBooleanCallback checkForOrders;
	
	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, int castId) {
		if (checkForOrders == null || checkForOrders.callback(caster, localStore, castId)) {
			if (caster.getOrderQueue().isEmpty()) {
				localStore.put(ABLocalStoreKeys.NEWBEHAVIOR, localStore.get(ABLocalStoreKeys.PREVIOUSBEHAVIOR));
			}
		} else {
			localStore.put(ABLocalStoreKeys.NEWBEHAVIOR, localStore.get(ABLocalStoreKeys.PREVIOUSBEHAVIOR));
		}
	}

}
