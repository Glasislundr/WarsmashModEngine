// ability customization API types
type abilitytypeleveldata extends handle // GetHandleId(myAbilityTypeLevelData) is a crash case, dont' do it
type targettype extends handle
type texttagconfigtype extends handle
//type activeability extends ability (this comment is a reminder to either scap or implement this type for real)
type localstore extends handle // GetHandleId(myLocalStore) is a crash case, dont' do it
type destructablebuff extends handle // a buff that is applied to a destructable
type projectile extends handle
type gameobject extends handle
type worldeditordatatype extends handle
type nonstackingstatbuff extends handle
type nonstackingstatbufftype extends handle
type abilitybuilderconfiguration extends handle
type autocasttype extends handle
type abconftype extends handle

type datafieldletter extends handle

type abtimeofdayevent extends handle // Ability Builder time of day event (doesnt have handleid for now)

constant native ConvertTargetType takes integer x returns targettype
constant native ConvertTextTagConfigType takes integer x returns texttagconfigtype
constant native ConvertWorldEditorDataType takes integer x returns worldeditordatatype
constant native ConvertNonStackingStatBuffType takes integer x returns nonstackingstatbufftype
constant native ConvertDataFieldLetter takes integer x returns datafieldletter
constant native ConvertAutocastType takes integer x returns autocasttype
constant native ConvertABConfType takes integer x returns abconftype

