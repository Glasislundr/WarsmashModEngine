package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template;

import java.util.ArrayList;
import java.util.List;

import com.etheller.warsmash.units.GameObject;
import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.types.definitions.impl.AbilityFields;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.ABAbilityBuilderPassive;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action.ABTemplateActionAddBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action.ABTemplateActionRemoveBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action.ABTemplateActionUpdateBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.condition.ABTemplateAuraTargeting;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.buff.templatebuffs.ABTemplateAuraBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABConstants;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABUtilities;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.ABAbilityBuilderConfiguration;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABStatBuffFromDataField;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABStateModFromDataField;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.timer.ABAuraEffect;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CEffectType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.util.SimulationRenderComponentModel;

public class ABAbilityBuilderAuraTemplate extends ABAbilityBuilderPassive {

	private ABAuraEffect aura;
	private ABTemplateAuraBuff buff;
	private ABTemplateAuraTargeting condition;

	private List<ABStatBuffFromDataField> statBuffDataFields = null;
	private List<ABStateModFromDataField> stateModDataFields = null;
	private String auraStackingKey = null;
	private List<StateModBuff> stateMods = null;
	private List<NonStackingStatBuff> statBuffs = null;

	private boolean leveled;

	private ABTemplateActionAddBuff addBuff;
	private ABTemplateActionRemoveBuff removeBuff;
	private ABTemplateActionUpdateBuff updateBuff;
	private SimulationRenderComponentModel auraArt;

