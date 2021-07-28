package ru.ptv.rest.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 28.07.2021 - 17:48
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
public class PollQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String text;
    @Column(nullable = false)
    private Short displayOrder;

    @ManyToMany(mappedBy = "questions")
    private List<Interview> interviews;
}