globals
    constant autocasttype AUTOCAST_TYPE_NONE                              = ConvertAutocastType(0)
    constant autocasttype AUTOCAST_TYPE_LOWESTHP                          = ConvertAutocastType(1)
    constant autocasttype AUTOCAST_TYPE_HIGESTHP                          = ConvertAutocastType(2)
    constant autocasttype AUTOCAST_TYPE_ATTACKTARGETING                   = ConvertAutocastType(3)
    constant autocasttype AUTOCAST_TYPE_ATTACKINGALLY                     = ConvertAutocastType(4)
    constant autocasttype AUTOCAST_TYPE_ATTACKINGENEMY                    = ConvertAutocastType(5)
    constant autocasttype AUTOCAST_TYPE_NEARESTVALID                      = ConvertAutocastType(6)
    constant autocasttype AUTOCAST_TYPE_NEARESTENEMY                      = ConvertAutocastType(7)
    constant autocasttype AUTOCAST_TYPE_NOTARGET                          = ConvertAutocastType(8)
    constant autocasttype AUTOCAST_TYPE_ATTACKREPLACEMENT                 = ConvertAutocastType(9)
    
    constant abconftype AB_CONF_TYPE_NORMAL_AUTOTARGET                 = ConvertABConfType(0)
    constant abconftype AB_CONF_TYPE_NORMAL_PAIRING                    = ConvertABConfType(1)
    constant abconftype AB_CONF_TYPE_NORMAL_FLEXTARGET_SIMPLE          = ConvertABConfType(2)
    constant abconftype AB_CONF_TYPE_NORMAL_UNITTARGET_SIMPLE          = ConvertABConfType(3)
    constant abconftype AB_CONF_TYPE_NORMAL_POINTTARGET_SIMPLE         = ConvertABConfType(4)
    constant abconftype AB_CONF_TYPE_NORMAL_NOTARGET_SIMPLE            = ConvertABConfType(5)
    constant abconftype AB_CONF_TYPE_NORMAL_FLEXTARGET                 = ConvertABConfType(6)
    constant abconftype AB_CONF_TYPE_NORMAL_UNITTARGET                 = ConvertABConfType(7)
    constant abconftype AB_CONF_TYPE_NORMAL_POINTTARGET                = ConvertABConfType(8)
    constant abconftype AB_CONF_TYPE_NORMAL_NOTARGET                   = ConvertABConfType(9)
    constant abconftype AB_CONF_TYPE_TOGGLE                            = ConvertABConfType(10)
    constant abconftype AB_CONF_TYPE_SMART                             = ConvertABConfType(11)
    constant abconftype AB_CONF_TYPE_PASSIVE                           = ConvertABConfType(12)
    constant abconftype AB_CONF_TYPE_TEMPLATE                          = ConvertABConfType(13)
    constant abconftype AB_CONF_TYPE_HIDDEN                            = ConvertABConfType(14)
    
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_GOLD                              = ConvertTextTagConfigType(0)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_LUMBER                            = ConvertTextTagConfigType(1)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_GOLD_BOUNTY                       = ConvertTextTagConfigType(2)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_LUMBER_BOUNTY                     = ConvertTextTagConfigType(3)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_XP                                = ConvertTextTagConfigType(4) // 1.32+ otherwise wont load
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_MISS_TEXT                         = ConvertTextTagConfigType(5)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_CRITICAL_STRIKE                   = ConvertTextTagConfigType(6)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_SHADOW_STRIKE                     = ConvertTextTagConfigType(7)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_MANA_BURN                         = ConvertTextTagConfigType(8)
    constant texttagconfigtype TEXT_TAG_CONFIG_TYPE_BASH                              = ConvertTextTagConfigType(9)
	
    constant targettype TARGET_TYPE_AIR                               = ConvertTargetType(0)
    constant targettype TARGET_TYPE_ALIVE                             = ConvertTargetType(1)
    constant targettype TARGET_TYPE_ALLIES                            = ConvertTargetType(2)
    constant targettype TARGET_TYPE_DEAD                              = ConvertTargetType(3)
    constant targettype TARGET_TYPE_DEBRIS                            = ConvertTargetType(4)
    constant targettype TARGET_TYPE_ENEMIES                           = ConvertTargetType(5)
    constant targettype TARGET_TYPE_GROUND                            = ConvertTargetType(6)
    constant targettype TARGET_TYPE_HERO                              = ConvertTargetType(7)
    constant targettype TARGET_TYPE_INVULNERABLE                      = ConvertTargetType(8)
    constant targettype TARGET_TYPE_ITEM                              = ConvertTargetType(9)
    constant targettype TARGET_TYPE_MECHANICAL                        = ConvertTargetType(10)
    constant targettype TARGET_TYPE_NEUTRAL                           = ConvertTargetType(11)
    constant targettype TARGET_TYPE_NONE                              = ConvertTargetType(12)
    constant targettype TARGET_TYPE_NONHERO                           = ConvertTargetType(13)
    constant targettype TARGET_TYPE_NONSAPPER                         = ConvertTargetType(14)
    constant targettype TARGET_TYPE_NOTSELF                           = ConvertTargetType(15)
    constant targettype TARGET_TYPE_ORGANIC                           = ConvertTargetType(16)
    constant targettype TARGET_TYPE_PLAYERUNITS                       = ConvertTargetType(17)
    constant targettype TARGET_TYPE_SAPPER                            = ConvertTargetType(18)
    constant targettype TARGET_TYPE_SELF                              = ConvertTargetType(19)
    constant targettype TARGET_TYPE_STRUCTURE                         = ConvertTargetType(20)
    constant targettype TARGET_TYPE_TERRAIN                           = ConvertTargetType(21)
    constant targettype TARGET_TYPE_TREE                              = ConvertTargetType(22)
    constant targettype TARGET_TYPE_VULNERABLE                        = ConvertTargetType(23)
    constant targettype TARGET_TYPE_WALL                              = ConvertTargetType(24)
    constant targettype TARGET_TYPE_WARD                              = ConvertTargetType(25)
    constant targettype TARGET_TYPE_ANCIENT                           = ConvertTargetType(26)
    constant targettype TARGET_TYPE_NONANCIENT                        = ConvertTargetType(27)
    constant targettype TARGET_TYPE_FRIEND                            = ConvertTargetType(28)
    constant targettype TARGET_TYPE_BRIDGE                            = ConvertTargetType(29)
    constant targettype TARGET_TYPE_DECORATION                        = ConvertTargetType(30)
    constant targettype TARGET_TYPE_NON_MAGIC_IMMUNE                  = ConvertTargetType(31)
    constant targettype TARGET_TYPE_NON_ETHEREAL                      = ConvertTargetType(32)
	
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_UNITS                    = ConvertWorldEditorDataType(0)
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_ITEMS                    = ConvertWorldEditorDataType(1)
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_DESTRUCTABLES            = ConvertWorldEditorDataType(2)
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_DOODADS                  = ConvertWorldEditorDataType(3)
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_ABILITIES                = ConvertWorldEditorDataType(4)
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_BUFFS_EFFECTS            = ConvertWorldEditorDataType(5)
	constant worldeditordatatype WORLD_EDITOR_DATA_TYPE_UPGRADES                 = ConvertWorldEditorDataType(6)
	
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MELEEATK                          = ConvertNonStackingStatBuffType(0)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MELEEATKPCT                       = ConvertNonStackingStatBuffType(1)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_RNGDATK                           = ConvertNonStackingStatBuffType(2)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_RNGDATKPCT                        = ConvertNonStackingStatBuffType(3)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_ATKSPD                            = ConvertNonStackingStatBuffType(4)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_DEF                               = ConvertNonStackingStatBuffType(5)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_DEFPCT                            = ConvertNonStackingStatBuffType(6)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_HPGEN                             = ConvertNonStackingStatBuffType(7)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_HPGENPCT                          = ConvertNonStackingStatBuffType(8)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MAXHPGENPCT                       = ConvertNonStackingStatBuffType(9)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MPGEN                             = ConvertNonStackingStatBuffType(10)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MPGENPCT                          = ConvertNonStackingStatBuffType(11)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MAXMPGENPCT                       = ConvertNonStackingStatBuffType(12)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MVSPD                             = ConvertNonStackingStatBuffType(13)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MVSPDPCT                          = ConvertNonStackingStatBuffType(14)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_HPSTEAL                           = ConvertNonStackingStatBuffType(15)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_THORNS                            = ConvertNonStackingStatBuffType(16)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_THORNSPCT                         = ConvertNonStackingStatBuffType(17)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MAXHP                             = ConvertNonStackingStatBuffType(18)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MAXHPPCT                          = ConvertNonStackingStatBuffType(19)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MAXMP                             = ConvertNonStackingStatBuffType(20)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_MAXMPPCT                          = ConvertNonStackingStatBuffType(21)
    // These are for parsing
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_ALLATK                            = ConvertNonStackingStatBuffType(22)
    constant nonstackingstatbufftype NON_STACKING_STAT_BUFF_TYPE_ALLATKPCT                         = ConvertNonStackingStatBuffType(23)
    
    constant datafieldletter DATA_FIELD_LETTER_A                                 = ConvertDataFieldLetter(0)
    constant datafieldletter DATA_FIELD_LETTER_B                                 = ConvertDataFieldLetter(1)
    constant datafieldletter DATA_FIELD_LETTER_C                                 = ConvertDataFieldLetter(2)
    constant datafieldletter DATA_FIELD_LETTER_D                                 = ConvertDataFieldLetter(3)
    constant datafieldletter DATA_FIELD_LETTER_E                                 = ConvertDataFieldLetter(4)
    constant datafieldletter DATA_FIELD_LETTER_F                                 = ConvertDataFieldLetter(5)
    constant datafieldletter DATA_FIELD_LETTER_G                                 = ConvertDataFieldLetter(6)
    constant datafieldletter DATA_FIELD_LETTER_H                                 = ConvertDataFieldLetter(7)
    constant datafieldletter DATA_FIELD_LETTER_I                                 = ConvertDataFieldLetter(8)
    constant datafieldletter DATA_FIELD_LETTER_J                                 = ConvertDataFieldLetter(9)
