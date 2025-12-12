package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.comparison;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsIdEqual extends ABCondition {

	private ABIDCallback id1;
	private ABIDCallback id2;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		War3ID lA = id1.callback(caster, localStore, castId);
		War3ID rA = id2.callback(caster, localStore, castId);
		if (lA == null) {
			if (rA == null) {
				return true;
			}
			return false;
		}
		return lA.equals(rA);
	}

}
