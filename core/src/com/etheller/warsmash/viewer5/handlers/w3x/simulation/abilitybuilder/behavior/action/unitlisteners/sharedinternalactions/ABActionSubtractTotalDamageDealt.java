
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.sharedinternalactions;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;

/*
 * This can technically be called in any of:
 *  EvasionListener, PostDamageListener, PreDamageListener, DamageTakenListener, DamageTakenModificationListener
 *  Though note that the PostDamageListener and DamageTakenListener happen after the damage is dealt to the unit.
 *  
 *  It's really meant for PreDamageListener and DamageTakenModificationListener
 */
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