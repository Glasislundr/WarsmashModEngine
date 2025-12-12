package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponent;

public class ABActionCreateLoopingSoundEffectOnUnit implements ABAction {

	private ABUnitCallback unit;
	private ABIDCallback id;

	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		SimulationRenderComponent ret = localStore.game.unitLoopSoundEffectEvent(
				(unit.callback(caster, localStore, castId)), this.id.callback(caster, localStore, castId));
		localStore.put(ABLocalStoreKeys.LASTCREATEDFX, ret);
	}
}
