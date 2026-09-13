package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.types.impl.ABAbilityBuilderAbilityTypeLevelData;

public class ABAttackRangeTargetExclusion {
	private ABBooleanCallback excludeMelee = null;
	private ABBooleanCallback excludeRange = null;
	private ABBooleanCallback excludeNoAttack = null;

	private ABDataFieldLetter targetMeleeField = null;
	private ABDataFieldLetter targetRangeField = null;

	private boolean calculatedExcludeMelee = false;
	private boolean calculatedExcludeRange = false;
	private boolean calculatedExcludeNoAttack = false;

	public ABBooleanCallback getExcludeMelee() {
		return excludeMelee;
	}

	public void setExcludeMelee(ABBooleanCallback excludeMelee) {
		this.excludeMelee = excludeMelee;
	}

	public ABBooleanCallback getExcludeRange() {
		return excludeRange;
	}

	public void setExcludeRange(ABBooleanCallback excludeRange) {
		this.excludeRange = excludeRange;
	}

	public ABBooleanCallback getExcludeNoAttack() {
		return excludeNoAttack;
	}

	public void setExcludeNoAttack(ABBooleanCallback excludeNoAttack) {
		this.excludeNoAttack = excludeNoAttack;
	}

	public void calculateExclusions(ABAbilityBuilderAbilityTypeLevelData lData, CUnit caster,
			ABLocalDataStore localStore, int castId) {

		if (this.excludeMelee != null) {
			this.calculatedExcludeMelee = this.excludeMelee.callback(caster, localStore, castId);
		} else {
			if (this.targetMeleeField != null) {
				this.calculatedExcludeMelee = Integer.parseInt(lData.getData().get(this.targetMeleeField.getIndex())) == 0;
			} else {
				this.calculatedExcludeMelee = false;
			}
		}
		if (this.excludeRange != null) {
			this.calculatedExcludeRange = this.excludeRange.callback(caster, localStore, castId);
		} else {
			if (this.targetRangeField != null) {
				this.calculatedExcludeRange = Integer.parseInt(lData.getData().get(this.targetRangeField.getIndex())) == 0;
			} else {
				this.calculatedExcludeRange = false;
			}
		}
		if (this.excludeNoAttack != null) {
			this.calculatedExcludeNoAttack = this.excludeNoAttack.callback(caster, localStore, castId);
		} else {
			if (this.targetMeleeField != null || this.targetRangeField != null) {
				this.calculatedExcludeNoAttack = true;
			} else {
				this.calculatedExcludeNoAttack = false;
			}
		}
	}

	public boolean isExcludeMelee() {
		return calculatedExcludeMelee;
	}

	public boolean isExcludeRange() {
		return calculatedExcludeRange;
	}

	public boolean isExcludeNoAttack() {
		return calculatedExcludeNoAttack;
	}
}