endglobals

//=================================================================================================
// Ability "user data" API (DEPRECATED)
//=================================================================================================
// used for just storing to a hashtable built into the ability, basically
// (maybe later we replace it with direct use of jass hashtables)
// TOTALLY SUPERCEDED BY LOCAL STORE API, THEY READ AND WRITE TO THE SAME STUFF
// AND THESE MIGHT BE REMOVED IN FAVOR OF GetAbilityLocalStore
native GetAbilityUserDataString takes ability whichAbility, string childKey returns string
native GetAbilityUserDataInteger takes ability whichAbility, string childKey returns integer
native GetAbilityUserDataBoolean takes ability whichAbility, string childKey returns boolean
native GetAbilityUserDataAbilityTypeLevelDataHandle takes ability whichAbility, string childKey returns abilitytypeleveldata
native GetAbilityUserDataAbilityHandle takes ability whichAbility, string childKey returns ability
native GetAbilityUserDataUnitHandle takes ability whichAbility, string childKey returns unit
native GetAbilityUserDataDestructableHandle takes ability whichAbility, string childKey returns destructable
native GetAbilityUserDataDestructableBuffHandle takes ability whichAbility, string childKey returns destructablebuff

// setters: return true if there was some previous value stored at the child key
native SetAbilityUserDataString takes ability whichAbility, string childKey, string value returns boolean
native SetAbilityUserDataInteger takes ability whichAbility, string childKey, integer value returns boolean
native SetAbilityUserDataBoolean takes ability whichAbility, string childKey, boolean value returns boolean
native SetAbilityUserDataAbilityTypeLevelDataHandle takes ability whichAbility, string childKey, abilitytypeleveldata value returns boolean
native SetAbilityUserDataAbilityHandle takes ability whichAbility, string childKey, ability value returns boolean
native SetAbilityUserDataUnitHandle takes ability whichAbility, string childKey, unit value returns boolean
native SetAbilityUserDataDestructableHandle takes ability whichAbility, string childKey, destructable value returns boolean
native SetAbilityUserDataDestructableBuffHandle takes ability whichAbility, string childKey, destructablebuff value returns boolean

native HasAbilityUserData takes ability whichAbility, string childKey returns boolean

native FlushParentAbilityUserData takes ability whichAbility returns nothing
native FlushChildAbilityUserData takes ability whichAbility, string childKey returns boolean

//=================================================================================================
// Local Store API
//=================================================================================================
// one dimensional (smaller) hashtables

native CreateLocalStore takes nothing returns localstore

native GetLocalStoreString takes localstore whichLocalStore, string childKey returns string
// NOTE: there's some wonk in the json; it does a Warsmash thing and stores 'A000' and 97
// as two different "kinds" of things. One is called War3ID and the other is called Integer.
// At the moment "native GetLocalStoreInteger" has special handling, so if you try to look
// up something of type War3ID on the jass side it will normalize this against integer,
// and all will be the integer type, for consistency with jass. SetLocalStoreInteger
// does not have the special handling at the time of writing, so this may impede your
// ability to overwrite system values if they are required to be of type War3ID
native GetLocalStoreInteger takes localstore whichLocalStore, string childKey returns integer
native GetLocalStoreBoolean takes localstore whichLocalStore, string childKey returns boolean
native GetLocalStoreReal takes localstore whichLocalStore, string childKey returns real
native GetLocalStoreAbilityTypeLevelDataHandle takes localstore whichLocalStore, string childKey returns abilitytypeleveldata
native GetLocalStoreAbilityHandle takes localstore whichLocalStore, string childKey returns ability
native GetLocalStoreBuffHandle takes localstore whichLocalStore, string childKey returns buff
native GetLocalStoreUnitHandle takes localstore whichLocalStore, string childKey returns unit
native GetLocalStoreDestructableHandle takes localstore whichLocalStore, string childKey returns destructable
native GetLocalStoreDestructableBuffHandle takes localstore whichLocalStore, string childKey returns destructablebuff
native GetLocalStoreABTimeOfDayEventHandle takes localstore whichLocalStore, string childKey returns abtimeofdayevent
native GetLocalStoreGameObjectHandle takes localstore whichLocalStore, string childKey returns gameobject
native GetLocalStoreNonStackingStatBuffHandle takes localstore whichLocalStore, string childKey returns nonstackingstatbuff
native GetLocalStoreProjectileHandle takes localstore whichLocalStore, string childKey returns projectile

