package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.destructable;

import com.etheller.warsmash.viewer5.handlers.w3x.AnimationTokens.PrimaryTag;
import com.etheller.warsmash.viewer5.handlers.w3x.SequenceUtils;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionCreateDestructable implements ABAction {

	private ABIDCallback id;
	private ABLocationCallback location;
	private ABFloatCallback facing;
	private ABFloatCallback scale;
	private ABIntegerCallback variation;

	private ABBooleanCallback playBirthAnim;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, final int castId) {
		float theFacing = 0;
		float theScale = 1;
		int theVariation = 0;
		boolean play = true;
		if (this.facing != null) {
			theFacing = this.facing.callback(caster, localStore, castId);
		}
		if (this.scale != null) {
			theScale = this.scale.callback(caster, localStore, castId);
		}
		if (this.variation != null) {
			theVariation = this.variation.callback(caster, localStore, castId);
		}
		if (this.playBirthAnim != null) {
			play = this.playBirthAnim.callback(caster, localStore, castId);
		}
		final AbilityPointTarget location = this.location.callback(caster, localStore, castId);
		final CDestructable createdDest = localStore.game.createDestructable(this.id.callback(caster, localStore, castId),
				location.getX(), location.getY(), theFacing, theScale, theVariation);
		if (play) {
			createdDest.getUnitAnimationListener().playAnimation(true, PrimaryTag.BIRTH, SequenceUtils.EMPTY, 1.0f,
					true);
		}
		localStore.put(ABLocalStoreKeys.LASTCREATEDDESTRUCTABLE, createdDest);
	}

}
