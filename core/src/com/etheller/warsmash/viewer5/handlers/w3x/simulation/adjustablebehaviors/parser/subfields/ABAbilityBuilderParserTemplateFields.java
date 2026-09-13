package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.subfields;

import java.util.List;
import java.util.Map;

import com.etheller.warsmash.util.War3ID;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.ABAbilityBuilderTemplateType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABAttackRangeTargetExclusion;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABStatBuffFromDataField;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABStateModFromDataField;

public class ABAbilityBuilderParserTemplateFields {
	//Template only
	private ABAbilityBuilderTemplateType templateType;
	//Aura template
	private ABBooleanCallback auraTargetCondition;
	private List<ABAction> addToAuraActions;
	private List<ABAction> updateAuraLevelActions;
	private List<ABAction> removeFromAuraActions;
	
	private ABBooleanCallback positiveAura;
	private ABStringCallback stackingKey;
	private ABBooleanCallback hideAbilityIcon;
	private ABBooleanCallback hideBuffIcon;
	//Simple Aura Template
	private Map<Integer,List<War3ID>> abilityIdsToAddPerLevel;
	private List<War3ID> levellingAbilityIdsToAdd;
	//StatList
	private List<ABStatBuffFromDataField> statBuffsFromDataFields;
	private List<ABStateModFromDataField> stateModsFromDataFields;
	private ABAttackRangeTargetExclusion attackRangeTargetExclusion;

	public void updateFromParent(ABAbilityBuilderParserTemplateFields parent) {
		if (this.templateType == null)
			this.templateType = parent.templateType;

		if (this.auraTargetCondition == null)
			this.auraTargetCondition = parent.auraTargetCondition;
		if (this.addToAuraActions == null)
			this.addToAuraActions = parent.addToAuraActions;
		if (this.updateAuraLevelActions == null)
			this.updateAuraLevelActions = parent.updateAuraLevelActions;
		if (this.removeFromAuraActions == null)
			this.removeFromAuraActions = parent.removeFromAuraActions;

		if (this.abilityIdsToAddPerLevel == null)
			this.abilityIdsToAddPerLevel = parent.abilityIdsToAddPerLevel;
		if (this.levellingAbilityIdsToAdd == null)
			this.levellingAbilityIdsToAdd = parent.levellingAbilityIdsToAdd;

		if (this.statBuffsFromDataFields == null)
			this.statBuffsFromDataFields = parent.statBuffsFromDataFields;
		if (this.stateModsFromDataFields == null)
			this.stateModsFromDataFields = parent.stateModsFromDataFields;
		if (this.attackRangeTargetExclusion == null)
			this.attackRangeTargetExclusion = parent.attackRangeTargetExclusion;
		if (this.positiveAura == null)
			this.positiveAura = parent.positiveAura;
	}

	public ABAbilityBuilderTemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(ABAbilityBuilderTemplateType templateType) {
		this.templateType = templateType;
	}

	public ABBooleanCallback getAuraTargetCondition() {
		return auraTargetCondition;
	}

	public void setAuraTargetCondition(ABBooleanCallback auraTargetCondition) {
		this.auraTargetCondition = auraTargetCondition;
	}

	public List<ABAction> getAddToAuraActions() {
		return addToAuraActions;
	}

	public void setAddToAuraActions(List<ABAction> addToAuraActions) {
		this.addToAuraActions = addToAuraActions;
	}

	public List<ABAction> getUpdateAuraLevelActions() {
		return updateAuraLevelActions;
	}

	public void setUpdateAuraLevelActions(List<ABAction> updateAuraLevelActions) {
		this.updateAuraLevelActions = updateAuraLevelActions;
	}

	public List<ABAction> getRemoveFromAuraActions() {
		return removeFromAuraActions;
	}

	public void setRemoveFromAuraActions(List<ABAction> removeFromAuraActions) {
		this.removeFromAuraActions = removeFromAuraActions;
	}

	public ABBooleanCallback getPositiveAura() {
		return positiveAura;
	}

	public void setPositiveAura(ABBooleanCallback positiveAura) {
		this.positiveAura = positiveAura;
	}

	public ABStringCallback getStackingKey() {
		return stackingKey;
	}

	public void setStackingKey(ABStringCallback stackingKey) {
		this.stackingKey = stackingKey;
	}

	public ABBooleanCallback getHideAbilityIcon() {
		return hideAbilityIcon;
	}

	public void setHideAbilityIcon(ABBooleanCallback hideAbilityIcon) {
		this.hideAbilityIcon = hideAbilityIcon;
	}

	public ABBooleanCallback getHideBuffIcon() {
		return hideBuffIcon;
	}

	public void setHideBuffIcon(ABBooleanCallback hideBuffIcon) {
		this.hideBuffIcon = hideBuffIcon;
	}

	public Map<Integer, List<War3ID>> getAbilityIdsToAddPerLevel() {
		return abilityIdsToAddPerLevel;
	}

	public void setAbilityIdsToAddPerLevel(Map<Integer, List<War3ID>> abilityIdsToAddPerLevel) {
		this.abilityIdsToAddPerLevel = abilityIdsToAddPerLevel;
	}

	public List<War3ID> getLevellingAbilityIdsToAdd() {
		return levellingAbilityIdsToAdd;
	}

	public void setLevellingAbilityIdsToAdd(List<War3ID> levellingAbilityIdsToAdd) {
		this.levellingAbilityIdsToAdd = levellingAbilityIdsToAdd;
	}

	public List<ABStatBuffFromDataField> getStatBuffsFromDataFields() {
		return statBuffsFromDataFields;
	}

	public void setStatBuffsFromDataFields(List<ABStatBuffFromDataField> statBuffsFromDataFields) {
		this.statBuffsFromDataFields = statBuffsFromDataFields;
	}

	public List<ABStateModFromDataField> getStateModsFromDataFields() {
		return stateModsFromDataFields;
	}

	public void setStateModsFromDataFields(List<ABStateModFromDataField> stateModsFromDataFields) {
		this.stateModsFromDataFields = stateModsFromDataFields;
	}

	public ABAttackRangeTargetExclusion getAttackRangeTargetExclusion() {
		return attackRangeTargetExclusion;
	}

	public void setAttackRangeTargetExclusion(ABAttackRangeTargetExclusion attackRangeTargetExclusion) {
		this.attackRangeTargetExclusion = attackRangeTargetExclusion;
	}

}