// setters: return true if there was some previous value stored at the child key
native SetLocalStoreString takes localstore whichLocalStore, string childKey, string value returns boolean
native SetLocalStoreInteger takes localstore whichLocalStore, string childKey, integer value returns boolean
native SetLocalStoreBoolean takes localstore whichLocalStore, string childKey, boolean value returns boolean
native SetLocalStoreReal takes localstore whichLocalStore, string childKey, real value returns boolean
native SetLocalStoreAbilityTypeLevelDataHandle takes localstore whichLocalStore, string childKey, abilitytypeleveldata value returns boolean
native SetLocalStoreAbilityHandle takes localstore whichLocalStore, string childKey, ability value returns boolean
native SetLocalStoreBuffHandle takes localstore whichLocalStore, string childKey, buff value returns boolean
native SetLocalStoreUnitHandle takes localstore whichLocalStore, string childKey, unit value returns boolean
native SetLocalStoreDestructableHandle takes localstore whichLocalStore, string childKey, destructable value returns boolean
native SetLocalStoreDestructableBuffHandle takes localstore whichLocalStore, string childKey, destructablebuff value returns boolean
native SetLocalStoreABTimeOfDayEventHandle takes localstore whichLocalStore, string childKey, abtimeofdayevent value returns boolean
native SetLocalStoreGameObjectHandle takes localstore whichLocalStore, string childKey, gameobject value returns boolean
native SetLocalStoreNonStackingStatBuffHandle takes localstore whichLocalStore, string childKey, nonstackingstatbuff value returns boolean
native SetLocalStoreProjectileHandle takes localstore whichLocalStore, string childKey, projectile value returns boolean
native SetLocalStoreHandle takes localstore whichLocalStore, string childKey, handle value returns boolean

native LocalStoreContainsKey takes localstore whichLocalStore, string childKey returns boolean

native FlushParentLocalStore takes localstore whichLocalStore returns nothing
native FlushChildLocalStore takes localstore whichLocalStore, string childKey returns boolean

// this native is the same as calling FlushChildLocalStore on every key in the store whose
// key name ends with `"#" + I2S(castId)`
native LocalStoreCleanUpCastInstance takes localstore whichLocalStore, integer castId returns nothing

// NOTE: only works on abilities defined by Ability Builder. At the moment, hard-coded engine abilities
// dont have this
native GetAbilityLocalStore takes ability whichAbility returns localstore

// Returns the local store for the casted ability thing (or other active Ability Builder callback)
native GetTriggerLocalStore takes nothing returns localstore

// NOTE: java does not use destroy functions, this was kept for consistency with war3 stuff
// but at the moment it is identical to FlushParentLocalStore to help you with performance
native DestroyLocalStore takes localstore whichStore returns nothing

//=================================================================================================
// GameObject API
//=================================================================================================
// These are the state store that contains information loaded from SLK or INI "profile"

// For general use I added a native "GetGameObjectById" that takes worldeditordatatype
// and id, so we could for example say
//   local gameobject paladinData = GetGameObjectById(WORLD_EDITOR_DATA_TYPE_UNITS, 'Hpal')
//   local string name = GetGameObjectFieldAsString(paladinData, "Name", 0) // returns "Paladin"
//   local string properName1 = GetGameObjectFieldAsString(paladinData, "Propernames", 0) // returns "Granis Darkhammer"
//   local string properName2 = GetGameObjectFieldAsString(paladinData, "Propernames", 1) // returns "Jorn the Redeemer"
//
// ... however at the time of writing, GetGameObjectById is not getting used in existing code.
// Intead of it, the AbilityBuilder uses GetLocalStoreGameObjectHandle in combination
// with the hardcoded key "_abilityEditorData" to get the game object for the active ability,
// which is populated inside the engine automatically rather than being set from JASS/json.

native GetGameObjectFieldAsString takes gameobject editorData, string key, integer index returns string
native GetGameObjectFieldAsInteger takes gameobject editorData, string key, integer index returns integer
native GetGameObjectFieldAsReal takes gameobject editorData, string key, integer index returns real
native GetGameObjectFieldAsBoolean takes gameobject editorData, string key, integer index returns boolean

native GetGameObjectById takes worldeditordatatype whichDataType, integer aliasId returns gameobject

//=================================================================================================
// AbilityBuilderConfiguration API
//=================================================================================================
// Defines stuff for the "kind" of ability, such as in object editor

// Create a configuration that can be assigned to an ability to describe what it
// does if given to a unit.
native CreateAbilityBuilderConfiguration takes nothing returns abilitybuilderconfiguration

// Sets the Base Order ID
native SetABConfCastId takes abilitybuilderconfiguration abc, string castId returns nothing

// Sets the Base Order ID (turn off)
native SetABConfUcastId takes abilitybuilderconfiguration abc, string castId returns nothing

// Sets the Base Order ID for Auto Cast On
native SetABConfAutoCastOnId takes abilitybuilderconfiguration abc, string castId returns nothing

// Sets the Base Order ID for Auto Cast Off
native SetABConfAutoCastOffId takes abilitybuilderconfiguration abc, string castId returns nothing

// Sets the type of autocast available to the ability
native SetABConfAutoCastType takes abilitybuilderconfiguration abc, autocasttype whichType returns nothing

// Sets the type of ability to configure/create... See AB_CONF_TYPE_XYZ constants.
native SetABConfType takes abilitybuilderconfiguration abc, abconftype whichType returns nothing

native AddABConfAddAbilityAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfAddDisabledAbilityAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfRemoveAbilityAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfRemoveDisabledAbilityAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfDeathPreCastAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfCancelPreCastAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfOrderIssuedAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfActivateAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfDeactivateAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfLevelChangeAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfBeginCastingAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfEndCastingAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfChannelTickAction takes abilitybuilderconfiguration abc, code func returns nothing
native AddABConfEndChannelAction takes abilitybuilderconfiguration abc, code func returns nothing

