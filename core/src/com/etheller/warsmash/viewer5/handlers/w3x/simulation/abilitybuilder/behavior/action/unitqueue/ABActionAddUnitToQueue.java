package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitqueue;

import java.util.Queue;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue.ABUnitQueueCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionAddUnitToQueue implements ABSingleAction {

	private ABUnitQueueCallback queue;
	private ABUnitCallback unit;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		final Queue<CUnit> groupQueue = this.queue.callback(caster, localStore, castId);
		final CUnit rUnit = this.unit.callback(caster, localStore, castId);
		groupQueue.add(rUnit);
		localStore.put(ABLocalStoreKeys.LASTADDEDUNIT, rUnit);
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "GroupAddUnitAU(" + this.queue.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.unit.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
