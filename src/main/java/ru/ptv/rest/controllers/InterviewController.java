package ru.ptv.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ptv.rest.models.Interview;
import ru.ptv.rest.services.InterviewService;

import java.util.List;

/**
 * 29.07.2021 - 8:59
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
@RestController
@RequestMapping("interviews")
public class InterviewController {

    private InterviewService service;

    @Autowired
    public InterviewController(InterviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<Interview> allInterview() {
        return service.allInterview();
    }

    @GetMapping("{id}")
    public Interview getInterview(@PathVariable(value = "id") Long id) {
        return service.getInterview(id);
    }

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        return service.createInterview(interview);
    }

    @PutMapping("{id}")
    public Interview updateInterview(@PathVariable(value = "id") Long id, @RequestBody Interview interview) {
        return service.updateInterview(id, interview);
    }

    @DeleteMapping("{id}")
    public void deleteInterview(@PathVariable(value = "id") Long id) {
        service.deleteInterview(id);
    }
}
