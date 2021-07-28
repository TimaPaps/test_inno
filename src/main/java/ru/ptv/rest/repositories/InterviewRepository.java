package ru.ptv.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ptv.rest.models.Interview;

/**
 * 29.07.2021 - 0:38
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
