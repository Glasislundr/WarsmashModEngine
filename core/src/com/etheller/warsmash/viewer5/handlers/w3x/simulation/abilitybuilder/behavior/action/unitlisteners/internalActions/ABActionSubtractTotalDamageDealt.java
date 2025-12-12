
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalActions;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

public class ABActionSubtractTotalDamageDealt implements ABAction {

	private ABFloatCallback amount;
	private ABFloatCallback minimum;

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		float theMin = 0;
		if (minimum != null) {
			theMin = minimum.callback(caster, localStore, castId);
		}
		CDamageCalculation damage = ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId));
		damage.subtractTotalDamageDealt(amount.callback(caster, localStore, castId), theMin);
	}
}