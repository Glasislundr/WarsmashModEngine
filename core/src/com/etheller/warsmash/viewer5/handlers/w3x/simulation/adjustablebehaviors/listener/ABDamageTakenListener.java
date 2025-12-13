package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.listener;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitAttackDamageTakenListener;

public class ABDamageTakenListener implements CUnitAttackDamageTakenListener {

	private ABLocalDataStore localStore;
	private ABIntegerCallback priority;
	private List<ABAction> actions;

	private int triggerId = 0;
	private boolean useCastId;

	public ABDamageTakenListener(ABLocalDataStore localStore, ABIntegerCallback priority, List<ABAction> actions,
			int castId, boolean useCastId) {
		this.localStore = localStore;
		this.priority = priority;
		this.actions = actions;
		this.useCastId = useCastId;
		if (useCastId) {
			this.triggerId = castId;
		}
	}

	@Override
	public int getPriority(CSimulation simulation, CUnit target, CDamageCalculation damage) {
		if (priority == null) {
			return 0;
		}
		localStore.put(ABLocalStoreKeys.DAMAGINGUNIT + triggerId, damage.getSource());
		localStore.put(ABLocalStoreKeys.DAMAGEDUNIT + triggerId, target);
		localStore.put(ABLocalStoreKeys.DAMAGECALC + triggerId, damage);
		int prio = this.priority.callback(target, this.localStore, this.triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGINGUNIT + triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGEDUNIT + triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGECALC + triggerId);
		return prio;
	}

	@Override
	public void onDamage(CSimulation simulation, CUnit target, CDamageCalculation damage) {
		localStore.put(ABLocalStoreKeys.DAMAGINGUNIT + triggerId, damage.getSource());
		localStore.put(ABLocalStoreKeys.DAMAGEDUNIT + triggerId, target);
		localStore.put(ABLocalStoreKeys.DAMAGECALC + triggerId, damage);
		if (actions != null) {
			for (ABAction action : actions) {
				action.runAction(target, localStore, triggerId);
			}
		}
		localStore.remove(ABLocalStoreKeys.DAMAGINGUNIT + triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGEDUNIT + triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGECALC + triggerId);
		if (!this.useCastId) {
			this.triggerId++;
		}
	}

}
