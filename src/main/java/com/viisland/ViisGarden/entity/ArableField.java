package com.viisland.ViisGarden.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("fields")
@Getter
@Setter
public class ArableField {

    @Id
    private String fieldId;
    @NonNull
    private String fieldName;
    private Location fieldLocation;
    private int fieldSize;
    @NonNull
    private List<String> productId;
}
