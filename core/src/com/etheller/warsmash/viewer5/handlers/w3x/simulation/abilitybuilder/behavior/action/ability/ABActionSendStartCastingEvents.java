package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CWidget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget.ABWidgetCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.JassGameEventsWar3;

public class ABActionSendStartCastingEvents implements ABAction {

	private ABUnitCallback caster;
	private ABWidgetCallback target;
	@Override
	public void runAction(final CUnit basecaster, final ABLocalDataStore localStore,
			final int castId) {
		CUnit theUnit = basecaster;
		CWidget theTarget = null;
		if (caster != null) {
			theUnit = caster.callback(basecaster, localStore, castId);
		}
		if (target != null) {
			theTarget = target.callback(basecaster, localStore, castId);
		}
		CAbility theAbility = (CAbility) localStore.get(ABLocalStoreKeys.ABILITY);
		theUnit.fireSpellEvents(localStore.game, JassGameEventsWar3.EVENT_UNIT_SPELL_CHANNEL, theAbility, theTarget);
		theUnit.fireSpellEvents(localStore.game, JassGameEventsWar3.EVENT_UNIT_SPELL_CAST, theAbility, theTarget);
		theUnit.fireSpellEvents(localStore.game, JassGameEventsWar3.EVENT_UNIT_SPELL_EFFECT, theAbility, theTarget);
	}
}