// Register this Ability Builder Configuration with the ability subsystem!! Now any unit
// with an ability who inherits from this rawcode will have the configured code used for
// that ability!
native RegisterABConf takes integer codeId, abilitybuilderconfiguration abc returns nothing

//=================================================================================================
// Ability API (general stuff)
//=================================================================================================

// These do the same thing as similar Blz functions if user simulation includes newer patch,
// but are distinct because our simulation will include them regardless of patch version
native GetUnitAbility takes unit whichUnit, integer whichAbilityId returns ability
native GetUnitAbilityByIndex takes unit whichUnit, integer index returns ability

// Unlike "UnitAddAbility" for the rawcode based ones, this uses reversed name "AddUnitAbility"
// which staples an existing ability handle onto a unit. Maybe we could rename it
// to "UnitAddAbilityHandle" if this ends up too confusing in the future
native AddUnitAbility takes unit whichUnit, ability whichAbility returns nothing

// same idea here, see comment on AddUnitAbility. Returns true if something was removed.
native RemoveUnitAbility takes unit whichUnit, ability whichAbiilty returns nothing

native GetAbilityAliasId takes ability whichAbility returns integer
native GetAbilityCodeId takes ability whichAbility returns integer

// might be the same as BlzUnitHideAbility, but this one is for ability handles
native SetAbilityIconShowing takes ability whichAbility, boolean showing returns nothing

//=================================================================================================
// AbilityBuilderAbility API
//=================================================================================================
// Stuff to deal with abilities. Takes an ability handle, but that handle needs to be
// an ability defined with Ability Builder tools. If it's some other type of ability, 
// these natives won't work.

// Does the same thing as BlzEndUnitAbilityCooldown if user simulation includes newer patch
native EndUnitAbilityCooldown takes unit whichUnit, integer whichAbilityId returns nothing

// This is meant to be the same as EndUnitAbilityCooldown but you can use it on an ability handle
// --- there's some kind of special handling so that it uses the Cooldown Group of items
// --- (which seems busted and should be automatic either way? maybe? shouldn't Inventory ability handle that?)
native EndAbilityCooldown takes unit caster, ability whichAbility returns nothing

// Does the same thing as BlzStartUnitAbilityCooldown if user simulation includes newer patch
native StartUnitAbilityCooldown takes unit whichUnit, integer whichAbilityId, real cooldown returns nothing

// Below: uses the cooldown setting of the ability (should include level, etc)
native StartUnitAbilityDefaultCooldown takes unit whichUnit, integer whichAbilityId returns nothing

// This is meant to be the same as StartUnitAbilityCooldown but you can use it on an ability handle
// --- there's some kind of special handling so that it uses the Cooldown Group of items
// --- (which seems busted and should be automatic either way? maybe? shouldn't Inventory ability handle that?)
//native StartAbilityCooldown takes unit caster, ability whichAbility, real cooldown returns nothing

// Below: uses the cooldown setting of the ability (should include level, etc)
native StartAbilityDefaultCooldown takes unit caster, ability whichAbility returns nothing

// NOTE: above notes are not quite correct... seems "End" cooldown functions are handling the item case
// but only "start default" are handling item case... start (non-default) is passing thru rawcode
// and would skip past item cooldown group, item ignore cooldown setting, etc

// ===== Event Response =====

// Returns a magic number for the spell cast... Basically if I cast store bolt on a peasant,
// then cast storm bolt on a peon, the peasant's cast gets CastId 1 and the peon gets CastId 2
// or something. It is stored on buffs in some cases.
native GetTriggerCastId takes nothing returns integer

// Gets the item that created the ability for the unit.
// NOTE from Retera: is this a hack? shouldn't that probably be handled automatically?
native GetAbilityItem takes ability whichAbility returns item

//=================================================================================================
// AbilityBuilderActiveAbility API
//=================================================================================================
// Similar to natives in AbilityBuilderAbility API section, these only work on abilities
// defined with the Ability Builder tools. But as an additional requirement,
// the ability is required to be an Active ability. Otherwise will cause crash or not work.

// below: use on toggleable abilities; they return true if it wasn't already in that state and toggle was
// a success.
// (You have to provide the Caster because of dumb engine design,
// which can't look it up for you. Thanks, Retera!)
native AbilityActivate takes unit caster, ability whichAbility returns boolean
native AbilityDeactivate takes unit caster, ability whichAbility returns boolean

// NOTE: maybe eventually this could be replaced by BlzSetAbilityRealLevelField(whichAbility, ABILITY_RLF_CAST_RANGE, 0, value)
// but at the moment it is not the same, because it sets the cast range independent of level
// (the one that is actually used rather than an editor stat, which would change on skill level up)
native SetAbilityCastRange takes ability whichAbility, real range returns nothing

//=================================================================================================
// Projectile API
//=================================================================================================
// Shoot projectiles using the built in engine to do so

// the first 3 args are used as Event Response when triggering the "code" func handlers
native CreateLocationTargetedCollisionProjectile takes unit casterUnit, localstore sourceAbility, integer castId, unit sourceUnit, location sourceLocation, location target, integer projectileId, real speed, boolean homing, code onLaunch, code onPreHits, boolexpr canHitTarget, code onHit, integer maxHits, integer hitsPerTarget, real startingRadius, real endingRadius, real collisionInterval, boolean provideCounts returns projectile

native CreateLocationTargetedProjectile takes unit casterUnit, localstore sourceAbility, integer castId, unit sourceUnit, location sourceLocation, location target, integer projectileId, real speed, boolean homing, code onLaunch, code onHit returns projectile

