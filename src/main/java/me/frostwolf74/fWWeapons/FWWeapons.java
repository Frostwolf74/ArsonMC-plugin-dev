package me.frostwolf74.fWWeapons;

import me.frostwolf74.fWWeapons.listeners.SwordUseListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class FWWeapons extends JavaPlugin implements Listener {
    private static FWWeapons plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("FWWeapons has been loaded");

        getServer().getPluginManager().registerEvents(new SwordUseListener(), this);

        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta swordMeta = sword.getItemMeta();

        List<Component> lore = new ArrayList<>();
        swordMeta.displayName(Component.text("Legendary Arson Sword", TextColor.color(255, 0 , 0), TextDecoration.BOLD));

        lore.add(0 ,Component.text("Blessed by the gods of Arson,"));
        lore.add(1 ,Component.text("strike fire upon your adversaries."));

        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);

        swordMeta.getPersistentDataContainer().set(new NamespacedKey(this, "isArsonSword"), PersistentDataType.BOOLEAN, true);

        swordMeta.lore(lore);
        sword.setItemMeta(swordMeta);

        ShapedRecipe swordRec = new ShapedRecipe(new NamespacedKey(this, "FWWeapons"), sword);
        swordRec.shape("$#$",
                       "%#%",
                       "@!@");
        swordRec.setIngredient('!', Material.STICK);
        swordRec.setIngredient('#', Material.IRON_INGOT);
        swordRec.setIngredient('$', Material.FIRE_CHARGE);
        swordRec.setIngredient('@', Material.END_CRYSTAL);
        swordRec.setIngredient('%', Material.LAVA_BUCKET);

        Bukkit.addRecipe(swordRec);
    }

    @Override
    public void onDisable(){
        getLogger().info("FWWeapons has been unloaded");
    }

    public static FWWeapons getPlugin() {
        return plugin;
    }
}
