
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.damagetaken;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABDamageTakenModificationListener;

public class ABActionCreateDamageTakenModificationListener implements ABAction {

	private ABIntegerCallback priority;
	private List<ABAction> actions;
	private ABBooleanCallback useCastId;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		boolean ucid = true;
		if (useCastId != null) {
			ucid = useCastId.callback(caster, localStore, castId);
		}
		ABDamageTakenModificationListener listener = new ABDamageTakenModificationListener(localStore, priority,
				actions, castId, ucid);

		localStore.put(ABLocalStoreKeys.LASTCREATEDDTML, listener);
	}
}