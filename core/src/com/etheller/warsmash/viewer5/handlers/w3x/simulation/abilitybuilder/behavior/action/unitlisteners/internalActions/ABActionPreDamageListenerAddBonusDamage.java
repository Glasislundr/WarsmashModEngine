
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalActions;

import java.util.Map;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks.ABDamageTypeCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CAttackDamageFlags;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageFlags;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CDamageType;

public class ABActionPreDamageListenerAddBonusDamage implements ABAction {

	private ABFloatCallback value;
	private ABDamageTypeCallback damageType;

	private ABBooleanCallback inheritFlags;
	private ABBooleanCallback isRanged;

	private ABBooleanCallback isIgnoreInvulnerable;
	private ABBooleanCallback isExplode;
	private ABBooleanCallback isOnlyDamageSummons;
	private ABBooleanCallback isNonlethal;
	private ABBooleanCallback isPassLimitedMagicImmune;

	public void runAction(final CSimulation game, final CUnit caster, final Map<String, Object> localStore,
			final int castId) {
		CDamageType theDamageType = null;
		if (damageType != null) {
			theDamageType = damageType.callback(game, caster, localStore, castId);
		}

		CDamageCalculation damage = ((CDamageCalculation) localStore.get(ABLocalStoreKeys.DAMAGECALC + castId));

		CDamageFlags theFlags = null;
		if (inheritFlags == null || inheritFlags.callback(game, caster, localStore, castId)) {
			theFlags = damage.getPrimaryDamageFlags().copy();
		} else if (isRanged != null || isIgnoreInvulnerable != null || isExplode != null || isOnlyDamageSummons != null
				|| isNonlethal != null || isPassLimitedMagicImmune != null) {
			boolean ranged;
			if (isRanged == null) {
				ranged = damage.getPrimaryDamageFlags().isRanged();
			} else {
				ranged = isRanged.callback(game, caster, localStore, castId);
			}
			theFlags = new CAttackDamageFlags(ranged);
		}

		if (isIgnoreInvulnerable != null) {
			theFlags.setIgnoreInvulnerable(isIgnoreInvulnerable.callback(game, caster, localStore, castId));
		}
		if (isExplode != null) {
			theFlags.setExplode(isExplode.callback(game, caster, localStore, castId));
		}
		if (isOnlyDamageSummons != null) {
			theFlags.setOnlyDamageSummons(isOnlyDamageSummons.callback(game, caster, localStore, castId));
		}
		if (isNonlethal != null) {
			theFlags.setNonlethal(isNonlethal.callback(game, caster, localStore, castId));
		}
		if (isPassLimitedMagicImmune != null) {
			theFlags.setPassLimitedMagicImmune(isPassLimitedMagicImmune.callback(game, caster, localStore, castId));
		}

		damage.addBonusDamage(value.callback(game, caster, localStore, castId), theDamageType, theFlags);
	}
}