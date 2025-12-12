package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.destructable;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.ABDestructableCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructablebuff.ABDestructableBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveDestructableBuff implements ABSingleAction {

	private ABDestructableCallback target;
	private ABDestructableBuffCallback buff;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final CDestructableBuff ability = this.buff.callback(caster, localStore, castId);
		this.target.callback(caster, localStore, castId).remove(localStore.game, ability);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "RemoveDestructableBuff(" + this.target.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.buff.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
