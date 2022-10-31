package com.rifqimuhammadaziz.apimedicalrecordsystem.validation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.model.response.PageDTO;

public class PageUtils {

    public static PageDTO calculatePage(int size, int page, long totalElements) {
        PageDTO dto = new PageDTO();
        boolean isFirst = false;
        boolean isLast = false;
        long totalPages = 0;

        if (totalElements % size == 0) {
            totalPages = totalElements / size;
        } else {
            totalPages = totalElements / size + 1;
        }

        if (page == totalPages) isLast = true;
        if (page == 1) isFirst = true;

        dto.setFirst(isFirst);
        dto.setLast(isLast);
        dto.setSize(size);
        dto.setPage(page);
        dto.setTotalPages(totalPages);
        dto.setTotalElements(totalElements);

        return dto;
    }
}
