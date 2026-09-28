package com.viisland.ViisGarden.controller;

import com.viisland.ViisGarden.commons.PathConstant;
import com.viisland.ViisGarden.entity.ArableField;
import com.viisland.ViisGarden.service.ArableFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstant.ArableFieldPath.ARABLE_FIELD_MAP)
@RequiredArgsConstructor
public class ArableFieldController {

    private final ArableFieldService arableFieldService;

    @PostMapping(PathConstant.ArableFieldPath.ADD_ARABLE_FIELD)
    public ResponseEntity<ArableField> addArableField(@RequestBody @Validated ArableField arableField) throws Exception {

        if (!arableField.getProductId().isEmpty()) {
            ArableField response = arableFieldService.addArableFieldWithProduct(arableField, String.valueOf(arableField.getProductId()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ArableField response = arableFieldService.addArableField(arableField);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PutMapping(PathConstant.ArableFieldPath.UPDATE_ARABLE_FIELD)
    public ResponseEntity<ArableField> updateArableField(@PathVariable String arableFieldId, @RequestBody @Validated ArableField arableField) throws Exception {
        ArableField response = arableFieldService.updateArableField(arableFieldId,arableField);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(PathConstant.ArableFieldPath.DELETE_ARABLE_FIELD)
    public ResponseEntity<ArableField> deleteArableField(@PathVariable String arableFieldId) throws Exception {
        ArableField response = arableFieldService.deleteArableField(arableFieldId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(PathConstant.ArableFieldPath.GET_ARABLE_FIELD)
    public ResponseEntity<ArableField> getArableField(@PathVariable String arableFieldId) throws Exception {
        ArableField response = arableFieldService.getArableField(arableFieldId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(PathConstant.ArableFieldPath.GET_ALL_ARABLE_FIELD)
    public ResponseEntity<List<ArableField>> getAllArableField() {
        List<ArableField> response = arableFieldService.getAllArableField();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
