package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CEffectType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponent;

public class ABActionCreateSpellEffectOnUnit implements ABAction {

	private ABUnitCallback target;
	private ABIDCallback id;
	private CEffectType effectType;
	private ABIntegerCallback index;

	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		War3ID theId = null;
		if (id == null) {
			theId = (War3ID) localStore.get(ABLocalStoreKeys.ALIAS);
		} else {
			theId = id.callback(caster, localStore, castId);
		}
		if (index == null) {
			SimulationRenderComponent ret = localStore.game.createPersistentSpellEffectOnUnit(
					(target.callback(caster, localStore, castId)), theId, this.effectType);
			localStore.put(ABLocalStoreKeys.LASTCREATEDFX, ret);
		} else {
			SimulationRenderComponent ret = localStore.game.createPersistentSpellEffectOnUnit(
					(target.callback(caster, localStore, castId)), this.id.callback(caster, localStore, castId),
					this.effectType, this.index.callback(caster, localStore, castId));
			localStore.put(ABLocalStoreKeys.LASTCREATEDFX, ret);
		}
	}
}
