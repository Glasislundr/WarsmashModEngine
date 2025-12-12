package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveNonStackingDisplayBuff implements ABSingleAction {

	private ABUnitCallback target;
	private ABStringCallback key;
	private ABBuffCallback buff;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final CBuff ability = this.buff.callback(caster, localStore, castId);
		this.target.callback(caster, localStore, castId).removeNonStackingDisplayBuff(localStore.game,
				this.key.callback(caster, localStore, castId), ability);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "RemoveUnitNonStackingDisplayBuff(" + this.target.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.key.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.buff.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
