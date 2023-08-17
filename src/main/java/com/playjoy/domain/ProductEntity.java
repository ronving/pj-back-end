package com.playjoy.domain;

import com.playjoy.config.converter.CategoryToStringConverter;
import com.playjoy.config.converter.JsonConverter;
import com.playjoy.config.converter.ListToStringConverter;
import com.playjoy.config.converter.TagToStringConverter;
import com.playjoy.enums.Category;
import com.playjoy.enums.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduct")
    @SequenceGenerator(name = "seqProduct")
    private Long id;

    @Column
    private String productName;

    @Column
    private String description;

    @Column
    private String iconUrl;

    @Column
    private String previewUrl;

    @Column
    @Convert(converter = JsonConverter.class)
    private List<String> imagesUrl;

    @Column
    private BigDecimal price;

    @Column
    @Convert(converter = JsonConverter.class)
    private List<Tag> tags;

    @Column
    @Convert(converter = JsonConverter.class)
    private List<Category> categories;

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
