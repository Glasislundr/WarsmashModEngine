package com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.ability.template.action;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.generic.CBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.buff.templatebuffs.ABTemplateAuraBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.adjustablebehaviors.datastore.ABLocalDataStore;

public class ABTemplateActionAddBuff implements ABAction {
	
	private CBuff buff;

	public ABTemplateActionAddBuff(CBuff buff) { 
		this.buff = buff;
	}

	@Override
	public void runAction(CUnit caster, ABLocalDataStore localStore, int castId) {
		caster.add(localStore.game, buff);
	}

	public void setBuff(ABTemplateAuraBuff buff2) {
		this.buff = buff2;
	}

}
