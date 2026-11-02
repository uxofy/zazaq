package com.armorcolor;

import net.minecraft.item.ItemStack;

public class ArmorTint {
    /** Piece of armor currently being rendered (set by ArmorFeatureRendererMixin). */
    public static ItemStack current = ItemStack.EMPTY;

    /** Master switch, toggled with the keybind. */
    public static boolean enabled = true;

    /** Returns ARGB tint by durability, or 0 for "no tint". */
    public static int colorFor(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return 0;
        if (!stack.isDamageable()) return 0;
        int max = stack.getMaxDamage();
        if (max <= 0) return 0;
        float left = (max - stack.getDamage()) / (float) max;
        if (left > 0.70f) return 0xFF55FF55; // green
        if (left > 0.45f) return 0xFFFFFF55; // yellow
        if (left > 0.22f) return 0xFFFF9933; // orange
        return 0xFFFF3333;                   // red
    }
}
