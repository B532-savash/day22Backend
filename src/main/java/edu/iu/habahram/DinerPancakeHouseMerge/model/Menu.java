package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Menu extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        ArrayList<MenuItem> result = new ArrayList<>();
        for(MenuComponent menuComponent: menuComponents) {
            result.addAll(Arrays.asList(menuComponent.getItems()));
        }

        return result.toArray(new MenuItem[0]);
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new PancakeHouseIterator(menuComponents.iterator());
    }
}
