
package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.stats;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enums.ABNonStackingStatBuffTypeCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;

public class ABActionCreateNonStackingStatBuff implements ABSingleAction {

	private ABNonStackingStatBuffTypeCallback buffType;
	private ABStringCallback stackingKey;
	private ABFloatCallback value;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		final NonStackingStatBuff buff = new NonStackingStatBuff(
				this.buffType.callback(caster, localStore, castId),
				this.stackingKey.callback(caster, localStore, castId),
				this.value.callback(caster, localStore, castId));

		localStore.put(ABLocalStoreKeys.LASTCREATEDNSSB, buff);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "CreateNonStackingStatBuffAU(" + jassTextGenerator.getTriggerLocalStore() + ", "
				+ this.buffType.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.stackingKey.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.value.generateJassEquivalent(jassTextGenerator) + ")";
	}
}