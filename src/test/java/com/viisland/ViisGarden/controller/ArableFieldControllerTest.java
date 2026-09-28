package com.viisland.ViisGarden.controller;

import com.viisland.ViisGarden.entity.ArableField;
import com.viisland.ViisGarden.repository.ArableFieldRepository;
import com.viisland.ViisGarden.service.ArableFieldService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ArableFieldControllerTest {

    @Mock
    ArableFieldService arableFieldService;

    @Mock
    ArableFieldRepository arableFieldRepository;

    @Test
    void addArableFieldWithProduct() throws Exception {
        ArableField arableField = new ArableField();
        arableField.setProductId(List.of("132132"));
        arableFieldService.addArableFieldWithProduct(arableField,arableField.getProductId().getFirst());
        Mockito.verify(arableFieldService, Mockito.times(1)).addArableFieldWithProduct(any(),any());
    }

    @Test
    void addArableFieldSuccess() throws Exception {
        ArableField arableField = new ArableField();
        arableFieldService.addArableField(arableField);
        Mockito.verify(arableFieldService, Mockito.times(1)).addArableField(any());
    }

}
