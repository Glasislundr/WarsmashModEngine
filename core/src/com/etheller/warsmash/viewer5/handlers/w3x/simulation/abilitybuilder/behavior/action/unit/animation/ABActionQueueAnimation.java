package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.animation;

import com.etheller.warsmash.viewer5.handlers.w3x.AnimationTokens.PrimaryTag;
import com.etheller.warsmash.viewer5.handlers.w3x.SequenceUtils;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionQueueAnimation implements ABAction {

	private ABUnitCallback unit;
	private ABStringCallback tag;

	private ABBooleanCallback allowVariations;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, final int castId) {
		final CUnit targetUnit = this.unit.callback(caster, localStore, castId);
		boolean av = false;
		if (this.allowVariations != null) {
			av = this.allowVariations.callback(caster, localStore, castId);
		}

		targetUnit.getUnitAnimationListener().queueAnimation(
				PrimaryTag.valueOf(this.tag.callback(caster, localStore, castId)), SequenceUtils.EMPTY, av);
	}


}
