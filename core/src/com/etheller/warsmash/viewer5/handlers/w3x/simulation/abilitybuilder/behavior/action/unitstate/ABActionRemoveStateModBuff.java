
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitstate;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemod.ABStateModBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABActionRemoveStateModBuff implements ABAction {

	private ABUnitCallback targetUnit;
	private ABStateModBuffCallback buff;

	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		CUnit target = targetUnit.callback(caster, localStore, castId);
		StateModBuff theBuff = buff.callback(caster, localStore, castId);

		target.removeStateModBuff(theBuff);
		target.computeUnitState(localStore.game, theBuff.getBuffType());
	}
}