//package com.university.MySlice.service;
//
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ProgramServiceTest {
//
//    @Test
//    public void saveProgram_NewProgram_Success() throws Exception {
//        // Create a new program
//        Program program = new Program();
//        program.setProgramName("Computer Science");
//        program.setDepartment("Computer Science Department");
//        program.setCreditRequired(120);
//        program.setDuration(4);
//        program.setDegreeOffered("Bachelor");
//
//        // Mock the program repository
//        ProgramRepository programRepositoryMock = Mockito.mock(ProgramRepository.class);
//        Mockito.when(programRepositoryMock.findByName(Mockito.anyString())).thenReturn(null);
//        Mockito.when(programRepositoryMock.findById(Mockito.anyLong())).thenReturn(null);
//
//        // Create an instance of ProgramService and set the mocked repository
//        ProgramService programService = new ProgramService();
//        programService.setProgramRepository(programRepositoryMock);
//
//        // Call the saveProgram method
//        programService.saveProgram(program);
//
//        // Verify that programRepository.save() is called once
//        Mockito.verify(programRepositoryMock, Mockito.times(1)).save(program);
//    }
//
//    @Test
//    public void saveProgram_NullProgramName_RequiredFieldException() {
//        // Create a new program with null program name
//        Program program = new Program();
//        program.setProgramName(null);
//
//        // Create an instance of ProgramService
//        ProgramService programService = new ProgramService();
//
//        // Assert that RequiredFieldException is thrown
//        assertThrows(RequiredFieldException.class, () -> programService.saveProgram(program));
//    }
//
//    @Test
//    public void saveProgram_ExistingProgramName_Exception() {
//        // Create a new program with an existing program name
//        Program program = new Program();
//        program.setProgramName("Computer Science");
//
//        // Mock the program repository to return an existing program
//        ProgramRepository programRepositoryMock = Mockito.mock(ProgramRepository.class);
//        Mockito.when(programRepositoryMock.findByName(Mockito.anyString())).thenReturn(program);
//
//        // Create an instance of ProgramService and set the mocked repository
//        ProgramService programService = new ProgramService();
//        programService.setProgramRepository(programRepositoryMock);
//
//        // Assert that Exception is thrown
//        assertThrows(Exception.class, () -> programService.saveProgram(program));
//    }
//
//    @Test
//    public void saveProgram_ExistingProgramIdAndDifferentProgramName_Exception() {
//        // Create a new program with an existing program ID and a different program name
//        Program program = new Program();
//        program.setProgramID(123456L);
//        program.setProgramName("Computer Science");
//
//        // Mock the program repository to return an existing program with a different program name
//        Program existingProgram = new Program();
//        existingProgram.setProgramID(123456L);
//        existingProgram.setProgramName("Computer Engineering");
//        ProgramRepository programRepositoryMock = Mockito.mock(ProgramRepository.class);
//        Mockito.when(programRepositoryMock.findById(Mockito.anyLong())).thenReturn(existingProgram);
//
//        // Create an instance of ProgramService and set the mocked repository
//        ProgramService programService = new ProgramService();
//        programService.setProgramRepository(programRepositoryMock);
//
//        // Assert that Exception is thrown
//        assertThrows(Exception.class, () -> programService.saveProgram(program));
//    }
//
//
//}