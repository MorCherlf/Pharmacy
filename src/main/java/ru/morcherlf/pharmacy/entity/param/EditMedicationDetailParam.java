package ru.morcherlf.pharmacy.entity.param;

import lombok.Data;

@Data
public class EditMedicationDetailParam {
    private Long id;
    private int stocks;
    private float price;
    private float salePrice;
    private Long shopID;
    private Long medicationID;
}
