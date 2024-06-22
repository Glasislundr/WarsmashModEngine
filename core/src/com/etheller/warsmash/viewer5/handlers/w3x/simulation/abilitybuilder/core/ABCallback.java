package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core;

import java.util.Map;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;

public interface ABCallback {

	public Object callback(final CSimulation game, final CUnit caster, final Map<String, Object> localStore,
			final int castId);

	abstract public String generateJassEquivalent(JassTextGenerator jassTextGenerator);
}
