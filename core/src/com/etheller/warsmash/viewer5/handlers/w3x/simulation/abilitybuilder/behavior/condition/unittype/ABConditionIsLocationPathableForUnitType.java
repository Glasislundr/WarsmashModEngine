package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unittype;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks.ABLocationCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABConditionIsLocationPathableForUnitType extends ABCondition {

	ABLocationCallback location;
	ABIDCallback unitType;

	@Override
	public Boolean callback(CUnit caster, LocalDataStore localStore, int castId) {
		War3ID uType = unitType.callback(caster, localStore, castId);
		AbilityPointTarget loc = location.callback(caster, localStore, castId);
		return localStore.game.getPathingGrid().isPathable(loc.x, loc.y,
				localStore.game.getUnitData().getUnitType(uType).getMovementType());
	}

}
