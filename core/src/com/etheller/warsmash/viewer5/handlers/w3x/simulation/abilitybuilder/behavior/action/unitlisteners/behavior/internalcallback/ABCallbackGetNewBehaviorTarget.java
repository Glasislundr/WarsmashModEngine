package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.behavior.internalcallback;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.target.ABTargetCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.behaviors.BehaviorTargetVisitor;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.behaviors.CBehavior;

public class ABCallbackGetNewBehaviorTarget extends ABTargetCallback {

	@Override
	public AbilityTarget callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CBehavior beh = (CBehavior) localStore.get(ABLocalStoreKeys.POSTCHANGEBEHAVIOR + castId);
		AbilityTarget tar = beh.visit(BehaviorTargetVisitor.INSTANCE);

		return tar;
	}

}
