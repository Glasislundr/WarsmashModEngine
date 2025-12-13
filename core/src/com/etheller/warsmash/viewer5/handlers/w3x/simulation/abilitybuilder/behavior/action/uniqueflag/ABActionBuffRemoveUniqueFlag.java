package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.uniqueflag;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buff.ABBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.buff.ABBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionBuffRemoveUniqueFlag implements ABSingleAction {

	private ABBuffCallback buff;
	private ABStringCallback flag;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		final CBuff theBuff = this.buff.callback(caster, localStore, castId);
		if (theBuff instanceof ABBuff) {
			((ABBuff)theBuff).removeUniqueFlag(flag.callback(caster, localStore, castId));
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "JASSTODO";
	}
}
