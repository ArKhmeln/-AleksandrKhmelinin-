package hw6.enums;

public enum LogTexts {

    WATER_TRUE("Water: condition changed to true"),
    WIND_TRUE("Wind: condition changed to true"),
    METAL_SELEN("metal: value changed to Selen"),
    COLORS_YELLOW("Colors: value changed to Yellow"),
    WATER_FALSE("Water: condition changed to false"),
    WIND_FALSE("Wind: condition changed to false"),
    VIP_TRUE("Vip: condition changed to true");

    final String text;

    LogTexts(String name) {
        this.text = name;
    }

    public String getText() {
        return text;
    }
}