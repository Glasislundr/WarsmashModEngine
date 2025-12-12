package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.events.timeofday;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.eventcallbacks.timeeventcallbacks.ABTimeOfDayEventCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABTimeOfDayEvent;

public class ABActionRegisterUniqueTimeOfDayEvent implements ABSingleAction {

	private ABTimeOfDayEventCallback event;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final ABTimeOfDayEvent ev = this.event.callback(caster, localStore, castId);
		if (!localStore.game.isTimeOfDayEventRegistered(ev)) {
			localStore.game.registerTimeOfDayEvent(ev);
		}

	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "RegisterUniqueABTimeOfDayEvent(" + this.event.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
