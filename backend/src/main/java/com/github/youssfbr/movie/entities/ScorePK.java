package com.github.youssfbr.movie.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
@Getter@Setter
@NoArgsConstructor
public class ScorePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

}
