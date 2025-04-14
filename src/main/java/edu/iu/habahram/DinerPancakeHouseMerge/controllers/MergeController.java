package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {
    CafeRepository cafeRepository;
    PancakeHouseRepository pancakeHouseRepository;
    DinerRepository dinerRepository;

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> result = new ArrayList<>(pancakeHouseRepository.getTheMenu());
        result.addAll(cafeRepository.getItems());
        result.addAll(Arrays.asList(dinerRepository.getTheMenu()));
        return result;
    }
}
