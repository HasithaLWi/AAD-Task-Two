package lk.ijse.TaskTwo.service.impl;

import lk.ijse.TaskTwo.dto.SectionDTO;
import lk.ijse.TaskTwo.entity.Section;
import lk.ijse.TaskTwo.repository.SectionRepository;
import lk.ijse.TaskTwo.service.SectionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {
    private SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    @Override
    public SectionDTO saveSection(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setName(sectionDTO.getName());

        Section savedSection = sectionRepository.save(section);
        SectionDTO savedSectionDTO = new SectionDTO();
        savedSectionDTO.setId(savedSection.getId());
        savedSectionDTO.setName(savedSection.getName());
        return savedSectionDTO;
    }

    @Override
    public SectionDTO updateSection(SectionDTO sectionDTO) {
        Optional<Section> optionalSection = sectionRepository.findById(sectionDTO.getId());
        if (optionalSection.isPresent()) {
            Section section = optionalSection.get();
            section.setName(sectionDTO.getName());

            Section updatedSection = sectionRepository.save(section);
            SectionDTO updatedSectionDTO = new SectionDTO();
            updatedSectionDTO.setId(updatedSection.getId());
            updatedSectionDTO.setName(updatedSection.getName());
            return updatedSectionDTO;
        } else {
            throw new RuntimeException("Section not found with id: " + sectionDTO.getId());
        }
    }

    @Override
    public boolean deleteSection(String id) {
        return false;
    }

    @Override
    public SectionDTO searchSection(String id) {
        return null;
    }
}
