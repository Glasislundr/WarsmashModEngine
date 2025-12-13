package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.vision;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.player.ABPlayerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.vision.CUnitVisionFogModifier;

public class ABActionCreateUnitVisionModifier implements ABAction {

	private ABUnitCallback unit;
	private ABPlayerCallback player;
	private ABBooleanCallback alwaysNightVision;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, int castId) {
		boolean alwaysNight = false;
		if (this.alwaysNightVision != null) {
			alwaysNight = this.alwaysNightVision.callback(caster, localStore, castId);
		}

		final CUnitVisionFogModifier vision = new CUnitVisionFogModifier(this.unit.callback(caster, localStore, castId),
				alwaysNight);
		if (this.player != null) {
			this.player.callback(caster, localStore, castId).addFogModifer(localStore.game, vision, false);
		}
		localStore.put(ABLocalStoreKeys.LASTCREATEDVISIONMODIFIER, vision);
	}

}
