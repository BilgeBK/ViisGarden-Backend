package com.viisland.ViisGarden.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("locations")
@Getter
@Setter
public class Location {

    @Id
    private String locationId;
    @NonNull
    private String province;
    @NonNull
    private String district;
    private String neighbourhood;
    private String street;
    private String parcel;

}
