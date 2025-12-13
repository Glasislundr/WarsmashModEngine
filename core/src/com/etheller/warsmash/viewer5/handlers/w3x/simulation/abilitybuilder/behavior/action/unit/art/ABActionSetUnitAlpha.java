package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.art;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionSetUnitAlpha implements ABSingleAction {

	private ABUnitCallback unit;
	private ABFloatCallback value;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final CUnit targetUnit = this.unit.callback(caster, localStore, castId);
		final float[] color = localStore.game.getUnitVertexColor(targetUnit);

		localStore.game.changeUnitVertexColor(targetUnit, color[0], color[1], color[2],
				this.value.callback(caster, localStore, castId));
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		throw new UnsupportedOperationException();
	}

}
