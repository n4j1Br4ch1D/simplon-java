package com.shos.shos.response;

import java.util.List;

import com.shos.shos.dto.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainResponse<T> {
    private List<T> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}