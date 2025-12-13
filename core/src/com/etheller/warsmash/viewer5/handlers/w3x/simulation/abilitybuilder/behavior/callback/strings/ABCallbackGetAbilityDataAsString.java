package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings;

import java.util.List;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser.template.ABDataFieldLetter;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetAbilityDataAsString extends ABStringCallback {
	
	private ABDataFieldLetter dataField;

	@SuppressWarnings("unchecked")
	@Override
	public String callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		List<ABAbilityBuilderAbilityTypeLevelData>  levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore.get(ABLocalStoreKeys.LEVELDATA);
		int level = (int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL);
		
		return levelData.get(level-1).getData().get(dataField.getIndex());
	}

}
