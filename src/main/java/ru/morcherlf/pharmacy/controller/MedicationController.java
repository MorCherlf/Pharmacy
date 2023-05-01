package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.morcherlf.pharmacy.entity.*;
import ru.morcherlf.pharmacy.entity.param.AddMedicationDetailParam;
import ru.morcherlf.pharmacy.entity.param.AddMedicationParam;
import ru.morcherlf.pharmacy.entity.param.EditMedicationDetailParam;
import ru.morcherlf.pharmacy.entity.param.EditMedicationParam;
import ru.morcherlf.pharmacy.repository.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MedicationController {
    private final MedicationRepository medicationRepository;
    private final CategoryRepository categoryRepository;
    private final IntroductionRepository introductionRepository;
    private final DescriptionRepository descriptionRepository;
    private final InformationRepository informationRepository;
    private final MedicationDetailRepository medicationDetailRepository;
    private final ShopRepository shopRepository;


//  药品添加分为两种状态：1. 系统管理员添加；2. 门店经理添加
//  此处为系统管理员添加的接口；
//  药品添加时需要填写的内容：药品名称 Medication.Name（字符串）； 描述 Introduction.Introduction（简单介绍药品）；详细介绍 Description.Description (完整介绍）； 图片上传 Information.ImgURL(外链内链均可)；分类ID Category.ID
//  Add Medication
    @PostMapping("/medications")
    Medication newMedication(@RequestBody AddMedicationParam addMedicationParam) {
        Category category = categoryRepository.getReferenceById(addMedicationParam.getCategoryID());
        Introduction introductionClass = new Introduction();
        introductionClass.setIntroduction(addMedicationParam.getIntroduction());
        Introduction introductionNew = introductionRepository.save(introductionClass);
        Description descriptionClass = new Description();
        descriptionClass.setDescription(addMedicationParam.getDescription());
        Description descriptionNew = descriptionRepository.save(descriptionClass);
        Information information = new Information();
        information.setImgURL(addMedicationParam.getImgURL());
        information.setIntroduction(introductionNew);
        information.setDescription(descriptionNew);
        Information informationNew = informationRepository.save(information);
        Medication medication = new Medication();
        medication.setName(addMedicationParam.getName());
        medication.setCategory(category);
        medication.setInformation(informationNew);
        return medicationRepository.save(medication);
    }

//  Add Medication Detail
    @PostMapping("/medications/detail")
    MedicationDetail newMedicationDetail(@RequestBody AddMedicationDetailParam addMedicationDetailParam){
        MedicationDetail medicationDetail = new MedicationDetail();
        medicationDetail.setStocks(addMedicationDetailParam.getStocks());
        medicationDetail.setPrice(addMedicationDetailParam.getPrice());
        medicationDetail.setSalePrice(addMedicationDetailParam.getSalePrice());
        Shop shop = shopRepository.getReferenceById(addMedicationDetailParam.getShopID());
        Medication medication = medicationRepository.getReferenceById(addMedicationDetailParam.getMedicationID());
        medicationDetail.setShop(shop);
        medicationDetail.setMedication(medication);
        return medicationDetailRepository.save(medicationDetail);
    }


//  Get All Medications By Page
//    @GetMapping(value = "/medications",params = {"page","value"})
//    Page<Medication> getMedications(@RequestParam("page") final Integer page, @RequestParam("value") final Integer value){
//        return medicationRepository.findAll(PageRequest.of(page,value));
//    }

//  Get All MedicationDetail By Page
    @GetMapping(value = "/medications",params = {"page","value","shopID"})
    Page<MedicationDetail> getMedications(@RequestParam("page") final Integer page, @RequestParam("value") final Integer value, @RequestParam("shopID") final long shopID){
        Shop shop = shopRepository.getReferenceById(shopID);
        return medicationDetailRepository.findByShop(shop,PageRequest.of(page,value));
    }


//  Get Medication List by Category ID
    @GetMapping("/medications/{CategoryID}")
    List<Medication> getMedicationsByCategory(@PathVariable("CategoryID") long categoryID){
        Category category = categoryRepository.getReferenceById(categoryID);
        return medicationRepository.findByCategory(category);
    }

//  Edit Medication
    @PostMapping("/medications/edit")
    Medication editMedication(@RequestBody EditMedicationParam editMedicationParam) {
        Category category = categoryRepository.getReferenceById(editMedicationParam.getCategoryID());
        Medication medication = medicationRepository.getReferenceById(editMedicationParam.getId());
        medication.setName(editMedicationParam.getName());
        Information information = medication.getInformation();
        information.setImgURL(editMedicationParam.getImgURL());
        Introduction introduction = information.getIntroduction();
        introduction.setIntroduction(editMedicationParam.getIntroduction());
        introductionRepository.save(introduction);
        Description description = information.getDescription();
        description.setDescription(editMedicationParam.getDescription());
        descriptionRepository.save(description);
        informationRepository.save(information);
        medication.setCategory(category);
        return medicationRepository.save(medication);
    }

    //  Add Medication Detail
    @PostMapping("/medications/detail/edit")
    MedicationDetail editMedicationDetail(@RequestBody EditMedicationDetailParam editMedicationDetailParam){
        MedicationDetail medicationDetail = medicationDetailRepository.getReferenceById(editMedicationDetailParam.getId());
        medicationDetail.setStocks(editMedicationDetailParam.getStocks());
        medicationDetail.setPrice(editMedicationDetailParam.getPrice());
        medicationDetail.setSalePrice(editMedicationDetailParam.getSalePrice());
        Shop shop = shopRepository.getReferenceById(editMedicationDetailParam.getShopID());
        Medication medication = medicationRepository.getReferenceById(editMedicationDetailParam.getMedicationID());
        medicationDetail.setShop(shop);
        medicationDetail.setMedication(medication);
        return medicationDetailRepository.save(medicationDetail);
    }

    @GetMapping("/medications/detail/delete/{id}")
    void deleteMedicationDetail(@PathVariable("id") long id){
        medicationDetailRepository.deleteById(id);
    }

}
