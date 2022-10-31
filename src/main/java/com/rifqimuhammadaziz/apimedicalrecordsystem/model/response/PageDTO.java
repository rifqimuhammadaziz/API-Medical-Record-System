package com.rifqimuhammadaziz.apimedicalrecordsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDTO<T> {
    private int page;
    private int size;
    private long totalElements;
    private boolean isLast;
    private boolean isFirst;
    private long totalPages;
    private List<T> data;
}
