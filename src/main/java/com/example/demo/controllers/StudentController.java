package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Student;
import com.example.demo.models.StudentRespository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {

  @Autowired
  private StudentRespository studentRepo;

  //Display database in home with more user friendly UI (showAll page)
  @GetMapping("/home")
  public String getAllStudents(Model model){
    //System.out.println("Getting all the users from db ");
    // Find and all the students from inside studentRepo to list
    List<Student> students = studentRepo.findAll();
    model.addAttribute("us", students);
    return "users/showAll";
  }

  //Display Student database (showDisplay page)
  @GetMapping("/display")
  public String getAllUsers(Model model){
    // System.out.println("Getting all the users from db ");
    // Find and all the students from inside studentRepo to list
    List<Student> students = studentRepo.findAll();
    model.addAttribute("us", students);
    return "users/showDisplay";
  }

  //Post new Student
  @PostMapping("/add")
  public String AddStudents(@RequestParam Map<String, String> newstudent, HttpServletResponse response) {
    System.out.println("ADD USER");
    //Get all the value from request param
    String newName = newstudent.get("name");
    int newWeight= Integer.parseInt(newstudent.get("weight"));
    int newHeight= Integer.parseInt(newstudent.get("height"));
    String newHairColor = newstudent.get("hairColor");
    String newMajor = newstudent.get("major");
    Double newGpa = Double.parseDouble(newstudent.get("gpa"));
    String newGender = newstudent.get("gender");
    // Save it as a new student inside studet repo
    studentRepo.save(new Student(newName, newWeight, newHeight, newHairColor, newMajor, newGpa, newGender));
    response.setStatus(201);
    return "redirect:/home";
  }

  //Edit the Student
  @GetMapping("/student/edit/{uid}")
  public String EditStudent(@PathVariable("uid") Integer studentID, Model model){
    // System.out.println("Update it");
    // Finding specific student using its id that we get from path variable 
    Optional<Student> student = studentRepo.findById(studentID);
    model.addAttribute("us", student.get());
    return "users/editStudent";
  }

  //Post The Student
  @PostMapping("/student/edit/{uid}")
  public String updateEmployee(@PathVariable("uid") Integer studentID, Model model, @RequestParam Map<String, String> newstudent, HttpServletResponse response){
    // Finding specific student using its id that we get from path variable 
    Optional<Student> optionalStudent = studentRepo.findById(studentID);
    // Getting the specific student from the line below and store it in a object
    Student student = optionalStudent.get();
    //Set all the new value and save it inside student repo
    student.setUid(studentID);
    student.setName(newstudent.get("name"));
    student.setWeight(Integer.parseInt(newstudent.get("weight")));
    student.setHeight(Integer.parseInt(newstudent.get("height")));
    student.setHairColor(newstudent.get("hairColor"));
    student.setMajor(newstudent.get("major"));
    student.setGpa(Double.parseDouble(newstudent.get("gpa")));
    student.setGender(newstudent.get("gender"));

    studentRepo.save(student);
    return "redirect:/home";
  }

  //remove the student 
  @GetMapping("/student/delete/{uid}")
  public String DeleteStudent(@PathVariable("uid") Integer studentID, Model model){
    // System.out.println("Delete it");
    // Delete the specific student by finding it using it' id
    studentRepo.deleteById(studentID);
    
    return "redirect:/home";
  }

}
