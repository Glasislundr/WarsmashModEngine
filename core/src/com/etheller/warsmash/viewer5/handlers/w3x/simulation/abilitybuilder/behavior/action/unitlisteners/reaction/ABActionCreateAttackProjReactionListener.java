
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.reaction;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener.ABAttackProjReactionListener;

public class ABActionCreateAttackProjReactionListener implements ABAction {

	private List<ABAction> actions;
	private ABBooleanCallback useCastId;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		boolean ucid = true;
		if (useCastId != null) {
			ucid = useCastId.callback(caster, localStore, castId);
		}
		ABAttackProjReactionListener listener = new ABAttackProjReactionListener(localStore, actions, castId, ucid);

		localStore.put(ABLocalStoreKeys.LASTCREATEDAtkPRL, listener);
	}
}