// I think this native creates the Impale effect, via a repeating delayed line of special effects spawned.
// So I assume the repeating effects spawned have collision against units they hit.
native CreateLocationTargetedPseudoProjectile takes unit casterUnit, localstore sourceAbility, integer castId, unit sourceUnit, location sourceLocation, location target, integer projectileId, effecttype whichEffectType, integer effectArtIndex, real speed, boolean homing, code onLaunch, code onPreHits, boolexpr canHitTarget, code onHit, integer maxHits, integer hitsPerTarget, real startingRadius, real endingRadius, real projectileStepInterval, integer projectileArtSkip, boolean provideCounts returns projectile

native CreateUnitTargetedCollisionProjectile takes unit casterUnit, localstore sourceAbility, integer castId, unit sourceUnit, location sourceLocation, unit target, integer projectileId, real speed, boolean homing, code onLaunch, code onPreHits, boolexpr canHitTarget, code onHit, integer maxHits, integer hitsPerTarget, real startingRadius, real endingRadius, real collisionInterval, boolean provideCounts returns projectile

native CreateUnitTargetedProjectile takes unit casterUnit, localstore sourceAbility, integer castId, unit sourceUnit, location sourceLocation, unit targetUnit, integer projectileId, real speed, boolean homing, code onLaunch, code onHit returns projectile

// See "CreateLocationTargetedPseudoProjectile" but this one chases a unit (?)
native CreateUnitTargetedPseudoProjectile takes unit casterUnit, localstore sourceAbility, integer castId, unit sourceUnit, location sourceLocation, unit target, integer projectileId, effecttype whichEffectType, integer effectArtIndex, real speed, boolean homing, code onLaunch, code onPreHits, boolexpr canHitTarget, code onHit, integer maxHits, integer hitsPerTarget, real startingRadius, real endingRadius, real projectileStepInterval, integer projectileArtSkip, boolean provideCounts returns projectile

native SetAttackProjectileDamage takes projectile whichAttackProjectile, real damage returns nothing
native SetProjectileDone takes projectile whichProjectile, boolean done returns nothing
native SetProjectileReflected takes projectile whichProjectile, boolean reflected returns nothing
native SetProjectileTargetUnit takes projectile whichProjectile, unit target returns nothing
native SetProjectileTargetLoc takes projectile whichProjectile, location target returns nothing

//=================================================================================================
// Buff API
//=================================================================================================
// Like War3, buffs are abilities. GetUnitAbilityLevel(...) with some Buff ID should still work.
// But this API is to provide the other needed functions.'
// --- This also means stuff like GetAbilityCodeId and GetAbilityAliasId might work on Buffs (?)

// TODO what does this native do?
native AddUnitNonStackingDisplayBuff takes unit target, string stackingKey, buff whichBuff returns nothing

// TODO what happens if you remove a buff with RemoveAbility natives?? seems broken...
// For now, I guess if you add it with "add non stacking display buff" then you have to
// remove it with this function, or else memory leaks stacking key stuff and you break the system
native RemoveUnitNonStackingDisplayBuff takes unit target, string stackingKey, buff whichBuff returns nothing

// NOTE: full function of the json native moved to CreatePassiveBuffAU
// NOTE: sourceAbilLocalStore will be used as GetTriggerLocalStore() in the on add/remove actions
// NOTE: castId will be used as GetTriggerCastId() in the on add/remove actions
native CreatePassiveBuff takes integer buffId, boolean showIcon, code onAddAction, code onRemoveAction, effecttype artType, boolean showFx, boolean playSfx, localstore sourceAbilLocalStore, integer castId returns buff

// see CreateTargetingBuffAU
native CreateTargetingBuff takes integer buffId returns buff

// see CreateTimedArtBuffAU
native CreateTimedArtBuff takes integer buffId, real duration, boolean showIcon, effecttype artType returns buff

// see CreateTimedBuffAU
native CreateTimedBuff takes integer buffId, real duration, boolean showTimedLifeBar, code onAddAction, code onRemoveAction, code onExpireAction, boolean showIcon, effecttype artType, localstore sourceAbilLocalStore, integer castId returns buff

// see CreateTimedLifeBuffAU
native CreateTimedLifeBuff takes integer buffId, real duration, boolean explode returns buff

// see CreateTimedTargetingBuffAU
native CreateTimedTargetingBuff takes integer buffId, real duration returns buff

// see CreateTimedTickingBuffAU
native CreateTimedTickingBuff takes integer buffId, real duration, boolean showTimedLifeBar, code onAddAction, code onRemoveAction, code onExpireAction, code onTickAction, boolean showIcon, effecttype artType, localstore sourceAbilLocalStore, integer castId returns buff

// see CreateTimedTickingPausedBuffAU
native CreateTimedTickingPausedBuff takes integer buffId, real duration, boolean showTimedLifeBar, code onAddAction, code onRemoveAction, code onExpireAction, code onTickAction, boolean showIcon, effecttype artType, localstore sourceAbilLocalStore, integer castId returns buff

// see CreateTimedTickingPostDeathBuffAU
native CreateTimedTickingPostDeathBuff takes integer buffId, real duration, boolean showTimedLifeBar, code onAddAction, code onRemoveAction, code onExpireAction, code onTickAction, boolean showIcon, effecttype artType, localstore sourceAbilLocalStore, integer castId returns buff


//=================================================================================================
// DestructableBuff API
//=================================================================================================
// NOTE from Retera: idk the details on this. Just trying to expose the system
// to match Glasir json AbilityBuilder so its available in the Jass for now.

