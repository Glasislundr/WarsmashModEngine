package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.events.timeofday;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.event.timeevent.ABTimeOfDayEventCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionRegisterTimeOfDayEvent implements ABSingleAction {

	private ABTimeOfDayEventCallback event;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		localStore.game.registerTimeOfDayEvent(this.event.callback(caster, localStore, castId));
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "RegisterABTimeOfDayEvent(" + this.event.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
