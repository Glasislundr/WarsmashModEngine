package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import java.util.Map;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;

public class ABActionAddNonStackingDisplayBuff implements ABSingleAction {

	private ABUnitCallback target;
	private ABStringCallback key;
	private ABBuffCallback buff;

	@Override
	public void runAction(final CSimulation game, final CUnit caster, final Map<String, Object> localStore,
			final int castId) {
		final CBuff ability = this.buff.callback(game, caster, localStore, castId);
		this.target.callback(game, caster, localStore, castId).addNonStackingDisplayBuff(game,
				this.key.callback(game, caster, localStore, castId), ability);
		localStore.put(ABLocalStoreKeys.LASTADDEDBUFF, ability);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "AddUnitNonStackingDisplayBuffAU(" + this.target.generateJassEquivalent(jassTextGenerator) + ", "
				+ jassTextGenerator.getTriggerLocalStore() + ", " + this.key.generateJassEquivalent(jassTextGenerator)
				+ ", " + this.buff.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
