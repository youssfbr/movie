package com.github.youssfbr.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScorePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

}
