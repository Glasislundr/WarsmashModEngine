package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.transformation;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionTransformUnitAppearance implements ABAction {

	private ABUnitCallback unit;
	private ABIDCallback id;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final CUnit targetUnit = this.unit.callback(caster, localStore, castId);
		localStore.game.unitUpdatedType(targetUnit, id.callback(caster, localStore, castId), false);
	}

}
