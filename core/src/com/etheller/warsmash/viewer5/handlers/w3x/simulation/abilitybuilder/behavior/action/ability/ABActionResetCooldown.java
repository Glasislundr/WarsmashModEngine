package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.parsers.jass.JassTextGeneratorType;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.AbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.visitor.GetABAbilityByRawcodeVisitor;

public class ABActionResetCooldown implements ABSingleAction {

	private ABIDCallback alias;
	private ABUnitCallback unit;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {
		CUnit theUnit = caster;
		if (this.unit != null) {
			theUnit = this.unit.callback(caster, localStore, castId);
		}
		if (this.alias != null) {
			final War3ID aliasId = this.alias.callback(caster, localStore, castId);
			final AbilityBuilderAbility abil = theUnit
					.getAbility(GetABAbilityByRawcodeVisitor.getInstance().reset(aliasId));
			if (abil != null) {
				abil.resetCooldown(localStore.game, theUnit);
			}
		}
		else {
			final AbilityBuilderAbility abil = (AbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);
			abil.resetCooldown(localStore.game, theUnit);
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
			return "EndUnitAbilityCooldown(" + unitExpression + ", "
					+ this.alias.generateJassEquivalent(jassTextGenerator) + ")";
		}
		else {
			return "EndAbilityCooldown(" + unitExpression + ", "
					+ jassTextGenerator.getUserDataExpr("AB_LOCAL_STORE_KEY_ABILITY", JassTextGeneratorType.AbilityHandle)
					+ ")";
		}
	}
}
