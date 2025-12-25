package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template.ABStatBuffFromDataField;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuffType;

public class ABUtilities {
	
	private ABUtilities() {}

	public static int incrementCastId(int castId) {
		if (castId + 1 == ABConstants.NO_CAST_ID) {
			return castId+2;
		}
		return castId+1;
	}

	public static int incrementTriggerId(int castId) {
		return incrementCastId(castId);
	}

	public static void updateStatBuffFromDataField(ABStatBuffFromDataField parsedBuff, ABAbilityBuilderAbilityTypeLevelData currentLevelData, String buffStackingKey) {
		if (buffStackingKey == null) {
			buffStackingKey = NonStackingStatBuff.ALLOW_STACKING_KEY;
		}
		NonStackingStatBuffType type = parsedBuff.convertToNonStackingType(currentLevelData);
		NonStackingStatBuff newBuff = null;
		switch (type) {
		case RNGDATK:
		case RNGDATKPCT:
			newBuff = new NonStackingStatBuff(type, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setBuff(newBuff);
			break;
		case MELEEATK:
		case MELEEATKPCT:
			newBuff = new NonStackingStatBuff(type, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setBuff(newBuff);
			break;
		case ALLATK:
			newBuff = new NonStackingStatBuff(NonStackingStatBuffType.MELEEATK, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setBuff(newBuff);
			newBuff = new NonStackingStatBuff(NonStackingStatBuffType.RNGDATK, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setSecondAtkBuff(newBuff);
			break;
		case ALLATKPCT:
			newBuff = new NonStackingStatBuff(NonStackingStatBuffType.MELEEATKPCT, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setBuff(newBuff);
			newBuff = new NonStackingStatBuff(NonStackingStatBuffType.RNGDATKPCT, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setSecondAtkBuff(newBuff);
			break;
		default:
			newBuff = new NonStackingStatBuff(type, buffStackingKey, Float
					.parseFloat(currentLevelData.getData().get(parsedBuff.getDataField().getIndex())));
			parsedBuff.setBuff(newBuff);
		}
	}
}
