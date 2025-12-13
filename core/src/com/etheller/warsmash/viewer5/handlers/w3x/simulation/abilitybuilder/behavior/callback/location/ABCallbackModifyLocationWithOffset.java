package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABCallbackModifyLocationWithOffset extends ABLocationCallback {

	private ABLocationCallback origin;
	private ABFloatCallback dist;
	private ABFloatCallback angle;
	
	private ABBooleanCallback angleInDegrees;

	@Override
	public AbilityPointTarget callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final AbilityPointTarget orig = this.origin.callback(caster, localStore, castId);
		final float d = this.dist.callback(caster, localStore, castId);
		final float a = this.angle.callback(caster, localStore, castId);
		
		if (angleInDegrees != null && angleInDegrees.callback(caster, localStore, castId)) {
			orig.add((float)(d * Math.cos(Math.toRadians(a))), (float)(d * Math.sin(Math.toRadians(a))));
			return orig;
		}
		orig.add((float)(d * Math.cos(a)), (float)(d * Math.sin(a)));
		return orig;
	}

}
