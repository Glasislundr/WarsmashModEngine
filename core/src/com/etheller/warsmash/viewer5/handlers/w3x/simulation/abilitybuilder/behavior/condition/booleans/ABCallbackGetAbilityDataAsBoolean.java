package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.booleans;

import java.util.List;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser.template.ABDataFieldLetter;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetAbilityDataAsBoolean extends ABBooleanCallback {

	private ABDataFieldLetter dataField;

	@SuppressWarnings("unchecked")
	@Override
	public Boolean callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
				.get(ABLocalStoreKeys.LEVELDATA);
		final int level = (int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL);

		final String data = levelData.get(level - 1).getData().get(this.dataField.getIndex());
		if (data.equals("-")) {
			return false;
		}
		return Integer.parseInt(data) == 1;
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "GetAbilityDataAsFloatAU(" + jassTextGenerator.getTriggerLocalStore() + ", DATA_FIELD_LETTER_"
				+ this.dataField.name() + ")";
	}

}
