package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackRandomLocationInRange extends ABLocationCallback {

	private ABLocationCallback origin;
	private ABFloatCallback range;

	@Override
	public AbilityPointTarget callback(CUnit caster, LocalDataStore localStore, final int castId) {
		final AbilityPointTarget orig = this.origin.callback(caster, localStore, castId);
		final float d = this.range.callback(caster, localStore, castId) * localStore.game.getSeededRandom().nextFloat();
		final float a = (float) (Math.PI * 2 * localStore.game.getSeededRandom().nextFloat());

		orig.add((float) (d * Math.cos(a)), (float) (d * Math.sin(a)));
		return orig;
	}

}
