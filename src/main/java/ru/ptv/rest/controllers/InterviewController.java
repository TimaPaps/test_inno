package ru.ptv.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
