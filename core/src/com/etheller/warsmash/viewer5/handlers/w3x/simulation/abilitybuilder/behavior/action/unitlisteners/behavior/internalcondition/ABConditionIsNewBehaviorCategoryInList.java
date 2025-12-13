package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.behavior.internalcondition;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.behaviors.CBehavior;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.behaviors.CBehaviorCategory;

public class ABConditionIsNewBehaviorCategoryInList extends ABBooleanCallback {

	private List<CBehaviorCategory> list;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, int castId) {
		CBehavior beh = (CBehavior) localStore.get(ABLocalStoreKeys.POSTCHANGEBEHAVIOR + castId);
		CBehaviorCategory cat = CBehaviorCategory.IDLE;
		if (beh != null) {
			cat = beh.getBehaviorCategory();
		}
		return list.contains(cat);
	}

}
