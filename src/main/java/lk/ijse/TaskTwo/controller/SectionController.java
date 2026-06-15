package lk.ijse.TaskTwo.controller;

import lk.ijse.TaskTwo.constant.CommonResponse;
import lk.ijse.TaskTwo.constant.ResponseCode;
import lk.ijse.TaskTwo.dto.SectionDTO;
import lk.ijse.TaskTwo.service.SectionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {

    private SectionService sectionService;

     public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Object saveSection(@RequestBody SectionDTO sectionDTO) {
        SectionDTO savedSection = sectionService.saveSection(sectionDTO);
        return new CommonResponse(ResponseCode.OPERATION_SUCCESS,savedSection, "Section saved successfully");
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "update")
    public Object updateSection(@RequestBody SectionDTO sectionDTO) {
        SectionDTO updatedSection = sectionService.updateSection(sectionDTO);
        return new CommonResponse(ResponseCode.OPERATION_SUCCESS, updatedSection, "Section updated successfully");
    }


}
