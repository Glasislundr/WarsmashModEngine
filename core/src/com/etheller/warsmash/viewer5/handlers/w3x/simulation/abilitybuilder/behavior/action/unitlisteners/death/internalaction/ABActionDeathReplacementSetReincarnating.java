
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.death.internalaction;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitDeathReplacementResult;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitDeathReplacementStacking;

public class ABActionDeathReplacementSetReincarnating implements ABAction {

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnitDeathReplacementResult result = (CUnitDeathReplacementResult)localStore.get(ABLocalStoreKeys.DEATHRESULT+castId);
		CUnitDeathReplacementStacking stacking = (CUnitDeathReplacementStacking)localStore.get(ABLocalStoreKeys.DEATHSTACKING+castId);
		
		stacking.setAllowStacking(false);
		stacking.setAllowSamePriorityStacking(false);
		result.setReincarnating(true);
		caster.setFalseDeath(true);
		localStore.game.getWorldCollision().removeUnit(caster);
	}
}