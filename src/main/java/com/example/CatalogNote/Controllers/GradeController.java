package com.example.CatalogNote.Controllers;

import com.example.CatalogNote.Entities.Grade;
import com.example.CatalogNote.Services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @PutMapping
    public Grade updateGrade(@RequestBody Grade grade) {
        return gradeService.updateGrade(grade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Integer id) {
        return gradeService.getGradeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Integer id) {
        gradeService.deleteGrade(id);
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

//    @GetMapping("/student/{studentId}")
//    public List<Grade> getGradesByStudentId(@PathVariable Integer studentId) {
//        return gradeService.getGradesByStudentId(studentId);
//    }
}
