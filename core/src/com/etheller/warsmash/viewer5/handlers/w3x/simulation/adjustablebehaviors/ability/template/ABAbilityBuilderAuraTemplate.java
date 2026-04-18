package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template;

import java.util.ArrayList;
import java.util.List;

import com.etheller.warsmash.units.GameObject;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.AbilityGenericSingleIconPassiveAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.types.definitions.impl.AbilityFields;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action.ABTemplateActionAddBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action.ABTemplateActionRemoveBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action.ABTemplateActionUpdateBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.condition.ABTemplateAuraTargeting;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.buff.templatebuffs.ABTemplateAuraBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABUtilities;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABStatBuffFromDataField;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer.ABAuraEffect;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABAbilityBuilderAuraTemplate extends AbilityGenericSingleIconPassiveAbility {

	private List<ABAbilityBuilderAbilityTypeLevelData> levelData;
	private ABLocalDataStore localStore;

	private ABAuraEffect aura;
	private ABTemplateAuraBuff buff;

	private List<ABAction> onAddDisabledAbility;
	private ABBooleanCallback condition;
	private List<ABAction> addToAuraActions;
	private List<ABAction> updateAuraLevelActions;
	private List<ABAction> removeFromAuraActions;

	private List<ABStatBuffFromDataField> statBuffDataFields;
	private String auraStackingKey = "";
	private List<StateModBuff> stateMods = null;
	private List<NonStackingStatBuff> statBuffs = null;

	private ABBooleanCallback isBuffPositive;

	private boolean leveled;

	private ABTemplateActionAddBuff addBuff;
	private ABTemplateActionRemoveBuff removeBuff;
	private ABTemplateActionUpdateBuff updateBuff;

	public ABAbilityBuilderAuraTemplate(int handleId, War3ID code, War3ID alias,
			List<ABAbilityBuilderAbilityTypeLevelData> levelData, ABLocalDataStore localStore,
			List<ABAction> onAddDisabledAbility, ABBooleanCallback condition, List<ABAction> addToAuraActions,
			List<ABAction> updateAuraLevelActions, List<ABAction> removeFromAuraActions) {
		super(code, alias, handleId);
		this.levelData = levelData;
		this.localStore = localStore;
		this.onAddDisabledAbility = onAddDisabledAbility;
		this.condition = new ABTemplateAuraTargeting(condition);
		this.addToAuraActions = addToAuraActions;
		this.updateAuraLevelActions = updateAuraLevelActions;
		this.removeFromAuraActions = removeFromAuraActions;

		ABAbilityBuilderAbilityTypeLevelData lData = this.levelData.get(getLevel() - 1);
		this.statBuffDataFields = new ArrayList<>();
		for (ABStatBuffFromDataField statBuff : statBuffDataFields) {
			this.statBuffDataFields.add(new ABStatBuffFromDataField(statBuff));
		}
		if (!lData.getBuffs().isEmpty()) {
			War3ID buffId = lData.getBuffs().get(0);
			this.auraStackingKey = buffId.asStringValue();
		}
		for (ABStatBuffFromDataField statBuff : this.statBuffDataFields) {
			ABUtilities.updateStatBuffFromDataField(statBuff, lData, auraStackingKey);
		}

		GameObject editorData = localStore.get(ABLocalStoreKeys.ABILITYEDITORDATA, GameObject.class);
		final int levels = editorData.getFieldAsInteger(AbilityFields.LEVELS, 0);
		this.leveled = levels > 1;
		localStore.put(ABLocalStoreKeys.ISABILITYLEVELED, this.leveled);
		this.localStore.put(ABLocalStoreKeys.combineKey(ABLocalStoreKeys.CASTINSTANCELEVEL, ABConstants.AURA_CAST_ID),
				this.getLevel());
	}

	@Override
	public void setLevel(CSimulation game, CUnit unit, int level) {
		super.setLevel(game, unit, level);
		this.aura.setLevel(level);
	}

	@Override
	public void onAddDisabled(CSimulation game, CUnit unit) {
		localStore.game = game;
		localStore.originUnit = unit;
		localStore.originPlayer = game.getPlayer(unit.getPlayerIndex());
		List<War3ID> buffList = this.levelData.get(this.getLevel() - 1).getBuffs();
		War3ID buffId = null;
		if (buffList != null && !buffList.isEmpty()) {
			buffId = buffList.get(0);
		}

		ArrayList<ABAction> addBuffList = new ArrayList<>();
		ArrayList<ABAction> removeBuffList = new ArrayList<>();
		ArrayList<ABAction> updateLevelList = new ArrayList<>();

		this.buff = this.createBuff(game, buffId, unit);
		this.aura = new ABAuraEffect(localStore, ABConstants.AURA_CAST_ID, unit,
				levelData.get(getLevel() - 1).getCastRange(), condition, addBuffList, removeBuffList, true,
				updateLevelList, null, this.getLevel());

		this.addBuff = new ABTemplateActionAddBuff(buff);
		addBuffList.add(addBuff);
		this.removeBuff = new ABTemplateActionRemoveBuff(buff);
		removeBuffList.add(removeBuff);
		this.updateBuff = new ABTemplateActionUpdateBuff(this, buff, aura, levelData, updateAuraLevelActions);
		updateLevelList.add(updateBuff);

		if (this.onAddDisabledAbility != null) {
			for (ABAction action : this.onAddDisabledAbility) {
				action.runAction(unit, localStore, ABConstants.NO_CAST_ID);
			}
		}
	}

	@Override
	public void onAdd(CSimulation game, CUnit unit) {
		aura.start(game);
	}

	@Override
	public void onRemove(CSimulation game, CUnit unit) {
		aura.pause(game);
	}

	@Override
	public void onRemoveDisabled(CSimulation game, CUnit unit) {
		aura.kill(game);
	}

	@Override
	public void onDeath(CSimulation game, CUnit unit) {
		aura.pause(game);
	}

	@Override
	public boolean isUniversal() {
		return true;
	}

	public ABTemplateAuraBuff createBuff(CSimulation game, War3ID buffId, CUnit unit) {
		ABTemplateAuraBuff buff1 = new ABTemplateAuraBuff(game.getHandleIdAllocator().createId(), buffId, localStore,
				this, unit, stateMods, statBuffs, addToAuraActions, removeFromAuraActions, this.leveled,
				isBuffPositive.callback(unit, localStore, ABConstants.AURA_CAST_ID));
		if (this.leveled) {
			buff1.setLevel(game, unit, getLevel());
		}
		return buff1;
	}

	public void setBuff(ABTemplateAuraBuff buff) {
		this.buff = buff;
		this.addBuff.setBuff(buff);
		this.removeBuff.setBuff(buff);
		this.updateBuff.setBuff(buff);
	}

	public void setBuffFields(CUnit caster) {
		this.buff.setLevel(localStore.game, caster, this.getLevel());
		this.buff.setPositive(isBuffPositive.callback(caster, localStore, ABConstants.AURA_CAST_ID));

		ABAbilityBuilderAbilityTypeLevelData lData = this.levelData.get(getLevel() - 1);
		if (!lData.getBuffs().isEmpty()) {
			War3ID buffId = lData.getBuffs().get(0);
			this.auraStackingKey = buffId.asStringValue();
		} else {
			this.auraStackingKey = "";
		}
	}

}
