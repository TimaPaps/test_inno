package ru.ptv.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 29.07.2021 - 0:39
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
public interface PollQuestionRepository extends JpaRepository<ru.ptv.rest.models.PollQuestion, Long> {
}
