package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.projectile.ABProjectileCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CProjectile;

public class ABCallbackGetProjectileSourceUnit extends ABUnitCallback {

	private ABProjectileCallback proj;

	@Override
	public CUnit callback(final CUnit caster, final LocalDataStore localStore, final int castId) {
		CProjectile p = proj.callback(caster, localStore, castId);
		return p.getSource();
	}

}
