package com.university.MySlice.controller;

import com.university.MySlice.models.Program;
import com.university.MySlice.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/program")

public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @PostMapping("/save")
    public void saveProgram(@RequestBody Program program){

    }
}