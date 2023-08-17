package com.playjoy.domain;

import com.playjoy.enums.Category;
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
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategory")
    @SequenceGenerator(name = "seqCategory")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;
}
