package net.redfox.tleveling.util;

import net.redfox.tleveling.config.TinkersLevelingCommonConfigs;

import java.text.DecimalFormat;

public class MathHandler {
	public static final DecimalFormat formatter = new DecimalFormat("#,###.##");
	public static int getRequiredExp(int level) {
		Double expMultiplier = TinkersLevelingCommonConfigs.LEVELUP_EXP_MULTIPLIER.get();
		Integer expRequired = TinkersLevelingCommonConfigs.LEVELUP_EXP_REQUIRED.get();
		return MathHandler.round(Math.pow(expMultiplier, level) * expRequired);
	}
	public static int round(double input) {
		return (int)Math.round(input);
	}
	public static double getUniformDecimal(double number) {
		return MathHandler.round(number*100)/100d;
	}
	public static String getUniformLongDecimal(double number) {
		return formatter.format(number);
	}
	public static double getUniformPercentage(double a, int b) { //This number is capped at two decimal points - do not store values with it!
		return getUniformDecimal((a/b)*100);
	}
}