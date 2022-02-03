package com.albertsons.itemlookup.resources.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Error {
    private String code;
    private String message;
    private String type;
    private String category;
    private String vendor;
}
