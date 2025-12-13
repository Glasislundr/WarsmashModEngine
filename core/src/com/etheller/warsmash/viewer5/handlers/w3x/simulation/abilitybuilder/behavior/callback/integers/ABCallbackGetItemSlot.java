package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CItem;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.item.ABItemCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;

public class ABCallbackGetItemSlot extends ABIntegerCallback {

	private ABItemCallback item;
	
	@Override
	public Integer callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		Integer slot = (Integer) localStore.get(ABLocalStoreKeys.ITEMSLOT);
		if (slot != null) {
			return slot;
		}
		
		CItem theItem;
		if (item != null) {
			theItem = item.callback(caster, localStore, castId);
		} else {
			theItem = (CItem)localStore.get(ABLocalStoreKeys.ITEM);
		}
		
		if (theItem == null || theItem.getContainedInventory() == null) {
			return null;
		}
		return theItem.getContainedInventory().getSlot(theItem);
	}

}
