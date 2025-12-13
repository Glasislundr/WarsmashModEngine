package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.queue.CAbilityRally;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionAddRallyAbility implements ABSingleAction {

	private ABUnitCallback unit;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final CAbility ability = new CAbilityRally(localStore.game.getHandleIdAllocator().createId());
		this.unit.callback(caster, localStore, castId).add(localStore.game, ability);
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "UnitAddAbility(" + this.unit.generateJassEquivalent(jassTextGenerator) + ", 'ARal')";
	}

}
