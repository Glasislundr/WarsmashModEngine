package com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat;

public class CGenericDamageFlags extends CBaseDamageFlags {

	public CGenericDamageFlags(final boolean attack, final boolean ranged) {
		super();
		this.setAttack(attack);
		this.setRanged(ranged);
	}

}
