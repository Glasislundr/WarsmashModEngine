package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponent;

public class ABActionCreateLoopingSoundEffectAtLocation implements ABAction {

	private ABLocationCallback location;
	private ABIDCallback id;

	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		AbilityPointTarget loc = location.callback(caster, localStore, castId);
		SimulationRenderComponent ret = localStore.game.locationSoundEffectEvent(loc.getX(), loc.getY(),
				this.id.callback(caster, localStore, castId), true);
		localStore.put(ABLocalStoreKeys.LASTCREATEDFX, ret);
	}
}
