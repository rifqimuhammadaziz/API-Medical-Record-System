package com.rifqimuhammadaziz.apimedicalrecordsystem.repository.custom;

import com.rifqimuhammadaziz.apimedicalrecordsystem.model.response.PageDTO;

public interface PatientRepositoryCustom {
    PageDTO findAllWithPage(int size, int page, String direction, String properties, String name);
}
