package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.action.unit;

import com.etheller.warsmash.parsers.jass.JassTextGenerator;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.callback.unit.ABUnitCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABSingleAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;

public class ABActionResurrect implements ABSingleAction {

	private ABUnitCallback target;
	private ABFloatCallback life;
	private ABFloatCallback mana;
	private ABBooleanCallback costFood;

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, final int castId) {
		final CUnit targetUnit = this.target.callback(caster, localStore, castId);
		if (targetUnit.isDead()) {
			float revLife = 0;
			if (life != null) {
				revLife = life.callback(caster, localStore, castId);
			} else {
				revLife = targetUnit.getMaxLife();
			}
			Float revMana = null;
			if(mana != null) {
				revMana = mana.callback(caster, localStore, castId);
			}
			boolean revCostFood = true;
			if (costFood != null) {
				revCostFood = costFood.callback(caster, localStore, castId);
			}
			
			targetUnit.resurrect(localStore.game, revLife, revMana, revCostFood);
		}
	}

	@Override
	public String generateJassEquivalent(JassTextGenerator jassTextGenerator) {
		return "ResurrectUnit(" + this.target.generateJassEquivalent(jassTextGenerator) + ")";
	}

}
