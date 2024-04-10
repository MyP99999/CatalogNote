package com.example.CatalogNote.Services;


import com.example.CatalogNote.Entities.Grade;
import com.example.CatalogNote.Entities.User;
import com.example.CatalogNote.Repositories.GradeRepository;
import com.example.CatalogNote.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserRepository userRepository;

    public Grade addGrade(Grade grade) {
        // Ensure the student is fetched and set before saving the Grade
        if (grade.getStudent() != null && grade.getStudent().getUser_id() != null) {
            User student = userRepository.findById(grade.getStudent().getUser_id())
                    .orElseThrow(() -> new RuntimeException("Student not found with ID: " + grade.getStudent().getUser_id()));
            grade.setStudent(student);
        }
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Optional<Grade> getGradeById(Integer id) {
        return gradeRepository.findById(id);
    }

    public void deleteGrade(Integer id) {
        gradeRepository.deleteById(id);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

//    public List<Grade> getGradesByStudentId(Integer studentId) {
//        return gradeRepository.findByStudentUserId(studentId);
//    }
}
