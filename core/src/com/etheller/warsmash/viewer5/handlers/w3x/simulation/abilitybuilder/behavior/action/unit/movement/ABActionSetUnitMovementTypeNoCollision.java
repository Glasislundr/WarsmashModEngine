package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.movement;

import java.util.Map;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;

public class ABActionSetUnitMovementTypeNoCollision implements ABAction {

	private ABUnitCallback unit;
	private ABBooleanCallback active;

	@Override
	public void runAction(CSimulation game, CUnit caster, Map<String, Object> localStore, final int castId) {
			CUnit targetUnit = unit.callback(game, caster, localStore, castId);
			if (active != null) {
				targetUnit.setNoCollisionMovementType(active.callback(game, caster, localStore, castId));
			} else {
				targetUnit.setNoCollisionMovementType(true);
			}
	}

}
