package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItem;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.ABAbilityBuilderAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.CPlayer;

public abstract class ABLocalDataStore implements ABDataStore {

	public CSimulation game = null;
	public CUnit originUnit = null;
	public ABAbilityBuilderAbility originAbility = null;
	public CItem originItem = null;
	public CPlayer originPlayer = null;
//	public CUpgradeEffect originUpgrade = null;

}
