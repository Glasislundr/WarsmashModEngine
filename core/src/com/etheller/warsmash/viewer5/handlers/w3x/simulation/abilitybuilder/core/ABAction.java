package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core;

import com.etheller.warsmash.parsers.jass.JassTextGeneratorStmt;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public interface ABAction extends JassTextGeneratorStmt {
	public void runAction(final CUnit caster, final LocalDataStore localStore, final int castId);

}
