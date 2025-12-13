package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.destructablebuff;

import java.util.List;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.buff.ABDestructableBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public class ABActionCreateDestructableBuff implements ABSingleAction {

	private ABIDCallback buffId;
	private List<ABAction> onAddActions;
	private List<ABAction> onRemoveActions;
	private List<ABAction> onDeathActions;

	private ABBooleanCallback dispellable;

	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		boolean isDispellable = false;
		if (dispellable != null) {
			isDispellable = dispellable.callback(caster, localStore, castId);
		}
		CDestructableBuff ability = new ABDestructableBuff(localStore.game.getHandleIdAllocator().createId(),
				buffId.callback(caster, localStore, castId), (int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL),
				localStore, onAddActions, onRemoveActions, onDeathActions, castId, caster, isDispellable);

		localStore.put(ABLocalStoreKeys.LASTCREATEDDESTBUFF, ability);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		final String addFunctionName = jassTextGenerator.createAnonymousFunction(this.onAddActions,
				"CreateDestructableBuffAU_OnAddActions");
		final String removeFunctionName = jassTextGenerator.createAnonymousFunction(this.onRemoveActions,
				"CreateDestructableBuffAU_OnRemoveActions");
		final String deathFunctionName = jassTextGenerator.createAnonymousFunction(this.onDeathActions,
				"CreateDestructableBuffAU_OnDeathActions");

		return "CreateDestructableBuffAU(" + jassTextGenerator.getCaster() + ", "
				+ this.buffId.generateJassEquivalent(jassTextGenerator) + ", "
				+ jassTextGenerator.getTriggerLocalStore() + ", "
				+ jassTextGenerator.functionPointerByName(addFunctionName) + ", "
				+ jassTextGenerator.functionPointerByName(removeFunctionName) + ", "
				+ jassTextGenerator.functionPointerByName(deathFunctionName) + ", " + jassTextGenerator.getCastId()
				+ ")";
	}
}
