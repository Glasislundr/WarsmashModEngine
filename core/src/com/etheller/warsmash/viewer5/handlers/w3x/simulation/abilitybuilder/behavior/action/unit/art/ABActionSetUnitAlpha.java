package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.art;

import java.util.Map;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;

public class ABActionSetUnitAlpha implements ABAction {

	private ABUnitCallback unit;
	private ABFloatCallback alpha;

	@Override
	public void runAction(CSimulation game, CUnit caster, Map<String, Object> localStore, final int castId) {
		CUnit targetUnit = unit.callback(game, caster, localStore, castId);
		float[] color = game.getUnitVertexColor(targetUnit);

		game.changeUnitVertexColor(targetUnit, color[0], color[1], color[2],
				alpha.callback(game, caster, localStore, castId));
	}

}
