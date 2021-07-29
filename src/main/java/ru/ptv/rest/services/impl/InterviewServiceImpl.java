package ru.ptv.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ptv.rest.models.Interview;
import ru.ptv.rest.repositories.InterviewRepository;
import ru.ptv.rest.services.InterviewService;

import java.util.List;

/**
 * 29.07.2021 - 9:29
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    
    private InterviewRepository repository;

    @Autowired
    public InterviewServiceImpl(InterviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Interview> allInterview() {
        List<Interview> interviews = repository.findAll();
        return interviews;
    }
}
