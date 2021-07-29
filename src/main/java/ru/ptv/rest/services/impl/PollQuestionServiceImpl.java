package ru.ptv.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ptv.rest.models.PollQuestion;
import ru.ptv.rest.repositories.PollQuestionRepository;
import ru.ptv.rest.services.PollQuestionService;

import java.util.List;

/**
 * 29.07.2021 - 9:50
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
@Service
public class PollQuestionServiceImpl implements PollQuestionService {

    private PollQuestionRepository repository;

    @Autowired
    public PollQuestionServiceImpl(PollQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PollQuestion> allPollQuestion() {
        List<PollQuestion>  pollQuestions = repository.findAll();
        return pollQuestions;
    }
}
