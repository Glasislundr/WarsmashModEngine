package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CEffectType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponent;

public class ABActionCreateSpellEffectAtPoint implements ABAction {

	private ABFloatCallback x;
	private ABFloatCallback y;
	private ABFloatCallback facing;
	private ABIDCallback id;
	private CEffectType effectType;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		float dir = 0;
		if (facing != null) {
			dir = facing.callback(caster, localStore, castId);
		}
		War3ID theId = null;
		if (id == null) {
			theId = (War3ID) localStore.get(ABLocalStoreKeys.ALIAS);
		} else {
			theId = id.callback(caster, localStore, castId);
		}
		SimulationRenderComponent ret = localStore.game.spawnSpellEffectOnPoint(x.callback(caster, localStore, castId),
				y.callback(caster, localStore, castId), dir, theId, effectType, 0);
		localStore.put(ABLocalStoreKeys.LASTCREATEDFX, ret);
	}
}
