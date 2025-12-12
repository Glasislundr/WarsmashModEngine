package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionAddNewAbility implements ABSingleAction {

	private ABUnitCallback unit;
	private ABIDCallback id;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final CAbility ability = localStore.game.getAbilityData()
				.getAbilityType(this.id.callback(caster, localStore, castId))
				.createAbility(localStore.game.getHandleIdAllocator().createId());
		localStore.put(ABLocalStoreKeys.LASTCREATEDABILITY, ability);
		this.unit.callback(caster, localStore, castId).add(localStore.game, ability);
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "AddNewAbilityAU(" + jassTextGenerator.getTriggerLocalStore() + ", "
				+ this.unit.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.id.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
