package ru.ptv.rest.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ptv.rest.models.PollQuestion;
import ru.ptv.rest.services.PollQuestionService;

import java.util.List;

/**
 * 29.07.2021 - 9:20
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
@RestController
@RequestMapping("pollQuestions")
@Tag(name = "Вопрос для опроса",
        description = "Предоставляет методы для получения, создания, редактирования и удаления вопросов для опросов")
public class PollQuestionController {

    private PollQuestionService service;

    @Autowired
    public PollQuestionController(PollQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<PollQuestion> allPollQuestion() {
        return service.allPollQuestion();
    }
}
