package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {
    PancakeHouseRepository pancakeHouseRepository;
    DinerRepository dinerRepository;
    public MergeController(PancakeHouseRepository pr, DinerRepository dr){
        this.pancakeHouseRepository = pr;
        this.dinerRepository = dr;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> mergeList = new ArrayList<>(Arrays.asList(dinerRepository.getTheMenu()));
        mergeList.addAll(pancakeHouseRepository.getTheMenu());
        return mergeList;
    }
}
