package com.albertsons.itemlookup.resources.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Errors {
    private List<Error> errors;
}
