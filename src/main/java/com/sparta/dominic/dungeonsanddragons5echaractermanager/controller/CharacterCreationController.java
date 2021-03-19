package com.sparta.dominic.dungeonsanddragons5echaractermanager.controller;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.CharacterEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.ProficiencyEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.TraitEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.UserEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.service.APIQueryService;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.service.CharacterService;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class CharacterCreationController {

    private APIQueryService apiQueryService;
    private CharacterService characterService;
    private UserService userService;

    @Autowired
    public CharacterCreationController(APIQueryService apiQueryService, CharacterService characterService, UserService userService) {
        this.apiQueryService = apiQueryService;
        this.characterService = characterService;
        this.userService = userService;
    }

    @GetMapping("/character-creation")
    public String characterCreation(Model model) {
        model.addAttribute("characterForm", new CharacterEntity());
        model.addAttribute("apiQueryService", apiQueryService);
        model.addAttribute("raceSelection", apiQueryService.getRaceChoices());
        model.addAttribute("classSelection", apiQueryService.getClassChoices());
        return "character-creation";
    }

    @PostMapping("/character-creation")
    public String save(@ModelAttribute("characterForm") CharacterEntity character, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "character-creation";
        }
        character.setUser(getCurrentUser());
        characterService.save(character);
        return "redirect:/welcome";
    }

    @GetMapping("/view-character")
    public String view(Model model) {
        Collection<CharacterEntity> characters = characterService.findByUserID(getCurrentUser());
        model.addAttribute("characters", characters);
        return "view-character";
    }

    private UserEntity getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findByUsername(userDetails.getUsername());
    }
}