	public ABAbilityBuilderAuraTemplate(int handleId, War3ID code, War3ID alias,
			List<ABAbilityBuilderAbilityTypeLevelData> levelData, ABAbilityBuilderConfiguration config,
			ABLocalDataStore localStore) {
		super(handleId, code, alias, levelData, config, localStore);
		this.levelData = levelData;
		this.localStore = localStore;
		this.condition = new ABTemplateAuraTargeting(config.getAuraTargetCondition(), this.config.getAttackRangeTargetExclusion());

		ABAbilityBuilderAbilityTypeLevelData lData = this.levelData.get(getLevel() - 1);
		if (!lData.getBuffs().isEmpty()) {
			War3ID buffId = lData.getBuffs().get(0);
			this.auraStackingKey = buffId.asStringValue();
		} else {
			this.auraStackingKey = NonStackingStatBuff.ALLOW_STACKING_KEY;
		}
		if (config.getStatBuffsFromDataFields() != null && config.getStatBuffsFromDataFields().size() > 0) {
			this.statBuffDataFields = new ArrayList<>(config.getStatBuffsFromDataFields().size());
			this.statBuffs = new ArrayList<>(config.getStatBuffsFromDataFields().size());
			for (ABStatBuffFromDataField statBuff : config.getStatBuffsFromDataFields()) {
				this.statBuffDataFields.add(new ABStatBuffFromDataField(statBuff));
			}
		}

		if (config.getStateModsFromDataFields() != null && config.getStateModsFromDataFields().size() > 0) {
			this.stateModDataFields = new ArrayList<>(config.getStateModsFromDataFields().size());
			this.stateMods = new ArrayList<>(config.getStateModsFromDataFields().size());
			for (ABStateModFromDataField stateMod : config.getStateModsFromDataFields()) {
				this.stateModDataFields.add(new ABStateModFromDataField(stateMod));
			}
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

	protected void setSpellFields(CSimulation game, CUnit unit) {
		super.setSpellFields(game, unit);
		if (this.config.getStackingKey() != null) {
			this.auraStackingKey = this.config.getStackingKey().callback(unit, localStore, ABConstants.NO_CAST_ID);
		}
		if (this.config.getHideAbilityIcon() != null) {
			this.setIconShowing(!this.config.getHideAbilityIcon().callback(unit, localStore, ABConstants.NO_CAST_ID));
		}
	}

	@Override
	public void onAddDisabled(CSimulation game, CUnit unit) {
		super.onAddDisabled(game, unit);
		this.updateLevelBasedCalculatedFields(unit);

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
				levelData.get(getLevel() - 1).getArea(), this.condition, addBuffList, removeBuffList,
				true, updateLevelList, null, this.getLevel());
		localStore.put(ABLocalStoreKeys.AURAEFFECT, this.aura);

		this.addBuff = new ABTemplateActionAddBuff(buff);
		addBuffList.add(addBuff);
		this.removeBuff = new ABTemplateActionRemoveBuff(buff);
		removeBuffList.add(removeBuff);
		this.updateBuff = new ABTemplateActionUpdateBuff(this, buff, aura, levelData,
				config.getUpdateAuraLevelActions());
		updateLevelList.add(updateBuff);
	}

	@Override
	public void onAdd(CSimulation game, CUnit unit) {
		super.onAdd(game, unit);
		this.auraArt = game.createPersistentSpellEffectOnUnit(unit, getAlias(), CEffectType.TARGET);
		aura.start(game);
	}

	@Override
	public void onRemove(CSimulation game, CUnit unit) {
		super.onRemove(game, unit);
		if (this.auraArt != null) {
			this.auraArt.remove();
			this.auraArt = null;
		}
		aura.pause(game);
	}

	@Override
	public void onRemoveDisabled(CSimulation game, CUnit unit) {
		super.onRemoveDisabled(game, unit);
		if (this.auraArt != null) {
			this.auraArt.remove();
			this.auraArt = null;
		}
		aura.kill(game);
	}

	@Override
	public void onDeath(CSimulation game, CUnit unit) {
		super.onDeath(game, unit);
		if (this.auraArt != null) {
			this.auraArt.remove();
			this.auraArt = null;
		}
		aura.pause(game);
	}

	@Override
	public void onResurrect(CSimulation game, CUnit unit) {
		super.onResurrect(game, unit);
		this.auraArt = game.createPersistentSpellEffectOnUnit(unit, getAlias(), CEffectType.TARGET);
		aura.resume(game);
	}

	@Override
	public boolean isUniversal() {
		return true;
	}

	public ABTemplateAuraBuff createBuff(CSimulation game, War3ID buffId, CUnit unit) {
		ABTemplateAuraBuff buff1 = new ABTemplateAuraBuff(game.getHandleIdAllocator().createId(), buffId, localStore,
				this, unit, stateMods, statBuffs, config.getAddToAuraActions(), config.getRemoveFromAuraActions(),
				this.leveled,
				config.getPositiveAura() != null
						? config.getPositiveAura().callback(unit, localStore, ABConstants.AURA_CAST_ID)
						: true);
		buff1.setVisibilityGroup(auraStackingKey);
		if (this.config.getHideBuffIcon() != null) {
			buff1.setIconShowing(!this.config.getHideBuffIcon().callback(unit, localStore, ABConstants.AURA_CAST_ID));
		}
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

	public void updateLevelBasedCalculatedFields(CUnit caster) {
		ABAbilityBuilderAbilityTypeLevelData lData = this.levelData.get(getLevel() - 1);
		if (this.statBuffDataFields != null) {
			this.statBuffs.clear();
			for (ABStatBuffFromDataField statBuff : this.statBuffDataFields) {
				ABUtilities.updateStatBuffFromDataField(statBuff, lData, auraStackingKey);
				this.statBuffs.add(statBuff.getBuff());
			}
		}
		if (this.stateModDataFields != null) {
			this.stateMods.clear();
			for (ABStateModFromDataField statBuff : this.stateModDataFields) {
				boolean add = false;
				if (statBuff.getApplyPerLevelField() != null) {
					String dat = lData.getData().get(statBuff.getApplyPerLevelField().getIndex());
					add = dat != null && Integer.parseInt(dat) != 0;
				} else {
					add = true;
				}

				if (add) {
					statBuff.setBuff(new StateModBuff(statBuff.getType(),
							statBuff.getDataOverride() != null
									? statBuff.getDataOverride().callback(caster, localStore, ABConstants.AURA_CAST_ID)
									: 1));
					this.stateMods.add(statBuff.getBuff());
				}
			}
		}
		if (this.config.getAttackRangeTargetExclusion() != null) {
			this.config.getAttackRangeTargetExclusion().calculateExclusions(lData, caster, localStore,
					ABConstants.AURA_CAST_ID);
			this.condition.updateExclusions(this.config.getAttackRangeTargetExclusion());
		}
	}

	public void setBuffFields(CUnit caster) {
		this.buff.setLevel(localStore.game, caster, this.getLevel());
		if (this.config.getPositiveAura() != null)
			this.buff.setPositive(config.getPositiveAura().callback(caster, localStore, ABConstants.AURA_CAST_ID));

		ABAbilityBuilderAbilityTypeLevelData lData = this.levelData.get(getLevel() - 1);
		if (this.config.getStackingKey() != null) {
			this.auraStackingKey = this.config.getStackingKey().callback(caster, localStore, ABConstants.AURA_CAST_ID);
		} else if (!lData.getBuffs().isEmpty()) {
			War3ID buffId = lData.getBuffs().get(0);
			this.auraStackingKey = buffId.asStringValue();
		} else {
			this.auraStackingKey = NonStackingStatBuff.ALLOW_STACKING_KEY;;
		}
		this.buff.setVisibilityGroup(auraStackingKey);
	}

}
