package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.listener;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.CProjectile;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.projectile.listeners.CUnitAbilityProjReactionListener;

public class ABAbilityProjReactionListener implements CUnitAbilityProjReactionListener {

	private ABLocalDataStore localStore;
	private List<ABAction> actions;
	
	private int triggerId = 0;
	private boolean useCastId;
	
	public ABAbilityProjReactionListener(ABLocalDataStore localStore, List<ABAction> actions, int castId, boolean useCastId) {
		this.localStore = localStore;
		this.actions = actions;
		this.useCastId = useCastId;
		if (useCastId) {
			this.triggerId = castId;
		}
	}
	
	@Override
	public boolean onHit(final CSimulation simulation, CUnit source, CUnit target, CProjectile projectile) {
		if (!this.useCastId) {
			this.triggerId++;
		}
		localStore.put(ABLocalStoreKeys.REACTIONALLOWHIT+triggerId, true);
		if (actions != null) {
			localStore.put(ABLocalStoreKeys.REACTIONABILITYCASTER+triggerId, source);
			localStore.put(ABLocalStoreKeys.REACTIONABILITYTARGET+triggerId, target);
			localStore.put(ABLocalStoreKeys.ABILITYPROJ+triggerId, projectile);
			for (ABAction action : actions) {
				action.runAction(target, localStore, triggerId);
			}
			localStore.remove(ABLocalStoreKeys.REACTIONABILITYCASTER+triggerId);
			localStore.remove(ABLocalStoreKeys.REACTIONABILITYTARGET+triggerId);
			localStore.remove(ABLocalStoreKeys.ABILITYPROJ+triggerId);
		}
		return (boolean) localStore.remove(ABLocalStoreKeys.REACTIONALLOWHIT+triggerId);
	}

}
