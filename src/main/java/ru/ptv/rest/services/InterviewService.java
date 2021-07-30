package ru.ptv.rest.services;

import ru.ptv.rest.models.Interview;

import java.util.List;

/**
 * 29.07.2021 - 9:21
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
public interface InterviewService {
    List<Interview> allInterview();
    Interview getInterview(Long id);
    Interview createInterview(Interview interview);
    Interview updateInterview(Long id, Interview interview);
    void deleteInterview(Long id);
}

