package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.vision;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.player.ABPlayerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.visionmodifier.ABVisionModifierCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionRemoveVisionModifier implements ABAction {
	
	private ABVisionModifierCallback modifier;
	private ABPlayerCallback player;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, int castId) {
		player.callback(caster, localStore, castId).removeFogModifer(localStore.game,
				modifier.callback(caster, localStore, castId));
	}

}
