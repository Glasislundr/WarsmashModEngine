
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.stats;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statbuffcallbacks.ABNonStackingStatBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;

public class ABActionUpdateNonStackingStatBuff implements ABSingleAction {

	private ABNonStackingStatBuffCallback buff;
	private ABFloatCallback value;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final NonStackingStatBuff buffObj = this.buff.callback(caster, localStore, castId);
		buffObj.setValue(this.value.callback(caster, localStore, castId));
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "UpdateNonStackingStatBuff(" + this.buff.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.value.generateJassEquivalent(jassTextGenerator) + ")";
	}
}