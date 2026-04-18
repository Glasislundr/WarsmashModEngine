package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action;

import java.util.List;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.ABAbilityBuilderAuraTemplate;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.buff.templatebuffs.ABTemplateAuraBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer.ABAuraEffect;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABTemplateActionUpdateBuff implements ABAction {

	private ABAbilityBuilderAuraTemplate ability;
	private ABTemplateAuraBuff buff;
	private ABAuraEffect aura;
	private List<ABAbilityBuilderAbilityTypeLevelData> levelData;
	private List<ABAction> updateAuraLevelActions;

	public ABTemplateActionUpdateBuff(ABAbilityBuilderAuraTemplate abAbilityBuilderAuraTemplate, ABTemplateAuraBuff buff, ABAuraEffect aura,
			List<ABAbilityBuilderAbilityTypeLevelData> levelData, List<ABAction> updateAuraLevelActions) {
		super();
		this.ability = abAbilityBuilderAuraTemplate;
		this.buff = buff;
		this.aura = aura;
		this.levelData = levelData;
		this.updateAuraLevelActions = updateAuraLevelActions;
	}

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, int castId) {
		int level = localStore.originAbility.getLevel();
		localStore.put(ABLocalStoreKeys.combineKey(ABLocalStoreKeys.CASTINSTANCELEVEL, ABConstants.AURA_CAST_ID),
				level);

		List<War3ID> buffList = this.levelData.get(level - 1).getBuffs();
		War3ID buffId = null;
		if (buffList != null && !buffList.isEmpty()) {
			buffId = buffList.get(0);
		}
		if (buffId == buff.getAlias() || (buffId != null && buffId.equals(buff.getAlias()))) {
			ability.setBuffFields(caster);
		} else {
			ability.setBuff(ability.createBuff(localStore.game, buffId, localStore.originUnit));
		}
		
		aura.setRange(levelData.get(level - 1).getCastRange());
		aura.setLevel(level);
		if (updateAuraLevelActions != null) {
			for (ABAction action : updateAuraLevelActions) {
				action.runAction(caster, localStore, castId);
			}
		}
	}

	public void setBuff(ABTemplateAuraBuff buff2) {
		this.buff = buff2;
	}

}
