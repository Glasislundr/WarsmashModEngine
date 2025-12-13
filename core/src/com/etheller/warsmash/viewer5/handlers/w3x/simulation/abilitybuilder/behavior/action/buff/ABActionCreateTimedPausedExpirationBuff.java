package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CUnit;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilities.CAbility;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floats.ABFloatCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.id.ABIDCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statbuff.ABNonStackingStatBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemod.ABStateModBuffCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.strings.ABStringCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ABBooleanCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.buff.ABTimedBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.buff.ABTimedPausedExpirationBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABAction;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABCallback;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core.ABLocalStoreKeys;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore.ABLocalDataStore;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.trigger.enumtypes.CEffectType;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.NonStackingStatBuff;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.unit.StateModBuff;

public class ABActionCreateTimedPausedExpirationBuff implements ABAction {

	private ABIDCallback buffId;
	private ABFloatCallback duration;
	private ABBooleanCallback showTimedLifeBar;
	private List<ABAction> onAddActions;
	private List<ABAction> onRemoveActions;
	private List<ABAction> onExpireActions;

	private List<ABNonStackingStatBuffCallback> statBuffs;
	private List<ABStateModBuffCallback> stateMods;

	private ABBooleanCallback showIcon;
	private CEffectType artType;
	private ABBooleanCallback hideArt;

	private ABBooleanCallback leveled;
	private ABBooleanCallback positive;
	private ABBooleanCallback dispellable;
	private ABBooleanCallback magic;
	private ABBooleanCallback physical;

	private ABBooleanCallback stacks;
	private ABStringCallback visibilityGroup;

	private List<ABStringCallback> uniqueFlags;
	private Map<String, ABCallback> uniqueValues;

	@Override
	public void runAction(final CUnit caster, final ABLocalDataStore localStore, final int castId) {
		boolean showTimedLife = false;
		if (this.showTimedLifeBar != null) {
			showTimedLife = this.showTimedLifeBar.callback(caster, localStore, castId);
		}
		boolean isLeveled = false;
		if (leveled != null) {
			isLeveled = leveled.callback(caster, localStore, castId);
		} else {
			isLeveled = (boolean) localStore.getOrDefault(ABLocalStoreKeys.ISABILITYLEVELED, false);
		}
		boolean isPositive = true;
		if (positive != null) {
			isPositive = positive.callback(caster, localStore, castId);
		}
		boolean isDispellable = true;
		if (dispellable != null) {
			isDispellable = dispellable.callback(caster, localStore, castId);
		} else {
			isDispellable = ((boolean) localStore.getOrDefault(ABLocalStoreKeys.ISABILITYMAGIC, true));
		}

		boolean isMagic = ((boolean) localStore.getOrDefault(ABLocalStoreKeys.ISABILITYMAGIC, true));
		boolean isPhysical = ((boolean) localStore.getOrDefault(ABLocalStoreKeys.ISABILITYPHYSICAL, false));
		if (magic != null) {
			isMagic = magic.callback(caster, localStore, castId);
		}
		if (physical != null) {
			isPhysical = physical.callback(caster, localStore, castId);
		}

		ABTimedBuff ability;
		if (showIcon != null) {
			ability = new ABTimedPausedExpirationBuff(localStore.game.getHandleIdAllocator().createId(),
					buffId.callback(caster, localStore, castId), localStore,
					(CAbility) localStore.get(ABLocalStoreKeys.ABILITY), caster,
					duration.callback(caster, localStore, castId), showTimedLife, onAddActions, onRemoveActions,
					onExpireActions, showIcon.callback(caster, localStore, castId), castId, isLeveled, isPositive,
					isDispellable);

		} else {
			ability = new ABTimedPausedExpirationBuff(localStore.game.getHandleIdAllocator().createId(),
					buffId.callback(caster, localStore, castId), localStore,
					(CAbility) localStore.get(ABLocalStoreKeys.ABILITY), caster,
					duration.callback(caster, localStore, castId), showTimedLife, onAddActions, onRemoveActions,
					onExpireActions, castId, isLeveled, isPositive, isDispellable);
		}

		if (stateMods != null) {
			List<StateModBuff> buffMods = new ArrayList<>();
			for (ABStateModBuffCallback mod : stateMods) {
				buffMods.add(mod.callback(caster, localStore, castId));
			}
			ability.setStateMods(buffMods);
		}
		if (statBuffs != null) {
			List<NonStackingStatBuff> buffStats = new ArrayList<>();
			for (ABNonStackingStatBuffCallback mod : statBuffs) {
				buffStats.add(mod.callback(caster, localStore, castId));
			}
			ability.setStatBuffs(buffStats);
		}

		if (artType != null) {
			ability.setArtType(artType);
		}
		if ((this.hideArt != null) && this.hideArt.callback(caster, localStore, castId)) {
			ability.setArtType(null);
		}
		ability.setMagic(isMagic);
		ability.setPhysical(isPhysical);
		boolean isStacks = false;
		if (stacks != null) {
			isStacks = stacks.callback(caster, localStore, castId);
		}
		ability.setStacks(isStacks);
		if (visibilityGroup != null) {
			ability.setVisibilityGroup(visibilityGroup.callback(caster, localStore, castId));
		}

		localStore.put(ABLocalStoreKeys.LASTCREATEDBUFF, ability);
		if (uniqueFlags != null) {
			for (ABStringCallback flag : uniqueFlags) {
				ability.addUniqueFlag(flag.callback(caster, localStore, castId));
			}
		}
		if (uniqueValues != null) {
			for (String key : uniqueValues.keySet()) {
				ability.addUniqueValue(uniqueValues.get(key).callback(caster, localStore, castId), key);
			}
		}
		if (!localStore.containsKey(ABLocalStoreKeys.BUFFCASTINGUNIT)) {
			localStore.put(ABLocalStoreKeys.BUFFCASTINGUNIT, caster);
		}
	}
}
