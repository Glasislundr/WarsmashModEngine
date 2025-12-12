package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponent;

public class ABActionCreateUberSplat implements ABAction {

	private ABIDCallback id;
	private ABLocationCallback location;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, int castId) {
		AbilityPointTarget loc = location.callback(caster, localStore, castId);
		SimulationRenderComponent splat = localStore.game.createStaticUberSplat(loc.getX(), loc.getY(),
				id.callback(caster, localStore, castId));
		localStore.put(ABLocalStoreKeys.LASTCREATEDFX, splat);
	}

}
