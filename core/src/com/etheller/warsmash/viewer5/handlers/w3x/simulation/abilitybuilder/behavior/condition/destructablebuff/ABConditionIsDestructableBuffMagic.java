package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.destructablebuff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructablebuff.ABDestructableBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsDestructableBuffMagic extends ABCondition {

	ABDestructableBuffCallback buff;
	
	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		CDestructableBuff theBuff = buff.callback(caster, localStore, castId);
		return theBuff.isMagic();
	}

}
