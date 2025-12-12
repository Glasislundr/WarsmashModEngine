package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTargetVisitor;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackGetAttackTargetLocation extends ABLocationCallback {

	@Override
	public AbilityPointTarget callback(CUnit caster, LocalDataStore localStore, final int castId) {
		AbilityTarget tar = (AbilityTarget) localStore.get(ABLocalStoreKeys.ATTACKTARGET+castId);
		if (tar.visit(AbilityTargetVisitor.POINT) != null) {
			return tar.visit(AbilityTargetVisitor.POINT);
		}
		return new AbilityPointTarget(tar.getX(), tar.getY());
	}

}
