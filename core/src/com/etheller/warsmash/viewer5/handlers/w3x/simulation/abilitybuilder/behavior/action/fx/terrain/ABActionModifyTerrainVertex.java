package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.fx.terrain;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.location.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionModifyTerrainVertex implements ABAction {

	private ABLocationCallback location;
	private ABFloatCallback dz;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		final AbilityPointTarget loc = this.location.callback(caster, localStore, castId);
		localStore.game.adjustTerrain(loc.x, loc.y, dz.callback(caster, localStore, castId));
	}
}
