package com.viisland.ViisGarden.service;

import com.viisland.ViisGarden.entity.ArableField;
import com.viisland.ViisGarden.repository.ArableFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArableFieldService {

    private final ArableFieldRepository arableFieldRepository;
    private final LocationService locationService;

    @Transactional
    public ArableField addArableField(ArableField arableField) throws Exception {
        try {
            return arableFieldRepository.save(arableField);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public ArableField addArableFieldWithProduct(ArableField arableField, String productId) throws Exception {
        try {
            //todo check field and productId in db
            if (!productId.isBlank()) {
                List<String> productIds = new ArrayList<>();
                productIds.add(productId);
                arableField.setProductId(productIds);
                return arableFieldRepository.save(arableField);
            } else {
                throw new Exception("Product id is blank");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public ArableField updateArableField(String arableFieldId, ArableField arableField) throws Exception {
        try {
            Optional<ArableField> findArableField = findRelevantArableField(arableFieldId);
            if (findArableField.isPresent()) {
                findArableField.get().setFieldName(arableField.getFieldName());
                findArableField.get().setFieldSize(arableField.getFieldSize());
                findArableField.get().setProductId(arableField.getProductId());
                findArableField.get().setFieldLocation(arableField.getFieldLocation());
                locationService.updateLocation(findArableField.get().getFieldLocation().getLocationId(),findArableField.get().getFieldLocation());
                return arableFieldRepository.save(findArableField.get());
            } else {
                throw new Exception("Can not find relevant location data.");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public ArableField deleteArableField(String arableFieldId) throws Exception {
        try {
            Optional<ArableField> findArableField = findRelevantArableField(arableFieldId);
            if (findArableField.isPresent()) {
                arableFieldRepository.deleteById(arableFieldId);
                return findArableField.get();
            } else {
                throw new Exception("Can not delete arableField id: "+arableFieldId);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public ArableField getArableField(String arableFieldId) throws Exception {
        Optional<ArableField> findArableField = findRelevantArableField(arableFieldId);
        if (findArableField.isPresent()) {
            return  findArableField.get();
        } else {
            throw new Exception("Can not find the arableField: " + arableFieldId);
        }
    }

    public List<ArableField> getAllArableField() {
        return arableFieldRepository.findAll();
    }

    private Optional<ArableField> findRelevantArableField(String arableFieldId) throws Exception {
        try {
            if (!arableFieldId.isBlank()) {
                return arableFieldRepository.findById(arableFieldId);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
