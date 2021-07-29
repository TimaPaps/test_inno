package ru.ptv.rest.services;

import ru.ptv.rest.models.PollQuestion;

import java.util.List;

/**
 * 29.07.2021 - 9:48
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
public interface PollQuestionService {
    List<PollQuestion> allPollQuestion();
}
