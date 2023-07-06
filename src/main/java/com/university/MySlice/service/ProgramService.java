package com.university.MySlice.service;

import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.Program;
import com.university.MySlice.repository.ProgramRepository;
import com.university.MySlice.utils.RandomIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {
    @Autowired
    ProgramRepository programRepository;

    public void saveProgram(Program program) throws Exception{

//        Checks if name was not passed OR If we already have same program name in database.
        if(program==null || program.getProgramName()==null){
            throw new RequiredFieldException("Program name must be passed");
        }

        Program existingProgram = programRepository.findByName(program.getProgramName());

        if(existingProgram!=null){
            throw new Exception("Same Program name Exists in DataBase");
        }

//        Handling ID
        if(program.getProgramID()==null){
            program.setProgramID(RandomIDGenerator.generateRandomId());
        } else {
            Program existingProgramByID = programRepository.findById(program.getProgramID());
            if(existingProgramByID!=null && !program.getProgramName().equals(existingProgramByID.getProgramName())){
                throw new Exception("Changing name is not allowed");
            }
        }

        programRepository.save(program);
    }
}
