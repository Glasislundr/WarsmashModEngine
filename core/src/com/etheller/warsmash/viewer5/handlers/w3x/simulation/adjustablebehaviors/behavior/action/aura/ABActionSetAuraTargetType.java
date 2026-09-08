
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.action.aura;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.aura.ABAuraCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer.ABAuraEffect;

public class ABActionSetAuraTargetType implements ABAction {

	private ABAuraCallback aura;
	
	private ABBooleanCallback affectsUnits;
	private ABBooleanCallback affectsCorpses;
	private ABBooleanCallback affectsDestructables;
	private ABBooleanCallback affectsItems;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		ABAuraEffect theAura;
		if (aura == null) {
			theAura = localStore.get(ABLocalStoreKeys.AURAEFFECT, ABAuraEffect.class);
		} else {
			theAura = aura.callback(caster, localStore, castId);
		}
		
		if (affectsUnits != null) {
			theAura.setAffectsUnits(affectsUnits.callback(caster, localStore, castId));
		} else {
			theAura.setAffectsUnits(false);
		}
		if (affectsCorpses != null) {
			theAura.setAffectsCorpses(affectsCorpses.callback(caster, localStore, castId));
		} else {
			theAura.setAffectsCorpses(false);
		}
		if (affectsDestructables != null) {
			theAura.setAffectsDests(affectsDestructables.callback(caster, localStore, castId));
		} else {
			theAura.setAffectsDests(false);
		}
		if (affectsItems != null) {
			theAura.setAffectsItems(affectsItems.callback(caster, localStore, castId));
		} else {
			theAura.setAffectsItems(false);
		}
	}
}