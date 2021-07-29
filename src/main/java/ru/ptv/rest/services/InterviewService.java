package ru.ptv.rest.services;

import org.springframework.stereotype.Service;
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
}
