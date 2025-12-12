package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttack;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitAttackPostDamageListener;

public class ABAttackPostDamageListener implements CUnitAttackPostDamageListener {

	private LocalDataStore localStore;
	private ABIntegerCallback priority;
	private List<ABAction> actions;
	
	private int triggerId = 0;
	private boolean useCastId;
	
	public ABAttackPostDamageListener(LocalDataStore localStore, ABIntegerCallback priority, List<ABAction> actions, int castId, boolean useCastId) {
		this.localStore = localStore;
		this.priority = priority;
		this.actions = actions;
		this.useCastId = useCastId;
		if (useCastId) {
			this.triggerId = castId;
		}
	}
	
	@Override
	public void onHit(CSimulation simulation, AbilityTarget target, CUnitAttack attack,
			CDamageCalculation damage) {
		localStore.put(ABLocalStoreKeys.ATTACKINGUNIT+triggerId, damage.getSource());
		localStore.put(ABLocalStoreKeys.ATTACKTARGET+triggerId, target);
		localStore.put(ABLocalStoreKeys.DAMAGECALC+triggerId, damage);
		localStore.put(ABLocalStoreKeys.THEATTACK + this.triggerId, attack);
		if (actions != null) {
			for (ABAction action : actions) {
				action.runAction(damage.getSource(), localStore, triggerId);
			}
		}
		localStore.remove(ABLocalStoreKeys.ATTACKINGUNIT+triggerId);
		localStore.remove(ABLocalStoreKeys.ATTACKTARGET+triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGECALC+triggerId);
		localStore.remove(ABLocalStoreKeys.THEATTACK + this.triggerId);
		if (!this.useCastId) {
			this.triggerId++;
		}
	}

	@Override
	public int getPriority(CSimulation simulation, CUnit attacker, AbilityTarget target, CUnitAttack attack) {
		if (priority == null) {
			return 0;
		}
		localStore.put(ABLocalStoreKeys.ATTACKINGUNIT + this.triggerId, attacker);
		localStore.put(ABLocalStoreKeys.ATTACKTARGET + this.triggerId, target);
		localStore.put(ABLocalStoreKeys.THEATTACK + this.triggerId, attack);
		int prio = this.priority.callback(attacker, this.localStore, this.triggerId);
		localStore.remove(ABLocalStoreKeys.ATTACKINGUNIT + this.triggerId);
		localStore.remove(ABLocalStoreKeys.ATTACKTARGET + this.triggerId);
		localStore.remove(ABLocalStoreKeys.THEATTACK + this.triggerId);
		return prio;
	}

}
