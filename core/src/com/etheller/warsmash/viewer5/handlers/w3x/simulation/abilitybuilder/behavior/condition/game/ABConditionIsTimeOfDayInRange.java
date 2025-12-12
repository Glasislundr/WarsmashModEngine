package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.game;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsTimeOfDayInRange extends ABCondition {

	private ABFloatCallback startTime;
	private ABFloatCallback endTime;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, final int castId) {
		float st = 0;
		float et = Float.MAX_VALUE;
		if (startTime != null) {
			st = startTime.callback(caster, localStore, castId);
		}
		if (endTime != null) {
			et = endTime.callback(caster, localStore, castId);
		}
		return st <= et ? localStore.game.getGameTimeOfDay() >= st && localStore.game.getGameTimeOfDay() < et
				: localStore.game.getGameTimeOfDay() >= st || localStore.game.getGameTimeOfDay() < et;
	}

}
