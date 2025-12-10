package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItemType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.handler.RandomTypeHandler;

public class ABCallbackRandomItemId extends ABIDCallback {

	private ABIDCallback previousId;
	private ABIntegerCallback level;
	private ABBooleanCallback ignoreValidFlag;
	private ABBooleanCallback ignoreRandomFlag;

	@Override
	public War3ID callback(final CSimulation game, final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		if (previousId == null && level == null && ignoreValidFlag == null && ignoreRandomFlag == null) {
			return RandomTypeHandler.getRandomItemType(game).getTypeId();
		}

		War3ID id = null;
		int lv = -1;
		boolean valid = true;
		boolean random = false;
		if (previousId != null) {
			id = previousId.callback(game, caster, localStore, castId);
		}
		if (level != null) {
			lv = level.callback(game, caster, localStore, castId);
		}
		if (ignoreValidFlag != null) {
			valid = ignoreValidFlag.callback(game, caster, localStore, castId);
		}
		if (ignoreRandomFlag != null) {
			random = ignoreRandomFlag.callback(game, caster, localStore, castId);
		}
		CItemType type = RandomTypeHandler.getRandomItemType(game, id, lv, valid, random);
		if (type == null) {
			return null;
		}
		return type.getTypeId();
	}

}
