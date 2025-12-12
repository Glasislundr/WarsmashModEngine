package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.jass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.etheller.interpreter.ast.scope.trigger.TriggerBooleanExpression;
import com.etheller.warsmash.parsers.jass.scope.CommonTriggerExecutionScope;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionJass extends ABCondition {
	private final TriggerBooleanExpression boolExpr;

	public ABConditionJass(final TriggerBooleanExpression boolExpr) {
		this.boolExpr = boolExpr;
	}

	@Override
	public Boolean callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		return this.boolExpr.evaluate(localStore.game.getGlobalScope(),
				CommonTriggerExecutionScope.abilityBuilder(caster, localStore, castId));
	}

	public static List<ABCondition> wrap(final TriggerBooleanExpression jassFunction) {
		if (jassFunction == null) {
			return Collections.emptyList();
		} else {
			return Arrays.asList(new ABConditionJass(jassFunction));
		}
	}

}
