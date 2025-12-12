package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit;

import java.util.ArrayList;
import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbilityCategory;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;

public class ABActionDispelBuffs implements ABAction {

	private ABUnitCallback source;
	private ABUnitCallback unit;
	private ABCondition filter;

	@Override
	public void runAction(CUnit caster, LocalDataStore localStore, final int castId) {
		CUnit theCaster = caster;
		if (source != null) {
			theCaster = source.callback(theCaster, localStore, castId);
		}
		CUnit theTarget = caster;
		if (unit != null) {
			theTarget = unit.callback(theCaster, localStore, castId);
		}

		if (theTarget != null) {
			List<CBuff> toRemove = new ArrayList<>();
			for (CAbility ability : theTarget.getAbilities()) {
				if (ability.getAbilityCategory() == CAbilityCategory.BUFF) {
					CBuff buff = (CBuff) ability;
					localStore.put(ABLocalStoreKeys.ENUMBUFF, buff);
					if (filter != null && filter.callback(theCaster, localStore, castId)) {
						toRemove.add(buff);
					}
				}
			}

			for (CBuff buff : toRemove) {
				theTarget.remove(localStore.game, buff);
			}
		}
	}

}
