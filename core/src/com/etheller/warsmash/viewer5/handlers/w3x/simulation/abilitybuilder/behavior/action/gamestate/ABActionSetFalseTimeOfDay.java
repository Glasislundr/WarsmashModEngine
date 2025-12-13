package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.gamestate;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionSetFalseTimeOfDay implements ABSingleAction {

	private ABIntegerCallback hour;
	private ABIntegerCallback minute;
	private ABFloatCallback duration;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		localStore.game.addFalseTimeOfDay(this.hour.callback(caster, localStore, castId),
				this.minute.callback(caster, localStore, castId),
				this.duration.callback(caster, localStore, castId));
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "SetFalseTimeOfDay(" + this.hour.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.minute.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.duration.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
