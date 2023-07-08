package com.university.MySlice.controller;

import com.university.MySlice.models.Program;
import com.university.MySlice.models.User;
import com.university.MySlice.repository.ProgramRepository;
import com.university.MySlice.service.ProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/program")

public class ProgramController {

    @Autowired
    private ProgramService programService;

    Logger LOGGER = LoggerFactory.getLogger(ProgramController.class);

    @PostMapping("/save")
    public String saveProgram(@RequestBody Program program) throws Exception{
        try{
            programService.saveProgram(program);
        } catch(Exception e){
            LOGGER.error(e.getMessage());
            throw e;
        }

        return "Program has been created Successfully";
    }

    @GetMapping("/getProgram")
    public Program getProgram(@RequestParam Long Id) throws Exception{
        try {
            return programService.getProgramById(Id);

        } catch(Exception e){
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

}