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
    public String addStudent(@RequestParam String studentName,
                             @RequestParam String studentSurname,
                             @RequestParam String studentLastname,
                             @RequestParam String studentBirthday,
                             @RequestParam String studentGroup,
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

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int studentId, Model model) {
        studentsService.deleteStudent(studentId);
        model.addAttribute("students", studentsService.getAllStudents());
        return "index";
    }

    @GetMapping("/showStudents")
    public String showStudents(Model model) {
        model.addAttribute("students", studentsService.getAllStudents());
        return "index";
    }

}
