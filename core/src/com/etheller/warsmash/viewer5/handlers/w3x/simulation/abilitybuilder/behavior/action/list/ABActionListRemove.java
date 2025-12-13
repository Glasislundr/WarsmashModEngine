package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.list;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.list.ABListCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionListRemove implements ABAction {

	private ABListCallback<?> list;
	private ABIntegerCallback index;
	private ABCallback object;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		final List<?> l = this.list.callback(caster, localStore, castId);
		if (object != null) {
			l.remove(object.callback(caster, localStore, castId));
		} else {
			l.remove(index.callback(caster, localStore, castId).intValue());
		}
	}
}
