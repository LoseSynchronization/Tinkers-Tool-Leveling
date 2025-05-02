package net.redfox.tleveling.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TinkersLevelingCommonConfigs {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Double> PICKAXE_EXP_MULTIPLIER;
	public static final ForgeConfigSpec.ConfigValue<Double> KILL_EXP_MULTIPLIER;
	public static final ForgeConfigSpec.ConfigValue<Double> ARMOR_EXP_MULTIPLIER;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ADMIN_MINING_EXP;
	public static final ForgeConfigSpec.ConfigValue<Integer> LEVELUP_EXP_REQUIRED;

	public static final ForgeConfigSpec.ConfigValue<Integer> LEVEL_BONUS_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Integer> MAX_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double>  LEVELUP_EXP_MULTIPLIER;

	static {
		BUILDER.push("Client Configs for Tinker's Tool Leveling 2");

		PICKAXE_EXP_MULTIPLIER = BUILDER.comment("The multiplier for the exp granted to a mining tool after each block break. Default is 1.0")
				.define("Exp Per Block", 1.0d);
		KILL_EXP_MULTIPLIER = BUILDER.comment("The multiplier for the exp granted to a melee weapon after each block break. Default is 1.0")
				.define("Exp Per Melee Kill", 1.0d);
		ARMOR_EXP_MULTIPLIER = BUILDER.comment("The multiplier for the exp granted to an armor piece after each block break. Default is 1.0")
				.define("Exp Per Armor Hit", 1.0d);
		ADMIN_MINING_EXP = BUILDER.comment("Whether or not breaking bedrock gives 100,000 exp for a mining tool. Primarily used for admin purposes. Default is true")
				.define("Admin Exp", true);
		LEVEL_BONUS_MODIFIER = BUILDER.comment("The amount of levels between each bonus modifier. Set to 0 to disable bonus modifiers. Default is 3")
				.defineInRange("Levels Between Bonus Modifiers", 3, 0, 2147483647);
		LEVELUP_EXP_REQUIRED = BUILDER.comment("The base exp required to level up a tool. Default is 500")
				.defineInRange("Exp Required", 500, 1, 2147483647);
		MAX_LEVEL = BUILDER.comment("Max level for your tools. Not get new modifier if you had all available modifiers when level up, bonus modifiers are not affected. Default is 11")
				.defineInRange("Max Level", 11, 1, 100000);
		LEVELUP_EXP_MULTIPLIER = BUILDER.comment("The multiplier of required exp after each level up. Default is 2.5")
				.defineInRange("Level Up Exp Multiplier", 2.5d, 1d, 10000d);

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
