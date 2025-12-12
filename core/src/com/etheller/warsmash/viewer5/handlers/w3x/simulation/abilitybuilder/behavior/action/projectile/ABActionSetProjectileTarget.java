package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.projectile;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.projectile.ABProjectileCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CProjectile;

public class ABActionSetProjectileTarget implements ABSingleAction {

	private ABProjectileCallback projectile;
	private ABUnitCallback target;

	@Override
	public void runAction(final CUnit caster, final LocalDataStore localStore,
			final int castId) {

		final CProjectile proj = this.projectile.callback(caster, localStore, castId);

		proj.setTarget(this.target.callback(caster, localStore, castId));
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "SetProjectileTargetUnit(" + this.projectile.generateJassEquivalent(jassTextGenerator) + ", "
				+ this.target.generateJassEquivalent(jassTextGenerator) + ")";
	}
}
