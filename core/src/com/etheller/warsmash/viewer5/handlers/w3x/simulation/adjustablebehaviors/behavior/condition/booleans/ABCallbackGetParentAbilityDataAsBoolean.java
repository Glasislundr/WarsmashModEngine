package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.booleans;

import java.util.List;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetParentAbilityDataAsBoolean extends ABBooleanCallback {

	private ABIntegerCallback dataField;

	@SuppressWarnings("unchecked")
	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
				.get(ABLocalStoreKeys.PARENTLEVELDATA);
		final int parentLevel = (int) ((ABLocalDataStore) localStore.get(ABLocalStoreKeys.PARENTLOCALSTORE))
				.get(ABLocalStoreKeys.CURRENTLEVEL);

		final String data = levelData.get(parentLevel - 1).getData()
				.get(this.dataField.callback(caster, localStore, castId));
		final int parsedData = Integer.parseInt(data);
		return parsedData == 1;
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "GetAbilityDataAsBooleanAU(" + jassTextGenerator.getTriggerLocalStore() + ", ConvertDataFieldLetter("
				+ this.dataField.generateJassEquivalent(jassTextGenerator) + "))";
	}

}