native AddDestructableBuff takes destructable target, destructablebuff whichBuff returns nothing

native RemoveDestructableBuff takes destructable target, destructablebuff whichBuff returns nothing

native CreateDestructableBuff takes unit casterUnit, integer buffId, integer level, localstore sourceAbilLocalStore, code onAddAction, code onRemoveAction, code onDeathAction, integer castId returns destructablebuff


//=================================================================================================
// Event API
//=================================================================================================
// Trigger events implemented for ability builder... Where possible, it's probably better to just
// literally use events from common.j instead. These are here for the purpose of 1:1 port from
// json, which used its own natives that include additional scoping, such as the passing of
// the localStore into the event actions by default.

native CreateABTimeOfDayEvent takes code actions, real startTime, real endTime, string equalityId, unit caster, localstore localStore, integer castId returns abtimeofdayevent

// links the event to game engine to fire... by default it is not hooked up
native RegisterABTimeOfDayEvent takes abtimeofdayevent whichEvt returns nothing

// links the event to the game engine to fire... but only if you didn't already link it up
native RegisterUniqueABTimeOfDayEvent takes abtimeofdayevent whichEvt returns nothing

// makes event stop firing (opposite of register)
native UnregisterABTimeOfDayEvent takes abtimeofdayevent whichEvt returns nothing

//=================================================================================================
// Floating Text API
//=================================================================================================

// Warsmash was originally centering these. tried to turn it off when I was attempting
// to match common.j stuff, but here you could turn it back on if you want
native SetTextTagCentered takes texttag t, boolean flag returns nothing

// Unlike CreateTextTag, this CreateTextTagFromConfig function will default all the stats of the text
// tag based on a texttagconfigtype. Also in the future it might handle fog of war on text tag
// for the source unit (pretty sure common.j text tags don't allow that feature)
// At the moment these are expected to become desync prone if used in net code, so GetHandleId(t)
// on a text tag "t" created with this native will always return -1, these do not add to the count,
// and are intended to possibly exist in local client code. But "SetTextTag<Thing>" from common.j should
// work on them.
native CreateTextTagFromConfig takes unit sourceUnit, texttagconfigtype whichConfigType, string whatString returns texttag

// below: this is probably dumb and we could probably use "CreateTextTagFromConfig" instead.
// Retera's fault. Forget why this is here. It literally adds + or - prefix to number in text
native CreateIntTextTagFromConfig takes unit sourceUnit, texttagconfigtype whichConfigType, integer whatNumber returns texttag

//=================================================================================================
// Game State
//=================================================================================================

// this is the Moonstone ability effect. It makes the clock purple or yellow
native SetFalseTimeOfDay takes integer hour, integer minute, real duration returns nothing

// Returns an ever-increasing number to indicate the "turn" that the game is on.
// There are roughly 20 turns per second, unless someone changes the emulator constants.
native GetGameTurnTick takes nothing returns integer

// Returns the number of seconds between each game turn tick (probably 0.05)
constant native GetSimulationStepTime takes nothing returns real

//=================================================================================================
// Item API
//=================================================================================================

// returns the Rune of Rebirth unit ID, which there is a common.j native to set but not to get!
native GetItemDropID takes item whichItem returns integer

// returns true if the item type is perishable. NOTE: why do we need this(?)
native IsItemIdPerishable takes integer itemId returns boolean

//=================================================================================================
// Unit API
//=================================================================================================

// might fire some code, might return false if you're blocked by spell shield, etc
native CheckUnitForAbilityEffectReaction takes unit target, unit caster, ability whichAbility returns boolean

// similar to the above, but allows for Defend to actually reflect the projectile or something
native CheckUnitForAbilityProjReaction takes unit target, unit caster, projectile whichProjectile returns boolean

// NOTE: Percents dont work in the ability builder json "AddDefenseBonus"
// according to a comment, so they might not be working
// in the jass binding either. Maybe just use "BlzGetUnitArmor" for the base?
// (NOTE: in addition to the above comment, "BlzGetUnitArmor" has been provided in Warsmash so it should function)
// NOTE: This adds or subtracts from the GREEN number (+1.5) not the base.
//native UnitAddDefenseBonus takes unit targetUnit, real defenseValue, boolean percentage returns nothing
native UnitAddDefenseBonus takes unit targetUnit, real defenseValue returns nothing

// green numbers
native UnitSetTemporaryDefenseBonus takes unit targetUnit, real defenseValue returns nothing
native UnitGetTemporaryDefenseBonus takes unit targetUnit returns real

// As with any Blz native, using them would cause Warsmash to stop working on patches < 1.32, so here is a
// non-blz binding to get the defense of a unit. "BlzGetUnitArmor" reroutes to this.
native GetUnitDefense takes unit whichUnit returns real

// This could have been written as a function instead of a native, but then that way it would
// have to be maintained. This one is just reading the java variables, so if somebody
// adds a damage type then this native updates likewise basically. Not sure why it
// needs to exist, though; where possible, replace with references to DAMAGE_TYPE_FORCE
// and friends (native ConvertDamageType)
native String2DamageType takes string x returns damagetype

