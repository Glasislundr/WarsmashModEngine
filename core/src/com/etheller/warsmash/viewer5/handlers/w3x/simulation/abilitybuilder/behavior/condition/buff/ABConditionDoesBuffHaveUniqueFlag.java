package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.buff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionDoesBuffHaveUniqueFlag extends ABCondition {

	ABBuffCallback buff;
	ABStringCallback flag;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CBuff theBuff = buff.callback(caster, localStore, castId);
		return theBuff.hasUniqueFlag(flag.callback(caster, localStore, castId));
	}

}
