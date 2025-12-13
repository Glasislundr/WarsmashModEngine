package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.uniquevalue;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ability.ABAbilityCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;

public class ABActionAbilityRemoveUniqueValue implements ABAction {

	private ABAbilityCallback ability;
	private ABStringCallback key;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		CAbility theAbility = null;
		if (ability != null) {
			theAbility = ability.callback(caster, localStore, castId);
		} else {
			theAbility = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		}
		theAbility.removeUniqueValue(key.callback(caster, localStore, castId));
	}

}
