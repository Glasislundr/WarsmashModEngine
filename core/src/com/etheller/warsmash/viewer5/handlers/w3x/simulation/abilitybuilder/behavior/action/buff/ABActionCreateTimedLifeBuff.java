package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.skills.util.CBuffTimedLife;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionCreateTimedLifeBuff implements ABSingleAction {

	private ABIDCallback buffId;
	private ABFloatCallback duration;
	private ABBooleanCallback explode;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		final CBuffTimedLife ability = new CBuffTimedLife(localStore.game.getHandleIdAllocator().createId(),
				this.buffId.callback(caster, localStore, castId), this.duration.callback(caster, localStore, castId),
				this.explode.callback(caster, localStore, castId));
		localStore.put(ABLocalStoreKeys.LASTCREATEDBUFF, ability);
		if (!localStore.containsKey(ABLocalStoreKeys.BUFFCASTINGUNIT)) {
			localStore.put(ABLocalStoreKeys.BUFFCASTINGUNIT, caster);
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "CreateTimedLifeBuffAU(" + jassTextGenerator.getCaster() + ", "
				+ jassTextGenerator.getTriggerLocalStore() + ", "
				+ this.buffId.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.duration.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.explode.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
