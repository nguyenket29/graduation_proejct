package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.model.dto.hau.GoogleDriverFolderDTO;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface GoogleDriverFolder {
    PageDataResponse<GoogleDriverFolderDTO> getAllFolder() throws IOException, GeneralSecurityException;
    void createFolder(String folderName) throws Exception;
    void deleteFolder(String id) throws Exception;
}
