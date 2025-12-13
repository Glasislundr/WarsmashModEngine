package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.types.impl;

import java.util.List;

import com.etheller.warsmash.units.GameObject;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CLevelingAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.types.CAbilityType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.template.ABAbilityBuilderAuraTemplate;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.template.ABAbilityBuilderSimpleAuraTemplate;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.template.ABAbilityBuilderStatAuraTemplate;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.ability.template.ABAbilityBuilderStatPassiveTemplate;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABMapLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser.ABAbilityBuilderParser;

public class ABAbilityBuilderTemplateType extends CAbilityType<ABAbilityBuilderAbilityTypeLevelData>  {

	private ABAbilityBuilderParser parser;
	private GameObject abilityEditorData;
	
	public ABAbilityBuilderTemplateType(War3ID alias, War3ID code, GameObject abilityEditorData, List<ABAbilityBuilderAbilityTypeLevelData> levelData, ABAbilityBuilderParser parser) {
		super(alias, code, levelData);
		this.parser = parser;
		this.abilityEditorData = abilityEditorData;
	}

	@Override
	public CAbility createAbility(int handleId) {
		ABLocalDataStore localStore = new ABMapLocalDataStore();
		localStore.put(ABLocalStoreKeys.ABILITYEDITORDATA, this.abilityEditorData);
		localStore.put(ABLocalStoreKeys.LEVELDATA, getLevelData());
		localStore.put(ABLocalStoreKeys.CURRENTLEVEL, 1);
		localStore.put(ABLocalStoreKeys.ALIAS, getAlias());
		
		switch (parser.getTemplateType()) {
		case PASSIVE_STATS:
			return new ABAbilityBuilderStatPassiveTemplate(handleId, getCode(), getAlias(), getLevelData(), localStore, parser.getStatBuffsFromDataFields());
		case AURA_STATS:
			return new ABAbilityBuilderStatAuraTemplate(handleId, getCode(), getAlias(), getLevelData(), localStore, parser.getStatBuffsFromDataFields(), parser.getMeleeRangeTargetOverride());
		case AURA_SIMPLE:
			return new ABAbilityBuilderSimpleAuraTemplate(handleId, getCode(), getAlias(), getLevelData(), localStore, parser.getAbilityIdsToAddPerLevel(), parser.getLevellingAbilityIdsToAdd());
		case AURA:
		default:
			return new ABAbilityBuilderAuraTemplate(handleId, getCode(), getAlias(), getLevelData(), localStore, parser.getAddToAuraActions(), parser.getUpdateAuraLevelActions(), parser.getRemoveFromAuraActions());
		}
	}

	@Override
	public void setLevel(CSimulation game, CUnit unit, CLevelingAbility existingAbility, int level) {
		existingAbility.setLevel(game, unit, level);
	}

}
