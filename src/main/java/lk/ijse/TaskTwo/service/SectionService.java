package lk.ijse.TaskTwo.service;

import lk.ijse.TaskTwo.dto.SectionDTO;

public interface SectionService {
    SectionDTO saveSection(SectionDTO sectionDTO);
    SectionDTO updateSection(SectionDTO sectionDTO);
    boolean deleteSection(String id);
    SectionDTO searchSection(String id);
}
