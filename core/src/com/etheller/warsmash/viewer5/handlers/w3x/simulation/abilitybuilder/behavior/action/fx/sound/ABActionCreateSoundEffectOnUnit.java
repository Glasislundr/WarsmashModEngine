package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx.sound;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponent;

public class ABActionCreateSoundEffectOnUnit implements ABAction {

	private ABUnitCallback unit;
	private ABIDCallback id;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		SimulationRenderComponent ret = localStore.game.unitSoundEffectEvent(
				(unit.callback(caster, localStore, castId)), this.id.callback(caster, localStore, castId));
		localStore.put(ABLocalStoreKeys.LASTCREATEDFX, ret);
	}
}
