package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.abilitydata;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbilityDisableType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.visitor.ABGetABAbilityByRawcodeVisitor;

public class ABActionEnableAbilityById implements ABSingleAction {

	private ABIDCallback alias;
	private ABUnitCallback unit;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore,
			final int castId) {
		CUnit theUnit = caster;
		if (this.unit != null) {
			theUnit = this.unit.callback(caster, localStore, castId);
		}
		if (this.alias != null) {
			final War3ID aliasId = this.alias.callback(caster, localStore, castId);
			final ABAbilityBuilderAbility abil = theUnit
					.getAbility(ABGetABAbilityByRawcodeVisitor.getInstance().reset(aliasId));
			if (abil != null) {
				abil.setDisabled(false, CAbilityDisableType.ABILITYINTERNAL);
			}
		}
		else {
			final ABAbilityBuilderAbility abil = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
			abil.setDisabled(false, CAbilityDisableType.ABILITYINTERNAL);
		}
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		String unitExpression;
		if (this.unit != null) {
			unitExpression = this.unit.generateJassEquivalent(jassTextGenerator);
		}
		else {
			unitExpression = jassTextGenerator.getCaster();
		}
		if (this.alias != null) {
			return "TODOJASS";
		}
		else {
			return "TODOJASS";
		}
	}
}
