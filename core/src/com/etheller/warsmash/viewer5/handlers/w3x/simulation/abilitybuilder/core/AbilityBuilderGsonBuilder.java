package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.core;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.abilities.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.ability.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.buff.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.destructable.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.events.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.floatingtext.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.gamestate.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.item.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.player.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.projectile.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.stats.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.structural.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.timer.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.animation.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.art.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unit.movement.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitgroup.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalActions.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalCallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitlisteners.internalConditions.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitqueue.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.unitstate.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.action.vision.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.ABCallbackNull;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.abilitycallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.booleancallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.buffcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructable.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.destructablebuff.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.enumcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.eventcallbacks.timeeventcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.floatcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.fxcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.idcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.integercallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.listenercallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.locationcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.longcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.orderid.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.player.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.projectile.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statbuffcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.statemodcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.stringcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.targetcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.timercallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitgroupcallbacks.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.unitqueue.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.visionmodifier.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.callback.widget.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.ability.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.buff.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.comparison.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.game.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.item.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.location.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.logical.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.numeric.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.projectile.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.timer.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unit.*;
import com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.behavior.condition.unittype.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbilityBuilderGsonBuilder {

	private static void registerAbilityCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetStoredAbilityByKey.class, "getStoredAbilityByKey")
				.registerSubtype(ABCallbackInlineConditionAbility.class, "inlineConditionAbility")
				.registerSubtype(ABCallbackGetPartnerAbility.class, "getPartnerAbility")
				.registerSubtype(ABCallbackGetReactionAbility.class, "getReactionAbility")
				.registerSubtype(ABCallbackGetLastCreatedAbility.class, "getLastCreatedAbility")
				.registerSubtype(ABCallbackGetThisAbility.class, "getThisAbility")

				.registerSubtype(ABCallbackArgumentAbility.class, "argumentAbility")
				.registerSubtype(ABCallbackReuseAbility.class, "reuseAbility")
				.registerSubtype(ABCallbackReuseAbilityWithArguments.class, "reuseAbilityWithArguments");
		
	}

	private static void registerAbilityEffectReactionListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedAbilityEffectReactionListener.class,
						"getLastCreatedAbilityEffectReactionListener")
				.registerSubtype(ABCallbackGetStoredAbilityEffectReactionListenerByKey.class,
						"getStoredAbilityEffectReactionListenerByKey");
	}
	
	private static void registerAbilityProjReactionListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedAbilityProjReactionListener.class,
						"getLastCreatedAbilityProjReactionListener")
				.registerSubtype(ABCallbackGetStoredAbilityProjReactionListenerByKey.class,
						"getStoredAbilityProjReactionListenerByKey");
	}

	private static void registerAttackProjReactionListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedAttackProjReactionListener.class,
						"getLastCreatedAttackProjReactionListener")
				.registerSubtype(ABCallbackGetStoredAttackProjReactionListenerByKey.class,
						"getStoredAttackProjReactionListenerByKey");
	}

	private static void registerAttackPostDamageListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedAttackPostDamageListener.class,
						"getLastCreatedAttackPostDamageListener")
				.registerSubtype(ABCallbackGetStoredAttackPostDamageListenerByKey.class,
						"getStoredAttackPostDamageListenerByKey");
	}

	private static void registerAttackPreDamageListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedAttackPreDamageListener.class,
						"getLastCreatedAttackPreDamageListener")
				.registerSubtype(ABCallbackGetStoredAttackPreDamageListenerByKey.class,
						"getStoredAttackPreDamageListenerByKey");
	}

	private static void registerBehaviorChangeListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedBehaviorChangeListener.class,
						"getLastCreatedBehaviorChangeListener")
				.registerSubtype(ABCallbackGetStoredBehaviorChangeListenerByKey.class,
						"getStoredBehaviorChangeListenerByKey");
	}

	private static void registerBooleanCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackRawBoolean.class, "rawBoolean")
				.registerSubtype(ABCallbackGetStoredBooleanByKey.class, "getStoredBooleanByKey")
				.registerSubtype(ABCallbackInlineConditionBoolean.class, "inlineConditionBoolean")
				.registerSubtype(ABCallbackGetAbilityDataAsBoolean.class, "getAbilityDataAsBoolean")
				.registerSubtype(ABCallbackGetParentAbilityDataAsBoolean.class, "getParentAbilityDataAsBoolean")
				
				.registerSubtype(ABCallbackIntegerToBoolean.class, "i2b")

				.registerSubtype(ABCallbackArgumentBoolean.class, "argumentBoolean")
				.registerSubtype(ABCallbackReuseBoolean.class, "reuseBoolean")
				.registerSubtype(ABCallbackReuseBooleanWithArguments.class, "reuseBooleanWithArguments")
				;
	}

	private static void registerBuffCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetStoredBuffByKey.class, "getStoredBuffByKey")
				.registerSubtype(ABCallbackInlineConditionBuff.class, "inlineConditionBuff")
				.registerSubtype(ABCallbackGetLastCreatedBuff.class, "getLastCreatedBuff")
				.registerSubtype(ABCallbackEnumBuff.class, "enumBuff")

				.registerSubtype(ABCallbackArgumentBuff.class, "argumentBuff")
				.registerSubtype(ABCallbackReuseBuff.class, "reuseBuff")
				.registerSubtype(ABCallbackReuseBuffWithArguments.class, "reuseBuffWithArguments");
	}

	private static void registerDamageTakenListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedDamageTakenListener.class, "getLastCreatedDamageTakenListener")
				.registerSubtype(ABCallbackGetStoredDamageTakenListenerByKey.class,
						"getStoredDamageTakenListenerByKey");
	}

	private static void registerDamageTakenModificationListenerCallbacks(
			RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedDamageTakenModificationListener.class,
						"getLastCreatedDamageTakenModificationListener")
				.registerSubtype(ABCallbackGetStoredDamageTakenModificationListenerByKey.class,
						"getStoredDamageTakenModificationListenerByKey");
	}

	private static void registerDeathReplacementEffectCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedDeathReplacement.class, "getLastCreatedDeathReplacement")
				.registerSubtype(ABCallbackGetStoredDeathReplacementByKey.class, "getStoredDeathReplacementByKey");
	}

	private static void registerDestructableCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetStoredDestructableByKey.class, "getStoredDestructableByKey")
				.registerSubtype(ABCallbackInlineConditionDestructable.class, "inlineConditionDestructable")
				.registerSubtype(ABCallbackGetEnumDestructable.class, "getEnumDestructable")
				.registerSubtype(ABCallbackGetProjectileHitDestructable.class, "getProjectileHitDestructable")

				.registerSubtype(ABCallbackArgumentDestructable.class, "argumentDestructable")
				.registerSubtype(ABCallbackReuseDestructable.class, "reuseDestructable")
				.registerSubtype(ABCallbackReuseDestructableWithArguments.class, "reuseDestructableWithArguments");
	}

	private static void registerDestructableBuffCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedDestructableBuff.class, "getLastCreatedDestructableBuff")
				.registerSubtype(ABCallbackGetStoredDestructableBuffByKey.class, "getStoredDestructableBuffByKey")
				.registerSubtype(ABCallbackInlineConditionDestructableBuff.class, "inlineConditionDestructableBuff")

				.registerSubtype(ABCallbackArgumentDestructableBuff.class, "argumentDestructableBuff")
				.registerSubtype(ABCallbackReuseDestructableBuff.class, "reuseDestructableBuff")
				.registerSubtype(ABCallbackReuseDestructableBuffWithArguments.class, "reuseDestructableBuffWithArguments");
	}

	private static void registerEvasionListenerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedEvasionListener.class, "getLastCreatedEvasionListener")
				.registerSubtype(ABCallbackGetStoredEvasionListenerByKey.class, "getStoredEvasionListenerByKey");
	}

	private static void registerFinalDamageTakenModificationListenerCallbacks(
			RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedFinalDamageTakenModificationListener.class,
						"getLastCreatedFinalDamageTakenModificationListener")
				.registerSubtype(ABCallbackGetStoredFinalDamageTakenModificationListenerByKey.class,
						"getStoredFinalDamageTakenModificationListenerByKey");
	}

	private static void registerFloatCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetAbilityArea.class, "getAbilityArea")
				.registerSubtype(ABCallbackGetAbilityDuration.class, "getAbilityDuration")
				.registerSubtype(ABCallbackGetAbilityCastTime.class, "getAbilityCastTime")
				.registerSubtype(ABCallbackGetAbilityCastRange.class, "getAbilityCastRange")
				.registerSubtype(ABCallbackGetAbilityHeroDuration.class, "getAbilityHeroDuration")
				.registerSubtype(ABCallbackGetAbilityCooldown.class, "getAbilityCooldown")
				
				.registerSubtype(ABCallbackRawFloat.class, "rawFloat")
				.registerSubtype(ABCallbackIntToFloat.class, "i2f")
				.registerSubtype(ABCallbackNegativeFloat.class, "negativeFloat")
				.registerSubtype(ABCallbackPi.class, "pi").registerSubtype(ABCallbackCos.class, "cos")
				.registerSubtype(ABCallbackSin.class, "sin")

				.registerSubtype(ABCallbackFMaxValue.class, "fMaxValue")
				
				.registerSubtype(ABCallbackGetStoredFloatByKey.class, "getStoredFloatByKey")
				.registerSubtype(ABCallbackInlineConditionFloat.class, "inlineConditionFloat")
				.registerSubtype(ABCallbackGetAbilityDataAsFloat.class, "getAbilityDataAsFloat")
				.registerSubtype(ABCallbackGetParentAbilityDataAsFloat.class, "getParentAbilityDataAsFloat")
				.registerSubtype(ABCallbackRandomFloat.class, "randomFloat")
				.registerSubtype(ABCallbackRandomBoundedFloat.class, "randomBoundedFloat")
				.registerSubtype(ABCallbackGetUnitLocationX.class, "getUnitLocationX")
				.registerSubtype(ABCallbackGetUnitLocationY.class, "getUnitLocationY")
				.registerSubtype(ABCallbackGetLocationX.class, "getLocationX")
				.registerSubtype(ABCallbackGetLocationY.class, "getLocationY")
				.registerSubtype(ABCallbackGetUnitFacing.class, "getUnitFacing")
				.registerSubtype(ABCallbackGetUnitAcquisitionRange.class, "getUnitAcquisitionRange")
				.registerSubtype(ABCallbackGetUnitCastPoint.class, "getUnitCastPoint")
				.registerSubtype(ABCallbackGetUnitCurrentMana.class, "getUnitCurrentMana")
				.registerSubtype(ABCallbackGetUnitInitialMana.class, "getUnitInitialMana")
				.registerSubtype(ABCallbackGetUnitCurrentHp.class, "getUnitCurrentHp")

				.registerSubtype(ABCallbackGetAngleBetweenLocations.class, "getAngleBetweenLocations")
				.registerSubtype(ABCallbackGetDistanceBetweenLocations.class, "getDistanceBetweenLocations")
				.registerSubtype(ABCallbackTicksForDuration.class, "ticksForDuration")

				.registerSubtype(ABCallbackGetTotalDamageDealt.class, "getTotalDamageDealt")
				.registerSubtype(ABCallbackGetReactionAttackProjectileDamage.class, "getReactionAttackProjectileDamage")

				.registerSubtype(ABCallbackArgumentFloat.class, "argumentFloat")
				.registerSubtype(ABCallbackReuseFloat.class, "reuseFloat")
				.registerSubtype(ABCallbackReuseFloatWithArguments.class, "reuseFloatWithArguments")
				
				;
	}

	private static void registerGenericFloatCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackAddFloat.class, "f+")
				.registerSubtype(ABCallbackSubtractFloat.class, "f-")
				.registerSubtype(ABCallbackMultiplyFloat.class, "f*")
				.registerSubtype(ABCallbackDivideFloat.class, "f/")
				.registerSubtype(ABCallbackMinFloat.class, "fMin")
				.registerSubtype(ABCallbackMaxFloat.class, "fMax")
				.registerSubtype(ABCallbackCeilFloat.class, "ceil")
				.registerSubtype(ABCallbackFloorFloat.class, "floor");
	}

	private static void registerSpecialFloatCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackAddFloat.class, "f+")
				.registerSubtype(ABCallbackSubtractFloat.class, "f-").registerSubtype(ABCallbackMultiplyFloat.class, "f*")
				.registerSubtype(ABCallbackDivideFloat.class, "f/")
				.registerSubtype(ABCallbackMinFloat.class, "fMin").registerSubtype(ABCallbackMaxFloat.class, "fMax")
				.registerSubtype(ABCallbackCeilFloat.class, "ceil")
				.registerSubtype(ABCallbackFloorFloat.class, "floor");
	}

	private static void registerFxCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetLastCreatedSpellEffect.class, "getLastCreatedSpellEffect")
				.registerSubtype(ABCallbackGetStoredFXByKey.class, "getStoredFXByKey")
				.registerSubtype(ABCallbackInlineConditionFX.class, "inlineConditionFX")

				.registerSubtype(ABCallbackArgumentFX.class, "argumentFX")
				.registerSubtype(ABCallbackReuseFX.class, "reuseFX")
				.registerSubtype(ABCallbackReuseFXWithArguments.class, "reuseFXWithArguments");
	}

	private static void registerIdCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetStoredIDByKey.class, "getStoredIDByKey")
				.registerSubtype(ABCallbackInlineConditionID.class, "inlineConditionID")
				.registerSubtype(ABCallbackGetAbilityDataAsID.class, "getAbilityDataAsID")
				.registerSubtype(ABCallbackGetAbilityUnitId.class, "getAbilityUnitId")
				.registerSubtype(ABCallbackGetWar3IDFromString.class, "getWar3IDFromString")
				.registerSubtype(ABCallbackGetAlias.class, "getAlias")
				.registerSubtype(ABCallbackGetParentAlias.class, "getParentAlias")
				.registerSubtype(ABCallbackGetFirstBuffId.class, "getFirstBuffId")
				.registerSubtype(ABCallbackGetSecondBuffId.class, "getSecondBuffId")
				.registerSubtype(ABCallbackGetFirstEffectId.class, "getFirstEffectId")

				.registerSubtype(ABCallbackGetUnitType.class, "getUnitType")
				.registerSubtype(ABCallbackGetNonCurrentTransformType.class, "getNonCurrentTransformType")
				
				.registerSubtype(ABCallbackNullIfFalse.class, "nullIfFalse")

				.registerSubtype(ABCallbackArgumentID.class, "argumentID")
				.registerSubtype(ABCallbackReuseID.class, "reuseID")
				.registerSubtype(ABCallbackReuseIDWithArguments.class, "reuseIDWithArguments");
	}

	private static void registerIntegerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackRawInteger.class, "rawInteger")
				.registerSubtype(ABCallbackGetStoredIntegerByKey.class, "getStoredIntegerByKey")
				.registerSubtype(ABCallbackInlineConditionInteger.class, "inlineConditionInteger")
				.registerSubtype(ABCallbackIterator.class, "iterator")
				
				.registerSubtype(ABCallbackGetAbilityDataAsInteger.class, "getAbilityDataAsInteger")
				.registerSubtype(ABCallbackGetAbilityManaCost.class, "getAbilityManaCost")
				.registerSubtype(ABCallbackGetAbilityCastTimeAsInteger.class, "getAbilityCastTimeAsInteger")
				.registerSubtype(ABCallbackGetAbilityTargetAttachmentPoints.class, "getAbilityTargetAttachmentPoints")
				
				.registerSubtype(ABCallbackCountUnitsInRangeOfUnit.class, "countUnitsInRangeOfUnit")
				.registerSubtype(ABCallbackCountUnitsInRangeOfLocation.class, "countUnitsInRangeOfLocation")
				.registerSubtype(ABCallbackGetSpellLevel.class, "getSpellLevel")
				.registerSubtype(ABCallbackGetProjectileUnitTargets.class, "getProjectileUnitTargets")
				.registerSubtype(ABCallbackGetProjectileDestructableTargets.class, "getProjectileDestructableTargets")

				.registerSubtype(ABCallbackGetUnitTypeGoldCost.class, "getUnitTypeGoldCost")
				.registerSubtype(ABCallbackGetUnitTypeLumberCost.class, "getUnitTypeLumberCost")
				.registerSubtype(ABCallbackGetUnitTypeFoodCost.class, "getUnitTypeFoodCost")
				
				.registerSubtype(ABCallbackAddInteger.class, "i+")
				.registerSubtype(ABCallbackSubtractInteger.class, "i-")
				.registerSubtype(ABCallbackMultiplyInteger.class, "i*")
				.registerSubtype(ABCallbackDivideInteger.class, "i/")
				.registerSubtype(ABCallbackAndInteger.class, "i&")
				.registerSubtype(ABCallbackOrInteger.class, "i|")
				.registerSubtype(ABCallbackMinInteger.class, "iMin")
				.registerSubtype(ABCallbackMaxInteger.class, "iMax")

				.registerSubtype(ABCallbackIntegerIf.class, "iIf")
				.registerSubtype(ABCallbackIntegerZeroIfFalse.class, "i0IfFalse")

				.registerSubtype(ABCallbackGetUnitGroupSize.class, "getUnitGroupSize")
				.registerSubtype(ABCallbackGetUnitQueueSize.class, "getUnitQueueSize")

				.registerSubtype(ABCallbackGetPlayerId.class, "getPlayerId")

				.registerSubtype(ABCallbackPlayerToStateModValue.class, "playerToStateModValue")
				.registerSubtype(ABCallbackDetectionDropdownConversion.class, "detectionDropdownConversion")

				.registerSubtype(ABCallbackArgumentInteger.class, "argumentInteger")
				.registerSubtype(ABCallbackReuseInteger.class, "reuseInteger")
				.registerSubtype(ABCallbackReuseIntegerWithArguments.class, "reuseIntegerWithArguments");
	}

	private static void registerLightningCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetLastCreatedLightningEffect.class, "getLastCreatedLightningEffect")
				.registerSubtype(ABCallbackGetStoredLightningByKey.class, "getStoredLightningByKey");
	}

	private static void registerLocationCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackCreateLocationFromXY.class, "createLocationFromXY")
				.registerSubtype(ABCallbackCreateLocationFromOffset.class, "createLocationFromOffset")
				.registerSubtype(ABCallbackGetStoredLocationByKey.class, "getStoredLocationByKey")
				.registerSubtype(ABCallbackInlineConditionLocation.class, "inlineConditionLocation")
				.registerSubtype(ABCallbackGetTargetedLocation.class, "getTargetedLocation")
				.registerSubtype(ABCallbackCreateLocationFromTarget.class, "createLocationFromTarget")
				.registerSubtype(ABCallbackGetProjectileCurrentLocation.class, "getProjectileCurrentLocation")
				.registerSubtype(ABCallbackGetUnitLocation.class, "getUnitLocation")

				.registerSubtype(ABCallbackArgumentLocation.class, "argumentLocation")
				.registerSubtype(ABCallbackReuseLocation.class, "reuseLocation")
				.registerSubtype(ABCallbackReuseLocationWithArguments.class, "reuseLocationWithArguments");
	}

	private static void registerLongCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackRawLong.class, "rawLong")
				.registerSubtype(ABCallbackGetStoredLongByKey.class, "getStoredLongByKey")
				.registerSubtype(ABCallbackInlineConditionLong.class, "inlineConditionLong")
				
				.registerSubtype(ABCallbackAddLong.class, "l+")
				.registerSubtype(ABCallbackSubtractLong.class, "l-")
				.registerSubtype(ABCallbackMultiplyLong.class, "l*")
				.registerSubtype(ABCallbackDivideLong.class, "l/")
				.registerSubtype(ABCallbackAndLong.class, "l&")
				.registerSubtype(ABCallbackOrLong.class, "l|")
				.registerSubtype(ABCallbackMinLong.class, "lMin")
				.registerSubtype(ABCallbackMaxLong.class, "lMax")

				.registerSubtype(ABCallbackCreateDetectorData.class, "createDetectorData")
				.registerSubtype(ABCallbackCreateDetectedData.class, "createDetectedData")

				.registerSubtype(ABCallbackArgumentLong.class, "argumentLong")
				.registerSubtype(ABCallbackReuseLong.class, "reuseLong")
				.registerSubtype(ABCallbackReuseLongWithArguments.class, "reuseLongWithArguments");
	}

	private static void registerOrderIdCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackRawID.class, "rawId")
				.registerSubtype(ABCallbackIdString.class, "idString")
				.registerSubtype(ABCallbackGetStoredOrderIdByKey.class, "getStoredOrderIdByKey")
				.registerSubtype(ABCallbackInlineConditionOrderId.class, "inlineConditionOrderId")

				.registerSubtype(ABCallbackArgumentOrderId.class, "argumentOrderId")
				.registerSubtype(ABCallbackReuseOrderId.class, "reuseOrderId")
				.registerSubtype(ABCallbackReuseOrderIdWithArguments.class, "reuseOrderIdWithArguments");
	}

	private static void registerPlayerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetPlayerById.class, "getPlayerById")
				.registerSubtype(ABCallbackGetStoredPlayerByKey.class, "getStoredPlayerByKey")
				.registerSubtype(ABCallbackInlineConditionPlayer.class, "inlineConditionPlayer")
				.registerSubtype(ABCallbackGetOwnerOfUnit.class, "getOwnerOfUnit")

				.registerSubtype(ABCallbackArgumentPlayer.class, "argumentPlayer")
				.registerSubtype(ABCallbackReusePlayer.class, "reusePlayer")
				.registerSubtype(ABCallbackReusePlayerWithArguments.class, "reusePlayerWithArguments");
	}

	private static void registerProjectileCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetLastCreatedProjectile.class, "getLastCreatedProjectile")
				.registerSubtype(ABCallbackGetStoredProjectileByKey.class, "getStoredProjectileByKey")
				.registerSubtype(ABCallbackInlineConditionProjectile.class, "inlineConditionProjectile")
				.registerSubtype(ABCallbackGetThisProjectile.class, "getThisProjectile")
				
				
				.registerSubtype(ABCallbackGetReactionAttackProjectile.class, "getReactionAttackProjectile")
				.registerSubtype(ABCallbackGetReactionAbilityProjectile.class, "getReactionAbilityProjectile")

				.registerSubtype(ABCallbackArgumentProjectile.class, "argumentProjectile")
				.registerSubtype(ABCallbackReuseProjectile.class, "reuseProjectile")
				.registerSubtype(ABCallbackReuseProjectileWithArguments.class, "reuseProjectileWithArguments")
				;
	}

	private static void registerStatBuffCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedNonStackingStatBuff.class, "getLastCreatedNonStackingStatBuff")
				.registerSubtype(ABCallbackGetStoredNonStackingStatBuffByKey.class,
						"getStoredNonStackingStatBuffByKey")
				.registerSubtype(ABCallbackInlineConditionNonStackingStatBuff.class, "inlineConditionNonStackingStatBuff")

				.registerSubtype(ABCallbackArgumentNonStackingStatBuff.class, "argumentNonStackingStatBuff")
				.registerSubtype(ABCallbackReuseNonStackingStatBuff.class, "reuseNonStackingStatBuff")
				.registerSubtype(ABCallbackReuseNonStackingStatBuffWithArguments.class, "reuseNonStackingStatBuffWithArguments");
	}

	private static void registerStateModBuffCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetLastCreatedStateModBuff.class, "getLastCreatedStateModBuff")
				.registerSubtype(ABCallbackGetStoredStateModBuffByKey.class,
						"getStoredStateModBuffByKey")
				.registerSubtype(ABCallbackInlineConditionStateModBuff.class, "inlineConditionStateModBuff")

				.registerSubtype(ABCallbackArgumentStateModBuff.class, "argumentStateModBuff")
				.registerSubtype(ABCallbackReuseStateModBuff.class, "reuseStateModBuff")
				.registerSubtype(ABCallbackReuseStateModBuffWithArguments.class, "reuseStateModBuffWithArguments");
	}

	private static void registerStringCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackRawString.class, "rawString")
				.registerSubtype(ABCallbackGetStoredStringByKey.class, "getStoredStringByKey")
				.registerSubtype(ABCallbackInlineConditionString.class, "inlineConditionString")
				.registerSubtype(ABCallbackGetAbilityDataAsString.class, "getAbilityDataAsString")
				.registerSubtype(ABCallbackCatStrings.class, "catStrings")
				.registerSubtype(ABCallbackGetAliasAsString.class, "getAliasAsString")
				.registerSubtype(ABCallbackGetCodeAsString.class, "getCodeAsString")
				.registerSubtype(ABCallbackGetUnitHandleAsString.class, "getUnitHandleAsString")
				.registerSubtype(ABCallbackGetAllowStackingKey.class, "getAllowStackingKey")
				
				

				.registerSubtype(ABCallbackBooleanToString.class, "b2s")
				.registerSubtype(ABCallbackFloatToString.class, "f2s")
				.registerSubtype(ABCallbackIntegerToString.class, "i2s")
				.registerSubtype(ABCallbackLongToString.class, "l2s")

				.registerSubtype(ABCallbackArgumentString.class, "argumentString")
				.registerSubtype(ABCallbackReuseString.class, "reuseString")
				.registerSubtype(ABCallbackReuseStringWithArguments.class, "reuseStringWithArguments")
				;
	}

	private static void registerTargetCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetAbilityTarget.class, "getAbilityTarget")
				.registerSubtype(ABCallbackGetNewBehaviorTarget.class, "getNewBehaviorTarget")
				.registerSubtype(ABCallbackGetStoredTargetByKey.class, "getStoredTargetByKey")
				.registerSubtype(ABCallbackInlineConditionTarget.class, "inlineConditionTarget")

				.registerSubtype(ABCallbackArgumentTarget.class, "argumentTarget")
				.registerSubtype(ABCallbackReuseTarget.class, "reuseTarget")
				.registerSubtype(ABCallbackReuseTargetWithArguments.class, "reuseTargetWithArguments");
	}

	private static void registerTimeOfDayEventCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetLastCreatedTimeOfDayEvent.class, "getLastCreatedTimeOfDayEvent")
				.registerSubtype(ABCallbackGetStoredTimeOfDayEventByKey.class, "getStoredTimeOfDayEventByKey")
				.registerSubtype(ABCallbackInlineConditionTimeOfDayEvent.class, "inlineConditionTimeOfDayEvent")

				.registerSubtype(ABCallbackArgumentTimeOfDayEvent.class, "argumentTimeOfDayEvent")
				.registerSubtype(ABCallbackReuseTimeOfDayEvent.class, "reuseTimeOfDayEvent")
				.registerSubtype(ABCallbackReuseTimeOfDayEventWithArguments.class, "reuseTimeOfDayEventWithArguments");
	}

	private static void registerTimerCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory.registerSubtype(ABCallbackGetLastCreatedTimer.class, "getLastCreatedTimer")
				.registerSubtype(ABCallbackGetLastStartedTimer.class, "getLastStartedTimer")
				.registerSubtype(ABCallbackGetFiringTimer.class, "getFiringTimer")
				.registerSubtype(ABCallbackGetStoredTimerByKey.class, "getStoredTimerByKey")
				.registerSubtype(ABCallbackInlineConditionTimer.class, "inlineConditionTimer")

				.registerSubtype(ABCallbackArgumentTimer.class, "argumentTimer")
				.registerSubtype(ABCallbackReuseTimer.class, "reuseTimer")
				.registerSubtype(ABCallbackReuseTimerWithArguments.class, "reuseTimerWithArguments");
	}

	private static void registerUnitCallbacks(RuntimeTypeAdapterFactory unitCallbackTypeFactory) {
		unitCallbackTypeFactory.registerSubtype(ABCallbackGetCastingUnit.class, "getCastingUnit")
				.registerSubtype(ABCallbackGetBuffCastingUnit.class, "getBuffCastingUnit")
				.registerSubtype(ABCallbackGetBuffedUnit.class, "getBuffedUnit")
				.registerSubtype(ABCallbackGetListenerUnit.class, "getListenerUnit")
				.registerSubtype(ABCallbackGetEnumUnit.class, "getEnumUnit")
				.registerSubtype(ABCallbackGetMatchingUnit.class, "getMatchingUnit")
				.registerSubtype(ABCallbackGetAttackedUnit.class, "getAttackedUnit")
				.registerSubtype(ABCallbackGetAttackingUnit.class, "getAttackingUnit")
				.registerSubtype(ABCallbackGetDyingUnit.class, "getDyingUnit")
				.registerSubtype(ABCallbackGetKillingUnit.class, "getKillingUnit")
				.registerSubtype(ABCallbackGetAbilityTargetedUnit.class, "getAbilityTargetedUnit")
				.registerSubtype(ABCallbackGetAbilityPairedUnit.class, "getAbilityPairedUnit")
				.registerSubtype(ABCallbackGetStoredUnitByKey.class, "getStoredUnitByKey")
				.registerSubtype(ABCallbackInlineConditionUnit.class, "inlineConditionUnit")
				.registerSubtype(ABCallbackGetParentCastingUnit.class, "getParentCastingUnit")
				.registerSubtype(ABCallbackGetProjectileHitUnit.class, "getProjectileHitUnit")
				.registerSubtype(ABCallbackGetLastCreatedUnit.class, "getLastCreatedUnit")

				.registerSubtype(ABCallbackGetReactionAbilityCastingUnit.class, "getReactionAbilityCastingUnit")
				.registerSubtype(ABCallbackGetReactionAbilityTargetUnit.class, "getReactionAbilityTargetUnit")

				.registerSubtype(ABCallbackPollUnitQueue.class, "pollUnitQueue")

				.registerSubtype(ABCallbackGetNearestUnitInRangeOfUnit.class, "getNearestUnitInRangeOfUnit")
				.registerSubtype(ABCallbackGetNearestCorpseInRangeOfUnit.class, "getNearestCorpseInRangeOfUnit")

				.registerSubtype(ABCallbackArgumentUnit.class, "argumentUnit")
				.registerSubtype(ABCallbackReuseUnit.class, "reuseUnit")
				.registerSubtype(ABCallbackReuseUnitWithArguments.class, "reuseUnitWithArguments");
	}

	private static void registerUnitGroupCallbacks(RuntimeTypeAdapterFactory unitGroupCallbackTypeFactory) {
		unitGroupCallbackTypeFactory.registerSubtype(ABCallbackGetUnitGroupByName.class, "getUnitGroupByName")
				.registerSubtype(ABCallbackGetLastCreatedUnitGroup.class, "getLastCreatedUnitGroup")
				.registerSubtype(ABCallbackGetStoredUnitGroupByKey.class, "getStoredUnitGroupByKey")
				.registerSubtype(ABCallbackInlineConditionUnitGroup.class, "inlineConditionUnitGroup")

				.registerSubtype(ABCallbackArgumentUnitGroup.class, "argumentUnitGroup")
				.registerSubtype(ABCallbackReuseUnitGroup.class, "reuseUnitGroup")
				.registerSubtype(ABCallbackReuseUnitGroupWithArguments.class, "reuseUnitGroupWithArguments");
	}

	private static void registerUnitQueueCallbacks(RuntimeTypeAdapterFactory unitGroupCallbackTypeFactory) {
		unitGroupCallbackTypeFactory.registerSubtype(ABCallbackGetUnitQueueByName.class, "getUnitQueueByName")
				.registerSubtype(ABCallbackGetLastCreatedUnitQueue.class, "getLastCreatedUnitQueue")
				.registerSubtype(ABCallbackGetStoredUnitQueueByKey.class, "getStoredUnitQueueByKey")
				.registerSubtype(ABCallbackInlineConditionUnitQueue.class, "inlineConditionUnitQueue")

				.registerSubtype(ABCallbackArgumentUnitQueue.class, "argumentUnitQueue")
				.registerSubtype(ABCallbackReuseUnitQueue.class, "reuseUnitQueue")
				.registerSubtype(ABCallbackReuseUnitQueueWithArguments.class, "reuseUnitQueueWithArguments");
	}

	private static void registerVisionModifierCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetStoredVisionModifierByKey.class, "getStoredVisionModifierByKey")
				.registerSubtype(ABCallbackInlineConditionVisionModifier.class, "inlineConditionVisionModifier")
				.registerSubtype(ABCallbackGetLastCreatedVisionModifier.class, "getLastCreatedVisionModifier")

				.registerSubtype(ABCallbackArgumentVisionModifier.class, "argumentVisionModifier")
				.registerSubtype(ABCallbackReuseVisionModifier.class, "reuseVisionModifier")
				.registerSubtype(ABCallbackReuseVisionModifierWithArguments.class, "reuseVisionModifierWithArguments")
						;
	}

	private static void registerWidgetCallbacks(RuntimeTypeAdapterFactory callbackTypeFactory) {
		callbackTypeFactory
				.registerSubtype(ABCallbackGetProjectileHitWidget.class, "getProjectileHitWidget")
				.registerSubtype(ABCallbackUnitToWidget.class, "unitToWidget")
				.registerSubtype(ABCallbackGetStoredWidgetByKey.class, "getStoredWidgetByKey")
				.registerSubtype(ABCallbackInlineConditionWidget.class, "inlineConditionWidget")

				.registerSubtype(ABCallbackArgumentWidget.class, "argumentWidget")
				.registerSubtype(ABCallbackReuseWidget.class, "reuseWidget")
				.registerSubtype(ABCallbackReuseWidgetWithArguments.class, "reuseWidgetWithArguments")
						;
	}

	private static void registerConditions(RuntimeTypeAdapterFactory conditionTypeFactory) {
		conditionTypeFactory.registerSubtype(ABConditionAnd.class, "and").registerSubtype(ABConditionOr.class, "or")
				.registerSubtype(ABConditionNot.class, "not").registerSubtype(ABConditionBool.class, "bool")
				.registerSubtype(ABConditionNotNull.class, "notNull")
				.registerSubtype(ABConditionIsNull.class, "isNull")
				
				.registerSubtype(ABConditionFloatEqual.class, "f=")
				.registerSubtype(ABConditionFloatEq0.class, "f=0")
				.registerSubtype(ABConditionFloatGte.class, "f>=")
				.registerSubtype(ABConditionFloatGt.class, "f>")
				.registerSubtype(ABConditionFloatLte.class, "f<=")
				.registerSubtype(ABConditionFloatLt.class, "f<")
				.registerSubtype(ABConditionFloatNe.class, "f!=")
				.registerSubtype(ABConditionFloatNe0.class, "f!=0")
				
				.registerSubtype(ABConditionIntegerEq.class, "i=")
				.registerSubtype(ABConditionIntegerNe.class, "i!=")
				.registerSubtype(ABConditionIntegerGt.class, "i>")
				.registerSubtype(ABConditionIntegerGte.class, "i>=")
				.registerSubtype(ABConditionIntegerLt.class, "i<")
				.registerSubtype(ABConditionIntegerLte.class, "i<=")
				.registerSubtype(ABConditionIntegerNe0.class, "i!=0")
				.registerSubtype(ABConditionIntegerEq0.class, "i=0")
				.registerSubtype(ABConditionIntegerIsOdd.class, "iOdd")
				.registerSubtype(ABConditionIntegerIsEven.class, "iEven")

				.registerSubtype(ABConditionSetCantUseReasonOnFailure.class, "setCantUseReasonOnFailure")
				
				.registerSubtype(ABConditionIsValidTarget.class, "isValidTarget")
				.registerSubtype(ABConditionIsUnitValidTarget.class, "isUnitValidTarget")
				.registerSubtype(ABConditionIsPassAllAbilityTargetChecks.class, "isPassAllAbilityTargetChecks")
				.registerSubtype(ABConditionIsUnitPassAllAbilityTargetChecks.class, "isUnitPassAllAbilityTargetChecks")
				.registerSubtype(ABConditionIsDestructableValidTarget.class, "isDestructableValidTarget")
				
				.registerSubtype(ABConditionIsUnitInRangeOfUnit.class, "isUnitInRangeOfUnit")
				.registerSubtype(ABConditionMatchingUnitExistsInRangeOfUnit.class, "matchingUnitExistsInRangeOfUnit")
				.registerSubtype(ABConditionMatchingCorpseExistsInRangeOfUnit.class, "matchingCorpseExistsInRangeOfUnit")
				
				.registerSubtype(ABConditionIsUnitInGroup.class, "isUnitInGroup")
				.registerSubtype(ABConditionIsUnitEqual.class, "isUnitEqual")
				.registerSubtype(ABConditionIsAttackTypeEqual.class, "isAttackTypeEqual")
				.registerSubtype(ABConditionIsDamageTypeEqual.class, "isDamageTypeEqual")
				.registerSubtype(ABConditionIsIdEqual.class, "isIdEqual")

				.registerSubtype(ABConditionIsOnCooldown.class, "isOnCooldown")
				.registerSubtype(ABConditionIsFlexAbilityTargeted.class, "isFlexAbilityTargeted")
				.registerSubtype(ABConditionIsFlexAbilityNonTargeted.class, "isFlexAbilityNonTargeted")
				.registerSubtype(ABConditionIsFlexAbilityPointTarget.class, "isFlexAbilityPointTarget")
				.registerSubtype(ABConditionIsFlexAbilityNonPointTarget.class, "isFlexAbilityNonPointTarget")
				.registerSubtype(ABConditionIsToggleAbilityActive.class, "isToggleAbilityActive")
				.registerSubtype(ABConditionIsTransformingToAlternate.class, "isTransformingToAlternate")
				

				.registerSubtype(ABConditionIsUnitType.class, "isUnitType")
				.registerSubtype(ABConditionDoesUnitHaveBuff.class, "doesUnitHaveBuff")
				.registerSubtype(ABConditionIsUnitMaxHp.class, "isUnitMaxHp")
				.registerSubtype(ABConditionIsUnitMaxMp.class, "isUnitMaxMp")
				.registerSubtype(ABConditionIsUnitBuilding.class, "isUnitBuilding")
				.registerSubtype(ABConditionIsUnitEnemy.class, "isUnitEnemy")
				.registerSubtype(ABConditionIsUnitDead.class, "isUnitDead")
				.registerSubtype(ABConditionIsUnitTraining.class, "isUnitTraining")
				.registerSubtype(ABConditionIsUnitMagicImmune.class, "isUnitMagicImmune")
				.registerSubtype(ABConditionIsUnitShareSpells.class, "isUnitShareSpells")

				.registerSubtype(ABConditionIsItemAbility.class, "isItemAbility")
				.registerSubtype(ABConditionItemHasCharges.class, "itemHasCharges")

				.registerSubtype(ABConditionIsTimerActive.class, "isTimerActive")

				.registerSubtype(ABConditionIsLocationDeepWater.class, "isLocationDeepWater")
				.registerSubtype(ABConditionIsLocationShallowWater.class, "isLocationShallowWater")
				.registerSubtype(ABConditionIsLocationWalkable.class, "isLocationWalkable")
				.registerSubtype(ABConditionIsLocationWalkableNonWater.class, "isLocationWalkableNonWater")
				.registerSubtype(ABConditionIsLocationFlyingOnly.class, "isLocationFlyingOnly")

				.registerSubtype(ABConditionIsLocationPathableForUnitType.class, "isLocationPathableForUnitType")

				.registerSubtype(ABConditionWasCastingInterrupted.class, "wasCastingInterrupted")
				.registerSubtype(ABConditionIsTriggeringDamageAnAttack.class, "isTriggeringDamageAnAttack")
				.registerSubtype(ABConditionIsTriggeringDamageRanged.class, "isTriggeringDamageRanged")

				.registerSubtype(ABConditionIsProjectileReflected.class, "isProjectileReflected")
				
				.registerSubtype(ABConditionIsBuffMagic.class, "isBuffMagic")
				

				.registerSubtype(ABConditionGameplayConstantCanDisableDivineShield.class, "gameplayConstantCanDisableDivineShield")
				.registerSubtype(ABConditionIsTimeOfDayInRange.class, "isTimeOfDayInRange")
				.registerSubtype(ABConditionGameplayConstantIsRelativeUpgradeCosts.class, "gameplayConstantIsRelativeUpgradeCosts")
				.registerSubtype(ABConditionGameplayConstantIsDefendCanDeflect.class, "gameplayConstantIsDefendCanDeflect")

				.registerSubtype(ABConditionIsNewBehaviorCategoryInList.class, "isNewBehaviorCategoryInList")
				
				
				;
	}

	private static void registerActions(RuntimeTypeAdapterFactory<ABAction> factory) {
		factory.registerSubtype(ABActionIf.class, "if")
				.registerSubtype(ABActionWhile.class, "while")
				.registerSubtype(ABActionFor.class, "for")
				.registerSubtype(ABActionBreak.class, "break")
				.registerSubtype(ABActionIterateUnitsInRangeOfUnit.class, "iterateUnitsInRangeOfUnit")
				.registerSubtype(ABActionIterateUnitsInRangeOfUnitMatchingCondition.class, "iterateUnitsInRangeOfUnitMatchingCondition")
				.registerSubtype(ABActionIterateUnitsInRangeOfLocation.class, "iterateUnitsInRangeOfLocation")
				.registerSubtype(ABActionIterateUnitsInRangeOfLocationMatchingCondition.class, "iterateUnitsInRangeOfLocationMatchingCondition")
				.registerSubtype(ABActionIterateUnitsInRect.class, "iterateUnitsInRect")
				.registerSubtype(ABActionPeriodicExecute.class, "periodicExecute")
				.registerSubtype(ABActionCleanUpCastInstance.class, "cleanUpCastInstance")

				.registerSubtype(ABActionCheckAbilityEffectReaction.class, "checkAbilityEffectReaction")
				.registerSubtype(ABActionCheckAbilityProjReaction.class, "checkAbilityProjReaction")

				.registerSubtype(ABActionCreateSpellEffectOnUnit.class, "createSpellEffectOnUnit")
				.registerSubtype(ABActionCreateTemporarySpellEffectOnUnit.class, "createTemporarySpellEffectOnUnit")
				.registerSubtype(ABActionCreateSpellEffectAtLocation.class, "createSpellEffectAtLocation")
				.registerSubtype(ABActionCreateTemporarySpellEffectAtLocation.class,
						"createTemporarySpellEffectAtLocation")
				.registerSubtype(ABActionCreateSpellEffectAtPoint.class, "createSpellEffectAtPoint")
				.registerSubtype(ABActionCreateTemporarySpellEffectAtPoint.class, "createTemporarySpellEffectAtPoint")
				.registerSubtype(ABActionCreateSoundEffectOnUnit.class, "createSoundEffectOnUnit")
				.registerSubtype(ABActionCreateLoopingSoundEffectOnUnit.class, "createLoopingSoundEffectOnUnit")
				.registerSubtype(ABActionCreateLightningEffect.class, "createLightningEffect")
				.registerSubtype(ABActionRemoveLightningEffect.class, "removeLightningEffect")

				.registerSubtype(ABActionCreateUnitTargetedProjectile.class, "createUnitTargetedProjectile")
				.registerSubtype(ABActionCreateLocationTargetedProjectile.class, "createLocationTargetedProjectile")
				.registerSubtype(ABActionCreateUnitTargetedCollisionProjectile.class, "createUnitTargetedCollisionProjectile")
				.registerSubtype(ABActionCreateLocationTargetedCollisionProjectile.class, "createLocationTargetedCollisionProjectile")
				.registerSubtype(ABActionCreateUnitTargetedPseudoProjectile.class, "createUnitTargetedPseudoProjectile")
				.registerSubtype(ABActionCreateLocationTargetedPseudoProjectile.class, "createLocationTargetedPseudoProjectile")
				
				.registerSubtype(ABActionSetProjectileDone.class, "setProjectileDone")
				.registerSubtype(ABActionSetProjectileReflected.class, "setProjectileReflected")
				.registerSubtype(ABActionSetProjectileTarget.class, "setProjectileTarget")
				.registerSubtype(ABActionSetAttackProjectileDamage.class, "setAttackProjectileDamage")
				

				.registerSubtype(ABActionAddAbility.class, "addAbility")
				.registerSubtype(ABActionAddNewAbility.class, "addNewAbility")
				.registerSubtype(ABActionRemoveAbility.class, "removeAbility")
				.registerSubtype(ABActionStoreValueLocally.class, "storeValueLocally")
				.registerSubtype(ABActionRemoveSpellEffect.class, "removeSpellEffect")
				.registerSubtype(ABActionCreateAbilityFromId.class, "createAbilityFromId")
				.registerSubtype(ABActionAddDefenseBonus.class, "addDefenseBonus")
				.registerSubtype(ABActionRemoveDefenseBonus.class, "removeDefenseBonus")
				.registerSubtype(ABActionAddRallyAbility.class, "addRallyAbility")
				
				.registerSubtype(ABActionCreateUnitGroup.class, "createUnitGroup")
				.registerSubtype(ABActionIterateUnitsInGroup.class, "iterateUnitsInGroup")
				.registerSubtype(ABActionAddUnitToGroup.class, "addUnitToGroup")
				.registerSubtype(ABActionRemoveUnitFromGroup.class, "removeUnitFromGroup")
				
				.registerSubtype(ABActionCreateUnitQueue.class, "createUnitQueue")
				.registerSubtype(ABActionIterateUnitsInQueue.class, "iterateUnitsInQueue")
				.registerSubtype(ABActionAddUnitToQueue.class, "addUnitToQueue")
				.registerSubtype(ABActionRemoveUnitFromQueue.class, "removeUnitFromQueue")
				.registerSubtype(ABActionClearUnitQueue.class, "clearUnitQueue")

				.registerSubtype(ABActionCreateUnit.class, "createUnit")
				.registerSubtype(ABActionDamageTarget.class, "damageTarget").registerSubtype(ABActionHeal.class, "heal")
				.registerSubtype(ABActionSetHp.class, "setHp").registerSubtype(ABActionResurrect.class, "resurrect")
				.registerSubtype(ABActionSetMp.class, "setMp")
				.registerSubtype(ABActionAddMp.class, "addMp")
				.registerSubtype(ABActionSubtractMp.class, "subtractMp")
				.registerSubtype(ABActionMultiplyUnitScale.class, "multiplyUnitScale")
				.registerSubtype(ABActionAddStunBuff.class, "addStunBuff")
				.registerSubtype(ABActionAddSlowBuff.class, "addSlowBuff")
				.registerSubtype(ABActionKillUnit.class, "killUnit")
				.registerSubtype(ABActionRemoveUnit.class, "removeUnit")
				.registerSubtype(ABActionHideUnit.class, "hideUnit")
				.registerSubtype(ABActionUnhideUnit.class, "unhideUnit")
				.registerSubtype(ABActionMergeUnits.class, "mergeUnits")
				.registerSubtype(ABActionTransformUnit.class, "transformUnit")
				.registerSubtype(ABActionTransformUnitInstant.class, "transformUnitInstant")
				.registerSubtype(ABActionTransformedUnitAbilityAdd.class, "transformedUnitAbilityAdd")
				.registerSubtype(ABActionTransformedUnitAbilityRemove.class, "transformedUnitAbilityRemove")
				.registerSubtype(ABActionSetExplodesOnDeath.class, "setExplodesOnDeath")
				.registerSubtype(ABActionIssueStopOrder.class, "issueStopOrder")
				.registerSubtype(ABActionSendUnitBackToWork.class, "sendUnitBackToWork")
				.registerSubtype(ABActionStartTrainingUnit.class, "startTrainingUnit")
				.registerSubtype(ABActionStartSacrificingUnit.class, "startSacrificingUnit")

				.registerSubtype(ABActionSetUnitFlyHeight.class, "setUnitFlyHeight")
				.registerSubtype(ABActionSetUnitMovementTypeNoCollision.class, "setUnitMovementTypeNoCollision")
				

				.registerSubtype(ABActionPlayAnimation.class, "playAnimation")
				.registerSubtype(ABActionAddSecondaryAnimationTag.class, "addSecondaryAnimationTag")
				.registerSubtype(ABActionRemoveSecondaryAnimationTag.class, "removeSecondaryAnimationTag")

				.registerSubtype(ABActionSetUnitAlpha.class, "setUnitAlpha")
				.registerSubtype(ABActionMultiplyUnitAlpha.class, "multiplyUnitAlpha")
				.registerSubtype(ABActionDivideUnitAlpha.class, "divideUnitAlpha")

				.registerSubtype(ABActionInstantReturnResources.class, "instantReturnResources")
				.registerSubtype(ABActionEnableWorkerAbilities.class, "enableWorkerAbilities")
				.registerSubtype(ABActionDisableWorkerAbilities.class, "disableWorkerAbilities")
				
				
				
				.registerSubtype(ABActionStartCooldown.class, "startCooldown")
				.registerSubtype(ABActionResetCooldown.class, "resetCooldown")
				.registerSubtype(ABActionActivateToggledAbility.class, "activateToggledAbility")
				.registerSubtype(ABActionDeactivateToggledAbility.class, "deactivateToggledAbility")
				.registerSubtype(ABActionEnableAbility.class, "enableAbility")
				.registerSubtype(ABActionDisableAbility.class, "disableAbility")
				.registerSubtype(ABActionBeginChanneling.class, "beginChanneling")
				.registerSubtype(ABActionFinishChanneling.class, "finishChanneling")
				.registerSubtype(ABActionSetAbilityCastRange.class, "setAbilityCastRange")
				.registerSubtype(ABActionAddTargetAllowed.class, "addTargetAllowed")
				.registerSubtype(ABActionRemoveTargetAllowed.class, "removeTargetAllowed")
				

				.registerSubtype(ABActionCreateTimer.class, "createTimer")
				.registerSubtype(ABActionStartTimer.class, "startTimer")
				.registerSubtype(ABActionUpdateTimerTimeout.class, "updateTimerTimeout")
				.registerSubtype(ABActionRemoveTimer.class, "removeTimer")

				.registerSubtype(ABActionAddBuff.class, "addBuff")
				.registerSubtype(ABActionAddNonStackingDisplayBuff.class, "addNonStackingDisplayBuff")
				.registerSubtype(ABActionRemoveBuff.class, "removeBuff")
				.registerSubtype(ABActionDispelBuffs.class, "dispelBuffs")
				.registerSubtype(ABActionRemoveNonStackingDisplayBuff.class, "removeNonStackingDisplayBuff")
				.registerSubtype(ABActionCreatePassiveBuff.class, "createPassiveBuff")
				.registerSubtype(ABActionCreateTargetingBuff.class, "createTargetingBuff")
				.registerSubtype(ABActionCreateTimedBuff.class, "createTimedBuff")
				.registerSubtype(ABActionCreateTimedTargetingBuff.class, "createTimedTargetingBuff")
				.registerSubtype(ABActionCreateTimedArtBuff.class, "createTimedArtBuff")
				.registerSubtype(ABActionCreateTimedTickingBuff.class, "createTimedTickingBuff")
				.registerSubtype(ABActionCreateTimedTickingPausedBuff.class, "createTimedTickingPausedBuff")
				.registerSubtype(ABActionCreateTimedTickingPostDeathBuff.class, "createTimedTickingPostDeathBuff")
				.registerSubtype(ABActionCreateTimedLifeBuff.class, "createTimedLifeBuff")

				.registerSubtype(ABActionCreateStateModBuff.class, "createStateModBuff")
				.registerSubtype(ABActionAddStateModBuff.class, "addStateModBuff")
				.registerSubtype(ABActionRemoveStateModBuff.class, "removeStateModBuff")
				.registerSubtype(ABActionSetUnitFadeTimer.class, "setUnitFadeTimer")

				.registerSubtype(ABActionCreateNonStackingStatBuff.class, "createNonStackingStatBuff")
				.registerSubtype(ABActionAddNonStackingStatBuff.class, "addNonStackingStatBuff")
				.registerSubtype(ABActionRemoveNonStackingStatBuff.class, "removeNonStackingStatBuff")
				.registerSubtype(ABActionUpdateNonStackingStatBuff.class, "updateNonStackingStatBuff")
				.registerSubtype(ABActionRecomputeStatBuffsOnUnit.class, "recomputeStatBuffsOnUnit")

				.registerSubtype(ABActionCreateAttackPostDamageListener.class, "createAttackPostDamageListener")
				.registerSubtype(ABActionAddAttackPostDamageListener.class, "addAttackPostDamageListener")
				.registerSubtype(ABActionRemoveAttackPostDamageListener.class, "removeAttackPostDamageListener")
				.registerSubtype(ABActionCreateAttackPreDamageListener.class, "createAttackPreDamageListener")
				.registerSubtype(ABActionAddAttackPreDamageListener.class, "addAttackPreDamageListener")
				.registerSubtype(ABActionRemoveAttackPreDamageListener.class, "removeAttackPreDamageListener")
				.registerSubtype(ABActionCreateDamageTakenListener.class, "createDamageTakenListener")
				.registerSubtype(ABActionAddDamageTakenListener.class, "addDamageTakenListener")
				.registerSubtype(ABActionRemoveDamageTakenListener.class, "removeDamageTakenListener")
				.registerSubtype(ABActionCreateDamageTakenModificationListener.class,
						"createDamageTakenModificationListener")
				.registerSubtype(ABActionAddDamageTakenModificationListener.class, "addDamageTakenModificationListener")
				.registerSubtype(ABActionRemoveDamageTakenModificationListener.class,
						"removeDamageTakenModificationListener")
				.registerSubtype(ABActionCreateFinalDamageTakenModificationListener.class,
						"createFinalDamageTakenModificationListener")
				.registerSubtype(ABActionAddFinalDamageTakenModificationListener.class, "addFinalDamageTakenModificationListener")
				.registerSubtype(ABActionRemoveFinalDamageTakenModificationListener.class,
						"removeFinalDamageTakenModificationListener")
				.registerSubtype(ABActionCreateEvasionListener.class, "createEvasionListener")
				.registerSubtype(ABActionAddEvasionListener.class, "addEvasionListener")
				.registerSubtype(ABActionRemoveEvasionListener.class, "removeEvasionListener")
				.registerSubtype(ABActionCreateDeathReplacementEffect.class, "createDeathReplacementEffect")
				.registerSubtype(ABActionAddDeathReplacementEffect.class, "addDeathReplacementEffect")
				.registerSubtype(ABActionRemoveDeathReplacementEffect.class, "removeDeathReplacementEffect")
				.registerSubtype(ABActionCreateBehaviorChangeListener.class, "createBehaviorChangeListener")
				.registerSubtype(ABActionAddBehaviorChangeListener.class, "addBehaviorChangeListener")
				.registerSubtype(ABActionRemoveBehaviorChangeListener.class, "removeBehaviorChangeListener")

				.registerSubtype(ABActionCreateAbilityEffectReactionListener.class, "createAbilityEffectReactionListener")
				.registerSubtype(ABActionAddAbilityEffectReactionListener.class, "addAbilityEffectReactionListener")
				.registerSubtype(ABActionRemoveAbilityEffectReactionListener.class, "removeAbilityEffectReactionListener")
				.registerSubtype(ABActionCreateAbilityProjReactionListener.class, "createAbilityProjReactionListener")
				.registerSubtype(ABActionAddAbilityProjReactionListener.class, "addAbilityProjReactionListener")
				.registerSubtype(ABActionRemoveAbilityProjReactionListener.class, "removeAbilityProjReactionListener")
				.registerSubtype(ABActionCreateAttackProjReactionListener.class, "createAttackProjReactionListener")
				.registerSubtype(ABActionAddAttackProjReactionListener.class, "addAttackProjReactionListener")
				.registerSubtype(ABActionRemoveAttackProjReactionListener.class, "removeAttackProjReactionListener")

				.registerSubtype(ABActionDamageTakenModificationSetDamageMultiplier.class, "setDamageTakenMultiplier")
				.registerSubtype(ABActionDamageTakenModificationMultiplyDamageMultiplier.class,
						"multiplyDamageTakenMultiplier")
				.registerSubtype(ABActionPreDamageListenerAddDamageMultiplier.class, "addDamageDealtMultiplier")
				.registerSubtype(ABActionPreDamageListenerAddBonusDamage.class, "addBonusDamageDealt")
				.registerSubtype(ABActionPreDamageListenerSetMiss.class, "preDamageListenerSetMiss")
				.registerSubtype(ABActionSetPreDamageStacking.class, "setStacking")
				.registerSubtype(ABActionDeathReplacementSetReviving.class, "setReviving")
				.registerSubtype(ABActionDeathReplacementSetReincarnating.class, "setReincarnating")
				.registerSubtype(ABActionDeathReplacementFinishReincarnating.class, "finishReincarnating")
				.registerSubtype(ABActionSubtractTotalDamageDealt.class, "subtractTotalDamageDealt")
				.registerSubtype(ABActionReactionPreventHit.class, "reactionPreventHit")

				.registerSubtype(ABActionAddDestructableBuff.class, "addDestructableBuff")
				.registerSubtype(ABActionCreateDestructableBuff.class, "createDestructableBuff")
				.registerSubtype(ABActionRemoveDestructableBuff.class, "removeDestructableBuff")
				.registerSubtype(ABActionIterateDestructablesInRangeOfLocation.class, "iterateDestructablesInRangeOfLocation")
				.registerSubtype(ABActionDamageDestructable.class, "damageDestructable")

				.registerSubtype(ABActionCreateFloatingTextOnUnit.class, "createFloatingTextOnUnit")
				.registerSubtype(ABActionCreateNumericFloatingTextOnUnit.class, "createNumericFloatingTextOnUnit")

				.registerSubtype(ABActionSetAutoTargetUnit.class, "setAutoTargetUnit")
				.registerSubtype(ABActionSetAutoTargetDestructable.class, "setAutoTargetDestructable")
				
				

				.registerSubtype(ABActionChargeItem.class, "chargeItem")
				
				
				

				.registerSubtype(ABActionGiveResourcesToPlayer.class, "giveResourcesToPlayer")
				.registerSubtype(ABActionSetAbilityEnabledForPlayer.class, "setAbilityEnabledForPlayer")

				.registerSubtype(ABActionCreateUnitVisionModifier.class, "createUnitVisionModifier")
				.registerSubtype(ABActionCreateLocationVisionModifier.class, "createLocationVisionModifier")
				.registerSubtype(ABActionRemoveVisionModifier.class, "removeVisionModifier")
				
				
				.registerSubtype(ABActionAbilitySetShowIcon.class, "abilitySetShowIcon")


				.registerSubtype(ABActionCreateTimeOfDayEvent.class, "createTimeOfDayEvent")
				.registerSubtype(ABActionRegisterTimeOfDayEvent.class, "registerTimeOfDayEvent")
				.registerSubtype(ABActionRegisterUniqueTimeOfDayEvent.class, "registerUniqueTimeOfDayEvent")
				.registerSubtype(ABActionUnregisterTimeOfDayEvent.class, "unregisterTimeOfDayEvent")
				
				

				.registerSubtype(ABActionCreateSubroutine.class, "createSubroutine")
				.registerSubtype(ABActionRunSubroutine.class, "runSubroutine")

				.registerSubtype(ABActionRunReuseAction.class, "runReuseAction")
				.registerSubtype(ABActionRunReuseActionWithArguments.class, "runReuseActionWithArguments")

				.registerSubtype(ABActionSetFalseTimeOfDay.class, "setFalseTimeOfDay")
				;
	}

	public static Gson create() {
		GsonBuilder gsonBuilder = new GsonBuilder();

		final RuntimeTypeAdapterFactory<ABAction> actionTypeFactory = RuntimeTypeAdapterFactory.of(ABAction.class,
				"type");
		registerActions(actionTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(actionTypeFactory);

		final RuntimeTypeAdapterFactory<ABCallback> callbackTypeFactory = RuntimeTypeAdapterFactory.of(ABCallback.class,
				"type");
		registerAbilityCallbacks(callbackTypeFactory);
		registerAbilityEffectReactionListenerCallbacks(callbackTypeFactory);
		registerAbilityProjReactionListenerCallbacks(callbackTypeFactory);
		registerAttackProjReactionListenerCallbacks(callbackTypeFactory);
		registerAttackPostDamageListenerCallbacks(callbackTypeFactory);
		registerAttackPreDamageListenerCallbacks(callbackTypeFactory);
		registerBehaviorChangeListenerCallbacks(callbackTypeFactory);
		registerBooleanCallbacks(callbackTypeFactory);
		registerConditions(callbackTypeFactory); // conditions are boolean callbacks now
		registerBuffCallbacks(callbackTypeFactory);
		registerDamageTakenListenerCallbacks(callbackTypeFactory);
		registerDamageTakenModificationListenerCallbacks(callbackTypeFactory);
		registerDeathReplacementEffectCallbacks(callbackTypeFactory);
		registerDestructableCallbacks(callbackTypeFactory);
		registerDestructableBuffCallbacks(callbackTypeFactory);
		registerEvasionListenerCallbacks(callbackTypeFactory);
		registerFinalDamageTakenModificationListenerCallbacks(callbackTypeFactory);
		registerFloatCallbacks(callbackTypeFactory);
		registerGenericFloatCallbacks(callbackTypeFactory);
		registerFxCallbacks(callbackTypeFactory);
		registerIdCallbacks(callbackTypeFactory);
		registerIntegerCallbacks(callbackTypeFactory);
		registerLightningCallbacks(callbackTypeFactory);
		registerLocationCallbacks(callbackTypeFactory);
		registerLongCallbacks(callbackTypeFactory);
		registerOrderIdCallbacks(callbackTypeFactory);
		registerPlayerCallbacks(callbackTypeFactory);
		registerProjectileCallbacks(callbackTypeFactory);
		registerStatBuffCallbacks(callbackTypeFactory);
		registerStateModBuffCallbacks(callbackTypeFactory);
		registerStringCallbacks(callbackTypeFactory);
		registerTargetCallbacks(callbackTypeFactory);
		registerTimeOfDayEventCallbacks(callbackTypeFactory);
		registerTimerCallbacks(callbackTypeFactory);
		registerUnitCallbacks(callbackTypeFactory);
		registerUnitGroupCallbacks(callbackTypeFactory);
		registerUnitQueueCallbacks(callbackTypeFactory);
		registerVisionModifierCallbacks(callbackTypeFactory);
		registerWidgetCallbacks(callbackTypeFactory);
		callbackTypeFactory.registerSubtype(ABCallbackNull.class, "null");
		gsonBuilder.registerTypeAdapterFactory(callbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABAbilityCallback> abilityCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAbilityCallback.class, "type");
		registerAbilityCallbacks(abilityCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(abilityCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABAbilityEffectReactionListenerCallback> abilityEffectReactionListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAbilityEffectReactionListenerCallback.class, "type");
		registerAbilityEffectReactionListenerCallbacks(abilityEffectReactionListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(abilityEffectReactionListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABAbilityProjReactionListenerCallback> abilityProjReactionListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAbilityProjReactionListenerCallback.class, "type");
		registerAbilityProjReactionListenerCallbacks(abilityProjReactionListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(abilityProjReactionListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABAttackProjReactionListenerCallback> attackProjReactionListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAttackProjReactionListenerCallback.class, "type");
		registerAttackProjReactionListenerCallbacks(attackProjReactionListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(attackProjReactionListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABAttackPostDamageListenerCallback> attackPostDamageListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAttackPostDamageListenerCallback.class, "type");
		registerAttackPostDamageListenerCallbacks(attackPostDamageListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(attackPostDamageListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABAttackPreDamageListenerCallback> attackPreDamageListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAttackPreDamageListenerCallback.class, "type");
		registerAttackPreDamageListenerCallbacks(attackPreDamageListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(attackPreDamageListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABBehaviorChangeListenerCallback> behaviorChangeListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABBehaviorChangeListenerCallback.class, "type");
		registerBehaviorChangeListenerCallbacks(behaviorChangeListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(behaviorChangeListenerCallbackTypeFactory);
		
		final RuntimeTypeAdapterFactory<ABBooleanCallback> booleanCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABBooleanCallback.class, "type");
		registerBooleanCallbacks(booleanCallbackTypeFactory);
		registerConditions(booleanCallbackTypeFactory); // conditions are boolean callbacks now
		gsonBuilder.registerTypeAdapterFactory(booleanCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABBuffCallback> buffCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABBuffCallback.class, "type");
		registerBuffCallbacks(buffCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(buffCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABDamageTakenListenerCallback> damageTakenListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDamageTakenListenerCallback.class, "type");
		registerDamageTakenListenerCallbacks(damageTakenListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(damageTakenListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABDamageTakenModificationListenerCallback> damageTakenModificationListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDamageTakenModificationListenerCallback.class, "type");
		registerDamageTakenModificationListenerCallbacks(damageTakenModificationListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(damageTakenModificationListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABDeathReplacementCallback> deathReplacementEffectCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDeathReplacementCallback.class, "type");
		registerDeathReplacementEffectCallbacks(deathReplacementEffectCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(deathReplacementEffectCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABDestructableCallback> destructableCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDestructableCallback.class, "type");
		registerDestructableCallbacks(destructableCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(destructableCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABDestructableBuffCallback> destructableBuffCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDestructableBuffCallback.class, "type");
		registerDestructableBuffCallbacks(destructableBuffCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(destructableBuffCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABEvasionListenerCallback> evasionListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABEvasionListenerCallback.class, "type");
		registerEvasionListenerCallbacks(evasionListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(evasionListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABFinalDamageTakenModificationListenerCallback> finalDamageTakenModificationListenerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABFinalDamageTakenModificationListenerCallback.class, "type");
		registerFinalDamageTakenModificationListenerCallbacks(finalDamageTakenModificationListenerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(finalDamageTakenModificationListenerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABFloatCallback> floatCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABFloatCallback.class, "type");
		registerFloatCallbacks(floatCallbackTypeFactory);
		registerSpecialFloatCallbacks(floatCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(floatCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABFXCallback> fxCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABFXCallback.class, "type");
		registerFxCallbacks(fxCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(fxCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABIDCallback> idCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABIDCallback.class, "type");
		registerIdCallbacks(idCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(idCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABIntegerCallback> integerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABIntegerCallback.class, "type");
		registerIntegerCallbacks(integerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(integerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABLightningCallback> lightningCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABLightningCallback.class, "type");
		registerLightningCallbacks(lightningCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(lightningCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABLocationCallback> locationCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABLocationCallback.class, "type");
		registerLocationCallbacks(locationCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(locationCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABLongCallback> longCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABLongCallback.class, "type");
		registerLongCallbacks(longCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(longCallbackTypeFactory);
		
		final RuntimeTypeAdapterFactory<ABOrderIdCallback> orderIdCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABOrderIdCallback.class, "type");
		registerOrderIdCallbacks(orderIdCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(orderIdCallbackTypeFactory);


		final RuntimeTypeAdapterFactory<ABPlayerCallback> playerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABPlayerCallback.class, "type");
		registerPlayerCallbacks(playerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(playerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABProjectileCallback> projectileCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABProjectileCallback.class, "type");
		registerProjectileCallbacks(projectileCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(projectileCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABNonStackingStatBuffCallback> statBuffCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABNonStackingStatBuffCallback.class, "type");
		registerStatBuffCallbacks(statBuffCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(statBuffCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABStateModBuffCallback> stateModBuffCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABStateModBuffCallback.class, "type");
		registerStateModBuffCallbacks(stateModBuffCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(stateModBuffCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABStringCallback> stringCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABStringCallback.class, "type");
		registerStringCallbacks(stringCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(stringCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABTargetCallback> targetCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABTargetCallback.class, "type");
		registerTargetCallbacks(targetCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(targetCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABTimeOfDayEventCallback> timeOfDayEventCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABTimeOfDayEventCallback.class, "type");
		registerTimeOfDayEventCallbacks(timeOfDayEventCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(timeOfDayEventCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABTimerCallback> timerCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABTimerCallback.class, "type");
		registerTimerCallbacks(timerCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(timerCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABUnitCallback> unitCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABUnitCallback.class, "type");
		registerUnitCallbacks(unitCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(unitCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABUnitGroupCallback> unitGroupCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABUnitGroupCallback.class, "type");
		registerUnitGroupCallbacks(unitGroupCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(unitGroupCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABUnitQueueCallback> unitQueueCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABUnitQueueCallback.class, "type");
		registerUnitQueueCallbacks(unitQueueCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(unitQueueCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABVisionModifierCallback> visionModifierCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABVisionModifierCallback.class, "type");
		registerVisionModifierCallbacks(visionModifierCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(visionModifierCallbackTypeFactory);
		
		
		final RuntimeTypeAdapterFactory<ABWidgetCallback> widgetCallbackTypeFactory = RuntimeTypeAdapterFactory
				.of(ABWidgetCallback.class, "type");
		registerWidgetCallbacks(widgetCallbackTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(widgetCallbackTypeFactory);

		final RuntimeTypeAdapterFactory<ABCondition> conditionTypeFactory = RuntimeTypeAdapterFactory
				.of(ABCondition.class, "type");
		registerConditions(conditionTypeFactory);
		registerBooleanCallbacks(conditionTypeFactory);
		gsonBuilder.registerTypeAdapterFactory(conditionTypeFactory);

		// ENUM CALLBACKS
		final RuntimeTypeAdapterFactory<ABNonStackingStatBuffTypeCallback> nssbtTypeFactory = RuntimeTypeAdapterFactory
				.of(ABNonStackingStatBuffTypeCallback.class, "type");
		nssbtTypeFactory.registerSubtype(ABCallbackGetNonStackingStatBuffTypeFromString.class,
				"getNonStackingStatBuffTypeFromString");
		gsonBuilder.registerTypeAdapterFactory(nssbtTypeFactory);

		final RuntimeTypeAdapterFactory<ABAttackTypeCallback> atTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAttackTypeCallback.class, "type");
		atTypeFactory.registerSubtype(ABCallbackGetAttackTypeFromString.class, "getAttackTypeFromString")
				.registerSubtype(ABCallbackGetTriggeringAttackType.class, "getTriggeringAttackType")
				.registerSubtype(ABCallbackGetReactionAttackProjectileAttackType.class, "getReactionAttackProjectileAttackType");
		gsonBuilder.registerTypeAdapterFactory(atTypeFactory);

		final RuntimeTypeAdapterFactory<ABDamageTypeCallback> dtTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDamageTypeCallback.class, "type");
		dtTypeFactory.registerSubtype(ABCallbackGetDamageTypeFromString.class, "getDamageTypeFromString")
				.registerSubtype(ABCallbackGetTriggeringDamageType.class, "getTriggeringDamageType");
		gsonBuilder.registerTypeAdapterFactory(dtTypeFactory);

		final RuntimeTypeAdapterFactory<ABAttackPreDamageListenerPriorityCallback> pdlpTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAttackPreDamageListenerPriorityCallback.class, "type");
		pdlpTypeFactory.registerSubtype(ABCallbackRawPreDamageListenerPriority.class, "rawPriority");
		gsonBuilder.registerTypeAdapterFactory(pdlpTypeFactory);

		final RuntimeTypeAdapterFactory<ABDeathReplacementPriorityCallback> drepTypeFactory = RuntimeTypeAdapterFactory
				.of(ABDeathReplacementPriorityCallback.class, "type");
		drepTypeFactory.registerSubtype(ABCallbackRawDeathEffectPriority.class, "rawPriority");
		gsonBuilder.registerTypeAdapterFactory(drepTypeFactory);

		final RuntimeTypeAdapterFactory<ABAutocastTypeCallback> autocastTypeFactory = RuntimeTypeAdapterFactory
				.of(ABAutocastTypeCallback.class, "type");
		autocastTypeFactory.registerSubtype(ABCallbackConditionalAutocastType.class,
				"conditionalAutocastType");
		autocastTypeFactory.registerSubtype(ABCallbackGetAutocastTypeFromString.class,
				"getAutocastTypeFromString");
		gsonBuilder.registerTypeAdapterFactory(autocastTypeFactory);

		
		return gsonBuilder.create();
	}
}
