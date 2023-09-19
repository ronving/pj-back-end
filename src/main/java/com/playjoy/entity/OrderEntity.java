package com.playjoy.entity;

import com.playjoy.enums.OrderStatus;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrder")
    @SequenceGenerator(name = "seqOrder")
    private Long id;

    @Column(unique = true, nullable = false)
    private String orderCode;

    @Column
    @OneToMany
    private List<ProductEntity> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
