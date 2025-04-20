package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    MergerRepository mergerRepository;

    public MergeController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        return mergerRepository.getTheMenuItems();
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems() {
        return mergerRepository.getVegetarianMenuItems();
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        return mergerRepository.getBreakfastMenuItems();
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems() {
        return mergerRepository.getLunchMenuItems();
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperItems() {
        return mergerRepository.getSupperMenuItems();
    }

    @PostMapping("/signup")
    public String signup(@RequestBody Customer customer) {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            FileWriter fw = new FileWriter("data/customers.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.printf("%s,%s,%s%n", customer.username, customer.password, customer.email);
            pw.close();

            return "Signup successful!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Signup failed due to server error.";
        }
    }
}
