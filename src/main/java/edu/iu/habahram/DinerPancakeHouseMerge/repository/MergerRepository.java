package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergerRepository {
    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        return Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
    }

    public List<MenuItemRecord> getVegetarianMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> vegetarianItems = new ArrayList<>();

        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();

            if (component instanceof MenuItem && component.isVegetarian()) {
                vegetarianItems.add(new MenuItemRecord(
                        component.getName(),
                        component.getDescription(),
                        component.isVegetarian(),
                        component.getPrice()));
                }
        }

        return vegetarianItems;
    }

    public List<MenuItemRecord> getBreakfastMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> breakfastItems = new ArrayList<>();
        Iterator<MenuComponent> menuIterator = allMenus.createIterator();

        while (menuIterator.hasNext()) {
            MenuComponent component = menuIterator.next();
            if (component instanceof Menu && component.getDescription().equalsIgnoreCase("breakfast")) {
                Iterator<MenuComponent> itemIterator = component.createIterator();
                while (itemIterator.hasNext()) {
                    MenuComponent item = itemIterator.next();
                    if (item instanceof MenuItem) {
                        breakfastItems.add(new MenuItemRecord(
                                item.getName(),
                                item.getDescription(),
                                item.isVegetarian(),
                                item.getPrice()
                        ));
                    }
                }
            }
        }

        return breakfastItems;
    }

    public List<MenuItemRecord> getLunchMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> lunchItems = new ArrayList<>();

        Iterator<MenuComponent> menuIterator = allMenus.createIterator();
        while (menuIterator.hasNext()) {
            MenuComponent component = menuIterator.next();
            if (component instanceof Menu && component.getDescription().equalsIgnoreCase("lunch")) {
                Iterator<MenuComponent> itemIterator = component.createIterator();
                while (itemIterator.hasNext()) {
                    MenuComponent item = itemIterator.next();
                    if (item instanceof MenuItem) {
                        lunchItems.add(new MenuItemRecord(
                                item.getName(),
                                item.getDescription(),
                                item.isVegetarian(),
                                item.getPrice()
                        ));
                    }
                }
            }
        }

        return lunchItems;
    }


    public List<MenuItemRecord> getSupperMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> supperItems = new ArrayList<>();
        Iterator<MenuComponent> menuIterator = allMenus.createIterator();

        while (menuIterator.hasNext()) {
            MenuComponent component = menuIterator.next();
            if (component instanceof Menu && component.getDescription().equalsIgnoreCase("dinner")) {
                Iterator<MenuComponent> itemIterator = component.createIterator();
                while (itemIterator.hasNext()) {
                    MenuComponent item = itemIterator.next();
                    if (item instanceof MenuItem) {
                        supperItems.add(new MenuItemRecord(
                                item.getName(),
                                item.getDescription(),
                                item.isVegetarian(),
                                item.getPrice()
                        ));
                    }
                }
            }
        }

        return supperItems;
    }

}
