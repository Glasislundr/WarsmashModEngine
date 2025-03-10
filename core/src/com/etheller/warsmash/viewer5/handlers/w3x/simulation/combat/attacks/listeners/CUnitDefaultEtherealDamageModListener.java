package com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.attacks.listeners;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CAttackType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.combat.CDamageFlags;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.players.CAllianceType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CDamageType;

public class CUnitDefaultEtherealDamageModListener implements CUnitAttackDamageTakenModificationListener {
	public static CUnitDefaultEtherealDamageModListener INSTANCE = new CUnitDefaultEtherealDamageModListener();

	@Override
	public CUnitAttackDamageTakenModificationListenerDamageModResult onDamage(CSimulation game, CUnit attacker,
			CUnit target, final CDamageFlags flags, CAttackType attackType, CDamageType damageType,
			CUnitAttackDamageTakenModificationListenerDamageModResult previousDamage) {
		if (attacker == null || game.getGameplayConstants().isEtherealDamageBonusAlly() || !game
				.getPlayer(attacker.getPlayerIndex()).hasAlliance(target.getPlayerIndex(), CAllianceType.PASSIVE)) {
			previousDamage.addDamageMultiplier(game.getGameplayConstants().getEtherealDamageBonus()[attackType.ordinal()]);
		}
//		if (damageType == CDamageType.NORMAL && attackType != CAttackType.MAGIC) {
//			previousDamage.setBaseDamage(0);
//			previousDamage.setBonusDamage(0);
//			previousDamage.setDamageMultiplier(0);
//		}

		return previousDamage;
	}
}
