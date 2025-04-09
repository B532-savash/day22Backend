package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PancakeHouseRepository {
    public List<MenuItem> getTheMenu() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        Iterator it = pancakeHouseMenu.createIterator();
        List<MenuItem> menuItems = new ArrayList<>();
        while(!it.hasNext()) {
            menuItems.add((MenuItem) it.next());
        }
        return menuItems;
    }
}
