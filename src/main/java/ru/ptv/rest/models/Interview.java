package ru.ptv.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.ptv.rest.enums.State;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 28.07.2021 - 17:47
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private Timestamp start;
    @Column(length = 50, nullable = false)
    private Timestamp finish;

    @Enumerated(value = EnumType.STRING)
    private State state;

//    @ManyToMany
//    @JoinTable(
//            name = "pollQuestions",
//            joinColumns = @JoinColumn(name = "poll_question_id"),
//            inverseJoinColumns = @JoinColumn(name = "interview_id"))
//    private List<PollQuestion> questions;
}
