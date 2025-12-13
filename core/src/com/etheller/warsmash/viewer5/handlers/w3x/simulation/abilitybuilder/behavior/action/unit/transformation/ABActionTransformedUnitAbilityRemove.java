package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.transformation;

import java.util.List;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnitType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleans.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.handler.ABTransformationHandler;

public class ABActionTransformedUnitAbilityRemove implements ABAction {

	private ABUnitCallback unit;
	private ABIDCallback baseUnitId;
	private ABIDCallback alternateUnitId;

	private ABBooleanCallback keepRatios;

	private ABBooleanCallback permanent;

	private List<ABAction> onUntransformActions;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, final int castId) {
		boolean perm = false;
		if (permanent != null) {
			perm = permanent.callback(caster, localStore, castId);
		}
		if (!perm) {
			CUnit u1 = caster;
			if (unit != null) {
				u1 = unit.callback(caster, localStore, castId);
			}
			War3ID baseId = baseUnitId.callback(caster, localStore, castId);
			War3ID altId = alternateUnitId.callback(caster, localStore, castId);
			ABAbilityBuilderAbility abil = (ABAbilityBuilderAbility) localStore.get(ABLocalStoreKeys.ABILITY);

			if (baseId == null || altId == null) {
				return;
			}

			// Only care if already transformed
			CUnitType targetType = localStore.game.getUnitData().getUnitType(altId);
			if (!targetType.equals(u1.getUnitType())) {
				// No need to do anything
				return;
			}

			boolean isKeepRatios = true;
			if (keepRatios != null) {
				isKeepRatios = keepRatios.callback(caster, localStore, castId);
			}
			CUnitType baseType = localStore.game.getUnitData().getUnitType(baseId);

			if (onUntransformActions != null) {
				for (ABAction action : onUntransformActions) {
					action.runAction(u1, localStore, castId);
				}
			}
			ABTransformationHandler.setUnitID(localStore, u1, baseType, isKeepRatios, perm, null, abil, true);
		}
	}

}