//=================================================================================================
// Non Stacking Stat Buff API
//=================================================================================================
// These are not buffs. They appear to be stat modifiers, but scoped on a name.
// So I assume that if you `CreateNonStackingStatBuff(NON_STACKING_STAT_BUFF_TYPE_DEF, "My Devotion Aura Thing", 10)`
// and also `CreateNonStackingStatBuff(NON_STACKING_STAT_BUFF_TYPE_DEF, "My Devotion Aura Thing", 12)` and
// add them together on a unit, since they are non stacking I'm guessing this means the unit would gain a total of 12
// and not 22 defense, because they were both applied by "My Devotion Aura Thing"??
native CreateNonStackingStatBuff takes nonstackingstatbufftype whichType, string stackingKey, real value returns nonstackingstatbuff

native AddUnitNonStackingStatBuff takes unit targetUnit, nonstackingstatbuff whichBuff returns nothing

native RemoveUnitNonStackingStatBuff takes unit targetUnit, nonstackingstatbuff whichBuff returns nothing

native RecomputeStatBuffsOnUnit takes unit targetUnit, nonstackingstatbufftype whichBuffType returns nothing

// NOTE: seems like, if you call `UpdateNonStackingStatBuff`, you probably also have to call `RecomputeStatBuffsOnUnit`,
// otherwise you update some invisible thing without applying it to the unit.
native UpdateNonStackingStatBuff takes nonstackingstatbuff whichBuff, real value returns nothing

// See "String2DamageType" for notes on how "String2Thing" native is probably not good, and you
// should probably use NON_STACKING_STAT_BUFF_TYPE_MVSPDPCT values
native String2NonStackingStatBuffType takes string x returns nonstackingstatbufftype

//=================================================================================================
// Code API
//=================================================================================================

// redeclaration of native from common.ai, so that we can run a code func such as for ability
native StartThread takes code func returns nothing

// runs the code func, but where:
// -  GetTriggerUnit()/GetSpellAbilityUnit() return the passed in unit
// -  GetTriggerLocalStore() returns the passed in local store
// -  GetTriggerCastId() returns the passed in cast id
native StartAbilityBuilderThread takes code func, unit spellAbilityUnit, localstore triggerLocalStore, integer triggerCastId returns nothing


//=================================================================================================
// AbilityTypeLevelData API
//=================================================================================================
// This is exposed to the AbilityBuilder for some reason. At a glance, it looks like whatever
// ability might be using these is probably broken, not MUI, and in need of fix. Worth testing.
// For now the API is provided in order to achieve 1:1 parity with JSON AbilityBuilder code.
native AbilityTypeLevelDataAddTargetAllowed takes abilitytypeleveldata whichData, integer level, targettype whichType returns nothing
native AbilityTypeLevelDataRemoveTargetAllowed takes abilitytypeleveldata whichData, integer level, targettype whichType returns nothing

// okay, maybe these function(s) below make a little more sense and are less broken than non MUI editing
// of targets allowed (still probably better to use GameObject API though):
native GetAbilityTypeLevelDataReal takes abilitytypeleveldata whichData, integer level, datafieldletter whichLetter returns real

// NOTE: Regarding Warsmash development history, originally "type level data" here was created
// as a high performance cache of data parsed by the GameObject api, so my note about how it is
// "better to use GameObject API" would have been false because it would have been worse
// performance. However, those types of micro optimizations become pointless when everything
// is defined in user space. Even in the json ability builder, the equivalent to
// "native GetAbilityTypeLevelDataReal" is doing float parsing of a string every time
// that we query the value off of it. The idea that program variables are holding
// the ability parameters for each level in a symbol table ("class") instead of
// as strings in a property map is already lost. So, just do whatever you want.
// It doesn't matter anymore, and "type level data" was too confusing to teach to
// anyone anyway, and too time consuming to implement abilities for. It's a similar
// reason to why the outside sees "ABILITY_RLF_CASTING_TIME = ConvertAbilityRealLevelField('acas')"
// as this overcomplex nonsense on Reforged, whereas a World Editor user might advocate he should
// have a native "SetAbilityDataReal" so that he can just call it on "Cast1" or "Cast2", the
// casting time fields from world editor. He is completely estranged from how performance
// is achieved in professional software, and has no access to the necessary information
// nor any way to apply the information on Warcraft 3 if he had it, so it is most
// likely the case that to even try is a fool's errand and we may as well simply
// do our best writing whatever code is fun to write with what limited time
// is given to us in life -- thus the "AbilitySpellBase" classes in Java, and my
// video making Cluster Rockets in only an hour on YouTube, when I realized that
// no one cares, it's all a waste of time to have done that, and it's fun to just
// query GameObject once when the ability is created or levels up, even though
// calling to a giant property map like that is worse performance. It just
// doesn't matter. And likewise does ability builder call to something that
// re-parses strings to floats just to get a floating point data field at runtime

// returns 'B000' or whatever from `Stats - Buffs` in object editor; if multiple comma separated values,
// it returns the first one.
native GetAbilityTypeLevelDataFirstBuffId takes abilitytypeleveldata whichData, integer level returns integer

native GetAbilityTypeLevelDataDurationNormal takes abilitytypeleveldata whichData, integer level returns real
native GetAbilityTypeLevelDataDurationHero takes abilitytypeleveldata whichData, integer level returns real
native GetAbilityTypeLevelDataCastTime takes abilitytypeleveldata whichData, integer level returns real


//=================================================================================================
// Extra
//=================================================================================================
// these were already in the underlying system, exposed now because why not

// returns the name of the Warsmash Java code class in use by the given ability... probably only 
// useful for some hackery
native WarsmashGetAbilityClassName takes ability whichAbility returns string

// WarsmashGetRawcode2String('AHtb') == "AHtb"
native WarsmashGetRawcode2String takes integer rawcode returns string
