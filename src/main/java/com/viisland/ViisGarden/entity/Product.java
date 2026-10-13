package com.viisland.ViisGarden.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
@Getter
@Setter
public class Product {

    @Id
    private String productId;
    @NonNull
    private String productName;
    @NonNull
    private String productYear;

    //ürün sebze/meyve/bakliyat
    @NonNull
    private String productType;

    //Ürünün verimi
    private String productYield;

    //Üründen elde edilen toplam kazanç
    private Long productTotalPrice;

    //Ürün hangi tarlalarda var
    private ArableField productField;
}
