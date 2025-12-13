package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import java.util.List;
import java.util.Map;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.buff.ABTimedTargetingBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionCreateTimedTargetingBuff implements ABSingleAction {

	private ABIDCallback buffId;
	private ABFloatCallback duration;

	private ABBooleanCallback stacks;

	private List<ABStringCallback> uniqueFlags;
	private Map<String, ABCallback> uniqueValues;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		final ABTimedTargetingBuff ability = new ABTimedTargetingBuff(localStore.game.getHandleIdAllocator().createId(),
				this.buffId.callback(caster, localStore, castId), localStore,
				(CAbility) localStore.get(ABLocalStoreKeys.ABILITY), caster,
				this.duration.callback(caster, localStore, castId));
		if (uniqueFlags != null) {
			for (ABStringCallback flag : uniqueFlags) {
				ability.addUniqueFlag(flag.callback(caster, localStore, castId));
			}
		}
		if (uniqueValues != null) {
			for (String key : uniqueValues.keySet()) {
				ability.addUniqueValue(uniqueValues.get(key).callback(caster, localStore, castId), key);
			}
		}
		boolean isStacks = false;
		if (stacks != null) {
			isStacks = stacks.callback(caster, localStore, castId);
		}
		ability.setStacks(isStacks);

		localStore.put(ABLocalStoreKeys.LASTCREATEDBUFF, ability);
		if (!localStore.containsKey(ABLocalStoreKeys.BUFFCASTINGUNIT)) {
			localStore.put(ABLocalStoreKeys.BUFFCASTINGUNIT, caster);
		}

	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "CreateTimedTargetingBuffAU(" + jassTextGenerator.getCaster() + ", "
				+ jassTextGenerator.getTriggerLocalStore() + ", "
				+ this.buffId.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.duration.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
