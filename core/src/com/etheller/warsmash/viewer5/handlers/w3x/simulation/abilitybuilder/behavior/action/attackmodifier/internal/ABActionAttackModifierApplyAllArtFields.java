
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.attackmodifier.internal;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitAttackSettings;

public class ABActionAttackModifierApplyAllArtFields implements ABAction {

	private ABBooleanCallback applyArtIfMissing;
	
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CUnitAttackSettings settings = (CUnitAttackSettings) localStore.get(ABLocalStoreKeys.ATTACKSETTINGS + castId);
		ABAbilityBuilderAbility abil = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		String art = abil.getAbilityStringField("Missileart");
		if ((art != null && !art.isBlank()) || (applyArtIfMissing != null && applyArtIfMissing.callback(caster, localStore, castId))) {
			settings.setProjectileArt(art);
		}
		settings.setProjectileSpeed(abil.getAbilityIntField("Missilespeed"));
		settings.setProjectileArc(abil.getAbilityFloatField("Missilearc"));
		settings.setProjectileHomingEnabled(abil.getAbilityBooleanField("MissileHoming"));
	}
}