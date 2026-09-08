package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.parser.template;

public class ABAttackRangeTargetExclusion {
	private boolean excludeMelee;
	private boolean excludeRange;
	private boolean excludeNoAttack;

	public boolean isExcludeMelee() {
		return excludeMelee;
	}

	public void setExcludeMelee(boolean excludeMelee) {
		this.excludeMelee = excludeMelee;
	}

	public boolean isExcludeRange() {
		return excludeRange;
	}

	public void setExcludeRange(boolean excludeRange) {
		this.excludeRange = excludeRange;
	}

	public boolean isExcludeNoAttack() {
		return excludeNoAttack;
	}

	public void setExcludeNoAttack(boolean excludeNoAttack) {
		this.excludeNoAttack = excludeNoAttack;
	}
}
