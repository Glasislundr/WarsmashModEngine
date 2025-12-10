package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABCallbackDetectionDropdownConversion extends ABIntegerCallback {

	private ABIntegerCallback value;
	
	@Override
	public Integer callback(CSimulation game, CUnit caster, LocalDataStore localStore, final int castId) {
		int val = value.callback(game, caster, localStore, castId);
		switch(val) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 127;
		default:
				
		}
		return 0;
	}

}
