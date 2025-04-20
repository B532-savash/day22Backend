package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.*;

public class PancakeHouseMenu extends Menu{
    List<MenuItem> menuItems;

    public PancakeHouseMenu(String name, String description) {
        super(name, description);
        menuItems = new ArrayList<MenuItem>();

        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99);

        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);

        addItem("Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
        add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return Arrays.stream(getItems()).toList();
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuItem item: getMenuItems()) {
            stringBuilder.append(item.toString());
        }
        return  stringBuilder.toString();
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new Iterator<MenuComponent>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                while (position < menuItems.size() && menuItems.get(position) == null) {
                    position++;
                }
                return position < menuItems.size();
            }

            @Override
            public MenuComponent next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return menuItems.get(position++);
            }
        };
    }
}
