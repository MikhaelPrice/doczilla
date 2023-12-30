package doczila.cotrollers;

import doczila.entity.Students;
import doczila.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/addStudent")
    public String addStudent(@RequestParam(required = false) String studentName,
                             @RequestParam(required = false) String studentSurname,
                             @RequestParam(required = false) String studentLastname,
                             @RequestParam(required = false) String studentBirthday,
                             @RequestParam(required = false) String studentGroup,
                             Model model) {
        Students student = new Students();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setLastname(studentLastname);
        student.setBirthday(studentBirthday);
        student.setGroup(studentGroup);
        studentsService.insertStudent(student);
        model.addAttribute("students", studentsService.getAllStudents());
        return "index";
    }

}
