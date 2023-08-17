package com.playjoy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import java.time.Instant;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAccount")
    @SequenceGenerator(name = "seqAccount")
    private Long id;

    @Column
    private String nickName;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdDate = Instant.now();

    @Column
    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();

    @PreUpdate
    public void preUpdate() {
        this.lastModifiedDate = Instant.now();
    }
}
