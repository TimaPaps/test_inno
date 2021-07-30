package ru.ptv.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="Опрос пользователей",
        description = "Предоставляет методы для получения, создания, редактирования и удаления опросов")
public class InterviewController {

    private InterviewService service;

    @Autowired
    public InterviewController(InterviewService service) {
        this.service = service;
    }

    @Operation(summary = "Список опросов",
            description = "Предоставляет полный список опросов")
    @GetMapping
    public List<Interview> allInterview() {
        return service.allInterview();
    }

    @Operation(summary = "Опрос",
            description = "Предоставляет определенный опрос")
    @GetMapping("{id}")
    public Interview getInterview(@PathVariable(value = "id") Long id) {
        return service.getInterview(id);
    }

    @Operation(summary = "Создание опроса",
            description = "Предоставляет возможность записи нового опроса в базу данных")
    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        return service.createInterview(interview);
    }

    @Operation(summary = "Изменение опроса",
            description = "Предоставляет возможность изменения опроса в базе данных")
    @PutMapping("{id}")
    public Interview updateInterview(@PathVariable(value = "id") Long id, @RequestBody Interview interview) {
        return service.updateInterview(id, interview);
    }

    @Operation(summary = "Удаление опроса",
            description = "Предоставляет возможность удаления из базы данных")
    @DeleteMapping("{id}")
    public void deleteInterview(@PathVariable(value = "id") Long id) {
        service.deleteInterview(id);
    }
}
