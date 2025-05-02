package net.redfox.tleveling.leveling;

import com.google.common.collect.*;
import net.minecraft.network.chat.Component;
import net.redfox.tleveling.config.*;

import java.util.*;

public class ToolLevel {
	public static final ToolLevel LIKE_NEW = new ToolLevel(0, "Like New", "like_new");
	public static final ToolLevel CLUMSY = new ToolLevel(1, "Clumsy", "clumsy");
	public static final ToolLevel COMFORTABLE = new ToolLevel(2, "Comfortable", "comfortable");
	public static final ToolLevel ACCUSTOMED = new ToolLevel(3, "Accustomed", "accustomed");
	public static final ToolLevel ADEPT = new ToolLevel(4, "Adept", "adept");
	public static final ToolLevel EXPERT = new ToolLevel(5, "Expert", "expert");
	public static final ToolLevel MASTER = new ToolLevel(6, "Master", "master");
	public static final ToolLevel GRANDMASTER = new ToolLevel(7, "Grandmaster", "grandmaster");
	public static final ToolLevel HEROIC = new ToolLevel(8, "Heroic", "heroic");
	public static final ToolLevel LEGENDARY = new ToolLevel(9, "Legendary", "legendary");
	public static final ToolLevel GODLIKE = new ToolLevel(10, "Godlike", "godlike");
	public static final ToolLevel AWESOME = new ToolLevel(11, "Awesome", "awesome");

	public static final String TOOL_LEVEL_NAME_BEYOND = "Transcendent";

	private static final List<ToolLevel> TOOL_LEVEL_LIST = Lists.newArrayList(LIKE_NEW, CLUMSY, COMFORTABLE, ACCUSTOMED, ADEPT, EXPERT, MASTER, GRANDMASTER, HEROIC, LEGENDARY, GODLIKE, AWESOME);

	private final int level;
	private final String name;
	private final String id;
	public ToolLevel(int ILevel, String IName, String IID) {
		this.level = ILevel;
		this.name = IName;
		this.id = IID;
	}
	public int getLevel() {
		return this.level;
	}
	public Component getMessage(Component toolName, boolean bonusModifier) {
		String id = this.getId();
		if(isMaxLevel() || getToolLevel(this.getLevel() + 1).isMaxLevel()){
			id = "maxlevel";
		}
		Component toolNameLiteral = Component.literal(toolName.getString().replace("[", "").replace("]", "")).withStyle(s->s.withColor(TooltipHandler.ORANGE));
		Component bonusModifierLiteral =Component.literal("");
		if (bonusModifier){
			bonusModifierLiteral = Component.literal("(+1 modifier)");
		}
		return Component.translatable("message.tleveling."+id, toolNameLiteral, bonusModifierLiteral).withStyle(s -> s.withColor(TooltipHandler.BLUE));
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}
	public boolean isMaxLevel() {
		return this.level >= TinkersLevelingCommonConfigs.MAX_LEVEL.get();
	}

	public static ToolLevel getToolLevel(int level){
		if (level < TOOL_LEVEL_LIST.size()){
			return TOOL_LEVEL_LIST.get(level);
		}else{
			ToolLevel newLevel = new ToolLevel(level, TOOL_LEVEL_NAME_BEYOND, TOOL_LEVEL_NAME_BEYOND.toLowerCase());
			TOOL_LEVEL_LIST.add(newLevel);
			return newLevel;
		}
	}
}
