package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id;

import java.util.List;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integers.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser.template.ABDataFieldLetter;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABCallbackGetAbilityDataAsIDFromList extends ABIDCallback {

	private ABDataFieldLetter dataField;
	private ABIntegerCallback index;

	@SuppressWarnings("unchecked")
	@Override
	public War3ID callback(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final List<ABAbilityBuilderAbilityTypeLevelData> levelData = (List<ABAbilityBuilderAbilityTypeLevelData>) localStore
				.get(ABLocalStoreKeys.LEVELDATA);
		final int level = (int) localStore.get(ABLocalStoreKeys.CURRENTLEVEL);

		final String data = levelData.get(level - 1).getData().get(this.dataField.getIndex());
		if ((data == null) || "-".equals(data) || data.isBlank() || "_".equals(data)) {
			return War3ID.NONE;
		}
		String[] ids = data.split(",");
		int i = 0;
		if (index != null) {
			i = index.callback(caster, localStore, castId);
		}
		String tar = ids[Math.min(Math.max(i, 0), ids.length - 1)];
		if ((tar == null) || "-".equals(tar) || tar.isBlank() || "_".equals(tar)) {
			return War3ID.NONE;
		}
		return War3ID.fromString(tar);
	}

	@Override
	public String generateJassEquivalent(final JassTextGenerator jassTextGenerator) {
		return "GetAbilityDataAsIDAU(" + jassTextGenerator.getTriggerLocalStore() + ", DATA_FIELD_LETTER_"
				+ this.dataField.name() + ")";
	}

}
