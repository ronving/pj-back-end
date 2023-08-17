package com.playjoy.config.converter;

import com.playjoy.enums.Tag;
import lombok.RequiredArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
@RequiredArgsConstructor
public class TagToStringConverter implements AttributeConverter<List<Tag>, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<Tag> attribute) {
        if (attribute != null) {
            return attribute.stream()
                            .map(Enum::name)
                            .collect(Collectors.joining(DELIMITER));
        }
        return null;
    }

    @Override
    public List<Tag> convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return Arrays.stream(dbData.split(DELIMITER))
                         .map(Tag::valueOf)
                         .collect(Collectors.toList());
        }
        return null;
    }

}
