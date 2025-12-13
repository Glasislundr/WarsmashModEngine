package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.ABDestructableCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionDoesDestructableHaveBuffMatchingCondition extends ABCondition {

	private ABDestructableCallback dest;
	private ABBooleanCallback condition;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CDestructable theDestructable = dest.callback(caster, localStore, castId);
		if (theDestructable != null) {
			for (CDestructableBuff ability : theDestructable.getBuffs()) {
				localStore.put(ABLocalStoreKeys.MATCHINGDESTBUFF, ability);
				if (condition.callback(caster, localStore, castId)) {
					localStore.remove(ABLocalStoreKeys.MATCHINGDESTBUFF);
					return true;
				}
				localStore.remove(ABLocalStoreKeys.MATCHINGDESTBUFF);
			}
		}
		return false;
	}

}
