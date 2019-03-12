package com.example.demo.Controller;

import com.example.demo.Model.Note;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    ArrayList<Note> alleNoter = new ArrayList<>();
    int tempId;
    int count = 0;

    @GetMapping({"/index","/","index.html"})
    public String index(Model model) {

        model.addAttribute("alleNoter", alleNoter);

        return "index";
    }

    @GetMapping("/makeNote")
    public String makeNote(Model model){

        model.addAttribute("nyNote", new Note());
        return "makeNote";
    }

    @PostMapping("/makeNote")
    public String makeNote(@ModelAttribute Note note){

        note.setId(count);
        count ++;
        alleNoter.add(note);
        System.out.println(note);

        return "redirect:/index";
    }

    @GetMapping("/updateNote/{updated}")
    public String updateNote(@PathVariable("updated")int idForUpdate, Model model) {

        model.addAttribute("update", alleNoter.get(idForUpdate));
        tempId = idForUpdate;



        return "/updateNote";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute Note note) {

        alleNoter.remove(tempId);
        alleNoter.add(tempId, note);
        note.setId(tempId);
        note.setLastChanged();



        return "redirect:/index";
    }



}
