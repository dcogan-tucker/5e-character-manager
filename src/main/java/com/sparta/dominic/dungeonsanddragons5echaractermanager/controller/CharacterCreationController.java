package com.sparta.dominic.dungeonsanddragons5echaractermanager.controller;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.CharacterEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.service.APIQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterCreationController {

    private APIQueryService apiQueryService;

    @Autowired
    public CharacterCreationController(APIQueryService apiQueryService) {
        this.apiQueryService = apiQueryService;
    }

    @GetMapping("/character-creation")
    public String characterCreation(Model model) {
        model.addAttribute("characterForm", new CharacterEntity());
        model.addAttribute("apiQueryService", apiQueryService);
        model.addAttribute("raceSelection", apiQueryService.getRaceChoices());
        model.addAttribute("classSelection", apiQueryService.getClassChoices());
        return "character-creation";
    }

//    @GetMapping("/character-creation?raceSelect={raceSelect}")
//    public String characterCreationTraitAndProficiency(@PathVariable(value = "raceSelect") String race,
//                                                       Model model) {
//        CharacterEntity characterEntity = new CharacterEntity();
//        characterEntity.setRace(race);
//        model.addAttribute("characterForm", characterEntity);
//        System.out.println("TEST");
//        model.addAttribute("traitSelection", apiQueryService.getTraitChoices(race));
//        return "character-creation";
//    }
}
