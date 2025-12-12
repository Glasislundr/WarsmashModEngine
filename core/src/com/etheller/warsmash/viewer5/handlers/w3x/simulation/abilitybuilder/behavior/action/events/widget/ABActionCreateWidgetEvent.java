package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.events.widget;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget.ABWidgetCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.event.ABWidgetEvent;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.JassGameEventsWar3;

public class ABActionCreateWidgetEvent implements ABAction {

	private ABWidgetCallback widget;
	private ABCondition condition;
	private List<ABAction> actions;

	private JassGameEventsWar3 eventType;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {

		final ABWidgetEvent event = new ABWidgetEvent(caster, localStore, castId,
				this.widget.callback(caster, localStore, castId), this.eventType, this.condition, this.actions);

		localStore.put(ABLocalStoreKeys.LASTCREATEDWIDEVENT, event);
	}
}
