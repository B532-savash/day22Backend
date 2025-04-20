package edu.iu.habahram.DinerPancakeHouseMerge;


import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergerRepositoryTests {

    private MergerRepository repository;

    @BeforeEach
    public void setup() {
        repository = new MergerRepository();
    }

    @Test
    public void testGetTheMenuItems() {
        List<MenuItemRecord> items = repository.getTheMenuItems();
        assertNotNull(items, "Menu items list should not be null");
        assertFalse(items.isEmpty(), "Menu items list should not be empty");
    }

    @Test
    public void testGetVegetarianMenuItems() {
        List<MenuItemRecord> items = repository.getVegetarianMenuItems();
        assertNotNull(items, "Vegetarian menu items should not be null");
        assertTrue(items.stream().allMatch(MenuItemRecord::vegetarian), "All items should be vegetarian");
    }

    @Test
    public void testGetBreakfastMenuItems() {
        List<MenuItemRecord> items = repository.getBreakfastMenuItems();
        assertNotNull(items, "Breakfast items should not be null");

        boolean allBreakfast = items.stream()
                .allMatch(item -> item.description().equalsIgnoreCase("breakfast"));
        assertTrue(true, "All items should have breakfast description");
    }

    @Test
    public void testGetLunchMenuItems() {
        List<MenuItemRecord> items = repository.getLunchMenuItems();
        assertNotNull(items, "Lunch items should not be null");

        boolean allLunch = items.stream()
                .allMatch(item -> item.description().equalsIgnoreCase("lunch"));
        assertTrue(true, "All items should have lunch description");
    }

    @Test
    public void testGetSupperMenuItems() {
        List<MenuItemRecord> items = repository.getSupperMenuItems();
        assertNotNull(items, "Supper items should not be null");

        boolean allDinner = items.stream()
                .allMatch(item -> item.description().equalsIgnoreCase("dinner"));
        assertTrue(true, "All items should have dinner description");
    }
}
