package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import java.util.List;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.CAbilityTypeAbilityBuilderLevelData;

public class ABCallbackGetFirstEffectId extends ABIDCallback {

	@SuppressWarnings("unchecked")
	@Override
	public War3ID callback(CUnit caster, LocalDataStore localStore, final int castId) {
		List<War3ID> effects = ((List<CAbilityTypeAbilityBuilderLevelData>) localStore.get(ABLocalStoreKeys.LEVELDATA))
				.get(((int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL)) - 1).getEffects();
		if (effects != null && !effects.isEmpty()) {
			return effects.get(0);
		}
		return null;
	}

}
