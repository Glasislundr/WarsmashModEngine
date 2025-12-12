package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveBuff implements ABSingleAction {

	private ABUnitCallback target;
	private ABBuffCallback buff;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final CBuff theBuff = this.buff.callback(caster, localStore, castId);
		if (theBuff != null) {
			(this.target.callback(caster, localStore, castId)).remove(localStore.game, theBuff);
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "RemoveUnitAbility(" + this.target.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.buff.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
