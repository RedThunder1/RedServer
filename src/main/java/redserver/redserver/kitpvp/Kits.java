package redserver.redserver.kitpvp;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Kits {

    public static ArrayList<ItemStack> IronKit() {
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemStack food = new ItemStack(Material.COOKED_BEEF, 16);
        ArrayList<ItemStack> ironKit = new ArrayList<>();
        ironKit.add(helmet);
        ironKit.add(chestplate);
        ironKit.add(leggings);
        ironKit.add(boots);
        ironKit.add(sword);
        ironKit.add(food);
        return ironKit;
    }

    public static ArrayList<ItemStack> MedKit() {
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack food = new ItemStack(Material.COOKED_BEEF, 16);
        ArrayList<ItemStack> medKit = new ArrayList<>();
        medKit.add(helmet);
        medKit.add(chestplate);
        medKit.add(leggings);
        medKit.add(boots);
        medKit.add(sword);
        medKit.add(food);
        return medKit;
    }

}
