package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core;

import com.etheller.warsmash.parsers.jass.JassTextGeneratorExpr;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;

public interface ABCallback extends JassTextGeneratorExpr {

	public Object callback(final CUnit caster, final ABLocalDataStore localStore, final int castId);
}
