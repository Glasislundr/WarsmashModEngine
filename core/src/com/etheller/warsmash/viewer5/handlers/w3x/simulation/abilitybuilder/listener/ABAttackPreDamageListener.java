package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityPointTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.targeting.AbilityTarget;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.LocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageCalculation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.CUnitAttack;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners.CUnitAttackPreDamageListener;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.replacement.CUnitAttackSettings;

public class ABAttackPreDamageListener implements CUnitAttackPreDamageListener {

	private LocalDataStore localStore;
	private List<ABAction> actions;

	private int triggerId = 0;
	private boolean useCastId;

	public ABAttackPreDamageListener(LocalDataStore localStore, List<ABAction> actions, int castId,
			boolean useCastId) {
		this.localStore = localStore;
		this.actions = actions;
		this.useCastId = useCastId;
		if (useCastId) {
			this.triggerId = castId;
		}
	}

	@Override
	public void onAttack(CSimulation simulation, AbilityTarget target, AbilityPointTarget attackImpactLocation,
			CUnitAttack attack, CUnitAttackSettings settings, CDamageCalculation calc) {
		localStore.put(ABLocalStoreKeys.ATTACKINGUNIT + triggerId, calc.getSource());
		localStore.put(ABLocalStoreKeys.ATTACKTARGET + triggerId, target);
		localStore.put(ABLocalStoreKeys.ATTACKIMPACTLOCATION + triggerId, attackImpactLocation);
		localStore.put(ABLocalStoreKeys.THEATTACK + triggerId, attack);
		localStore.put(ABLocalStoreKeys.ATTACKSETTINGS + triggerId, settings);
		localStore.put(ABLocalStoreKeys.DAMAGECALC + triggerId, calc);
		if (actions != null) {
			for (ABAction action : actions) {
				action.runAction(calc.getSource(), localStore, triggerId);
			}
		}
		localStore.remove(ABLocalStoreKeys.ATTACKINGUNIT + triggerId);
		localStore.remove(ABLocalStoreKeys.ATTACKTARGET + triggerId);
		localStore.remove(ABLocalStoreKeys.ATTACKIMPACTLOCATION + triggerId);
		localStore.remove(ABLocalStoreKeys.THEATTACK + triggerId);
		localStore.remove(ABLocalStoreKeys.ATTACKSETTINGS + triggerId);
		localStore.remove(ABLocalStoreKeys.DAMAGECALC + triggerId);
		if (!this.useCastId) {
			this.triggerId++;
		}
	}

}
