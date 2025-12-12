package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTargetVisitor;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAttackedDestructable extends ABDestructableCallback {

	@Override
	public CDestructable callback(CUnit caster, LocalDataStore localStore, final int castId) {
		AbilityTarget tar = (AbilityTarget) localStore.get(ABLocalStoreKeys.ATTACKTARGET+castId);
		return tar.visit(AbilityTargetVisitor.DESTRUCTABLE);
	}

}
