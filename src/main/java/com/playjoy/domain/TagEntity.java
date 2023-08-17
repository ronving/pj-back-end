package com.playjoy.domain;

import com.playjoy.enums.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTag")
    @SequenceGenerator(name = "seqTag")
    private Long id;


    @Column
    @Enumerated(EnumType.STRING)
    private Tag tag;
}
