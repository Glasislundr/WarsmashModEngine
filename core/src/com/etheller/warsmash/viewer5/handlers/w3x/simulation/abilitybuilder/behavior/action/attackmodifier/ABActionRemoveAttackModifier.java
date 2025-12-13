
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attackmodifier;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.attack.ABAttackModifierCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionRemoveAttackModifier implements ABAction {

	private ABUnitCallback unit;
	private ABAttackModifierCallback modifier;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		CUnit target = unit.callback(caster, localStore, castId);

		target.removeAttackModifier(modifier.callback(caster, localStore, castId));
	}
}