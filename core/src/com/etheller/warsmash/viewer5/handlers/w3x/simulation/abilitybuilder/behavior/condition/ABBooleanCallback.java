package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition;

import com.etheller.warsmash.parsers.jass.JassTextGeneratorExpr;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public abstract class ABBooleanCallback implements ABCallback, JassTextGeneratorExpr {

	abstract public Boolean callback(final CUnit caster, final ABLocalDataStore localStore, final int castId);
}
