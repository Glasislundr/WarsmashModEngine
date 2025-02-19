package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.parser;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks.ABAutocastTypeCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.ABIntegerCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCondition;

public class AbilityBuilderOverrideFields {
	
	private ABFloatCallback areaOverride;
	private ABFloatCallback rangeOverride;
	private ABFloatCallback castTimeOverride;
	private ABFloatCallback cooldownOverride;
	private ABIntegerCallback manaCostOverride;
	
	private ABAutocastTypeCallback autocastTypeOverride;
	
	private ABIDCallback onTooltipOverride;
	private ABIDCallback offTooltipOverride;
	
	private ABBooleanCallback physicalSpell;
	private ABBooleanCallback magicSpell;
	private ABBooleanCallback universalSpell;
	
	public ABFloatCallback getAreaOverride() {
		return areaOverride;
	}
	public void setAreaOverride(ABFloatCallback areaOverride) {
		this.areaOverride = areaOverride;
	}
	public ABFloatCallback getRangeOverride() {
		return rangeOverride;
	}
	public void setRangeOverride(ABFloatCallback rangeOverride) {
		this.rangeOverride = rangeOverride;
	}
	public ABFloatCallback getCastTimeOverride() {
		return castTimeOverride;
	}
	public void setCastTimeOverride(ABFloatCallback castTimeOverride) {
		this.castTimeOverride = castTimeOverride;
	}
	public ABFloatCallback getCooldownOverride() {
		return cooldownOverride;
	}
	public void setCooldownOverride(ABFloatCallback cooldownOverride) {
		this.cooldownOverride = cooldownOverride;
	}
	public ABIntegerCallback getManaCostOverride() {
		return manaCostOverride;
	}
	public void setManaCostOverride(ABIntegerCallback manaCostOverride) {
		this.manaCostOverride = manaCostOverride;
	}
	public ABAutocastTypeCallback getAutocastTypeOverride() {
		return autocastTypeOverride;
	}
	public void setAutocastTypeOverride(ABAutocastTypeCallback autocastTypeOverride) {
		this.autocastTypeOverride = autocastTypeOverride;
	}
	public ABIDCallback getOnTooltipOverride() {
		return onTooltipOverride;
	}
	public void setOnTooltipOverride(ABIDCallback onTooltipOverride) {
		this.onTooltipOverride = onTooltipOverride;
	}
	public ABIDCallback getOffTooltipOverride() {
		return offTooltipOverride;
	}
	public void setOffTooltipOverride(ABIDCallback offTooltipOverride) {
		this.offTooltipOverride = offTooltipOverride;
	}
	public ABBooleanCallback getPhysicalSpell() {
		return physicalSpell;
	}
	public void setPhysicalSpell(ABBooleanCallback physicalSpell) {
		this.physicalSpell = physicalSpell;
	}
	public ABBooleanCallback getMagicSpell() {
		return magicSpell;
	}
	public void setMagicSpell(ABBooleanCallback magicSpell) {
		this.magicSpell = magicSpell;
	}
	public ABBooleanCallback getUniversalSpell() {
		return universalSpell;
	}
	public void setUniversalSpell(ABBooleanCallback universalSpell) {
		this.universalSpell = universalSpell;
	}
	
	

}
