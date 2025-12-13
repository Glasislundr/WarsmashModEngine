package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.destructable;

import java.util.EnumSet;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CDestructable;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.ABDestructableCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CTargetType;

public class ABConditionIsTree extends ABCondition {

	private ABDestructableCallback dest;

	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		CDestructable theDestructable = dest.callback(caster, localStore, castId);
		if (theDestructable != null) {
			return theDestructable.canBeTargetedBy(localStore.game, caster, EnumSet.of(CTargetType.TREE));
		}
		return false;
	}

}
