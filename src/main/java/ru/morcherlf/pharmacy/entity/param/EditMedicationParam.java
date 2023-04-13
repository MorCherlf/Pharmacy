package ru.morcherlf.pharmacy.entity.param;

import lombok.Data;

@Data
public class EditMedicationParam {
    private Long id;
    private String name;
    private String introduction;
    private String description;
    private String imgURL;
    private Long categoryID;
}
