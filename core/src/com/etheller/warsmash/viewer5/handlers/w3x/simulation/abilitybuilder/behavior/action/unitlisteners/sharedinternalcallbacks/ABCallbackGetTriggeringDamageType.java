package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.sharedinternalcallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums.ABDamageTypeCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CDamageType;

/*
 * This can technically be called in any of:
 *  EvasionListener, PostDamageListener, PreDamageListener, DamageTakenListener, DamageTakenModificationListener
 *  
 */
public class ABCallbackGetTriggeringDamageType extends ABDamageTypeCallback {

	@Override
	public CDamageType callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		return ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId)).getPrimaryDamageType();
	}

}
