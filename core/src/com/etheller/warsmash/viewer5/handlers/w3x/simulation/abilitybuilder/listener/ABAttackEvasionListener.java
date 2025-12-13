package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitAttackEvasionListener;

public class ABAttackEvasionListener implements CUnitAttackEvasionListener {

	private ABLocalDataStore localStore;
	private List<ABBooleanCallback> conditions;
	
	private int triggerId = 0;
	private boolean useCastId;
	
	public ABAttackEvasionListener(ABLocalDataStore localStore, List<ABBooleanCallback> conditions, int castId, boolean useCastId) {
		this.localStore = localStore;
		this.conditions = conditions;
		this.useCastId = useCastId;
		if (useCastId) {
			this.triggerId = castId;
		}
	}
	
	@Override
	public boolean onAttack(CSimulation simulation, CUnit target, CDamageCalculation damage) {
		boolean evade = false;
		if (conditions != null) {
			localStore.put(ABLocalStoreKeys.ATTACKINGUNIT+triggerId, damage.getSource());
			localStore.put(ABLocalStoreKeys.ATTACKTARGET+triggerId, target);
			localStore.put(ABLocalStoreKeys.DAMAGECALC+triggerId, damage);
			for (ABBooleanCallback condition : conditions) {
				evade = evade || condition.callback(target, localStore, triggerId);
			}
			localStore.remove(ABLocalStoreKeys.ATTACKINGUNIT+triggerId);
			localStore.remove(ABLocalStoreKeys.ATTACKTARGET+triggerId);
			localStore.remove(ABLocalStoreKeys.DAMAGECALC+triggerId);
		}
		if (!this.useCastId) {
			this.triggerId++;
		}
		return evade;
	}

}
