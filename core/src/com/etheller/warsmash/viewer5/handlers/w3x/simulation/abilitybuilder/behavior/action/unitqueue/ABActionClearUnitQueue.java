package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitqueue;

import java.util.Queue;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue.ABUnitQueueCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionClearUnitQueue implements ABSingleAction {

	private ABUnitQueueCallback queue;

	@Override
	public void runAction(final CSimulation game, final CUnit caster,
			final LocalDataStore localStore,
			final int castId) {
		final Queue<CUnit> groupQueue = this.queue.callback(game, caster, localStore, castId);
		groupQueue.clear();
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "GroupClear(" + this.queue.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
