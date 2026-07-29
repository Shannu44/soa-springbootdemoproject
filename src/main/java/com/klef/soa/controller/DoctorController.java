package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Doctor;
import com.klef.soa.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController
{
    @Autowired
    private DoctorService service;

    @GetMapping("/")
    public String demo()
    {
        return "Spring Boot Project";
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor d)
    {
        Doctor doctor = service.addDoctor(d);
        return ResponseEntity.status(201).body(doctor);
    }

    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor d)
    {
        Doctor doctor = service.updateDoctor(d);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<Doctor>> displayAllDoctors()
    {
        List<Doctor> doctors = service.displayAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<Doctor> displayDoctorById(@PathVariable Long id)
    {
        Doctor doctor = service.dispalyDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id)
    {
        String message = service.deleteDoctorById(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/displaybygender/{gender}")
    public ResponseEntity<List<Doctor>> displayDoctorByGender(@PathVariable String gender)
    {
        List<Doctor> doctors = service.displayDoctorByGender(gender);
        return ResponseEntity.ok(doctors);
    }
    //Doctor count
    
    @GetMapping("/count")
    public ResponseEntity<String> doctorcount() {
    	Long count = service.doctorCount();
    	String msg = "Total Doctors="+count;
    	return ResponseEntity.ok(msg);
    }
    
    
    
    
    
    
    
}