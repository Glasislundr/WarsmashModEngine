package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats;

import com.etheller.warsmash.units.GameObject;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.types.definitions.impl.AbilityFields;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;

public class ABCallbackGetAbilityProjectileSpeed extends ABFloatCallback {

	@Override
	public Float callback(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {

		final GameObject editorData = (GameObject) localStore.get(ABLocalStoreKeys.ABILITYEDITORDATA);
		return editorData.getFieldAsFloat(AbilityFields.PROJECTILE_SPEED, 0);
	}

}
