package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.item;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItem;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item.ABItemCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionChargeItem implements ABSingleAction {

	private ABItemCallback item;
	private ABBooleanCallback checkForPerish;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId) {
		CItem it = null;
		if (this.item == null) {
			final AbilityBuilderAbility ability = (AbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);

			it = ability.getItem();
		} else {
			it = this.item.callback(caster, localStore, castId);
		}

		it.setCharges(it.getCharges() - 1);
		if ((this.checkForPerish != null) && this.checkForPerish.callback(caster, localStore, castId)
				&& it.getItemType().isPerishable() && (it.getCharges() == 0)) {
			it.forceDropIfHeld(localStore.game);
			localStore.game.removeItem(it);
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		String itemExpression = "null";
		if (this.item != null) {
			itemExpression = this.item.generateJassEquivalent(jassTextGenerator);
		}
		String checkForPerishExpression = "false";
		if (this.checkForPerish != null) {
			checkForPerishExpression = this.checkForPerish.generateJassEquivalent(jassTextGenerator);
		}
		return "ChargeItemAU(" + itemExpression + ", " + checkForPerishExpression + ", "
				+ jassTextGenerator.getTriggerLocalStore() + ")";
	}
}
