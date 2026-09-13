package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.longs.ABLongCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuffType;

public class ABStateModFromDataField {
	private StateModBuffType type;
	private ABDataFieldLetter applyPerLevelField;
	private ABLongCallback dataOverride;
	
	private transient StateModBuff buff;
	
	public ABStateModFromDataField(ABStateModFromDataField statBuff) {
		this.type = statBuff.getType();
	}
	public StateModBuffType getType() {
		return type;
	}
	public void setType(StateModBuffType type) {
		this.type = type;
	}
	public ABDataFieldLetter getApplyPerLevelField() {
		return applyPerLevelField;
	}
	public void setApplyPerLevelField(ABDataFieldLetter applyPerLevelField) {
		this.applyPerLevelField = applyPerLevelField;
	}
	public ABLongCallback getDataOverride() {
		return dataOverride;
	}
	public void setDataOverride(ABLongCallback dataOverride) {
		this.dataOverride = dataOverride;
	}
	public StateModBuff getBuff() {
		return buff;
	}
	public void setBuff(StateModBuff buff) {
		this.buff = buff;
	}
	
}
