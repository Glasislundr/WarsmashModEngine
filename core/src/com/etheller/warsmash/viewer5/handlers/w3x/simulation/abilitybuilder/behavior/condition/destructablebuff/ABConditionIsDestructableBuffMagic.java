package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.destructablebuff;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructablebuff.ABDestructableBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABConditionIsDestructableBuffMagic extends ABBooleanCallback {

	ABDestructableBuffCallback buff;
	
	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CDestructableBuff theBuff = buff.callback(caster, localStore, castId);
		return theBuff.isMagic();
	}

}
