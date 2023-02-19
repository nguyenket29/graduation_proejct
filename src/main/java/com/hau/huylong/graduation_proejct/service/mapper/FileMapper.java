package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.hau.Files;
import com.hau.huylong.graduation_proejct.model.dto.hau.FileDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper extends EntityMapper<FileDTO, Files> {
    default public FileDTO fileDTO(String imageName, String contentType, String path, String imageExtension) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setName(imageName);
        fileDTO.setContentType(contentType);
        fileDTO.setPath(path);
        fileDTO.setExtention(imageExtension);
        return fileDTO;
    }
}
