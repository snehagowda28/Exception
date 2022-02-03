package com.albertsons.itemlookup.gateway;


import com.albertsons.itemlookup.resources.model.J4U;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class J4UGateway {

    @Autowired
    private List<J4U> j4U;


    public List<J4U> getJ4uCoupon(String paddedScanCode, String stordId, String oktatoken) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(
                List.class, J4U.class);
        j4U = (List<J4U>) objectMapper.readValue(new File("C:\\Project\\exception (1)\\project\\src\\main\\java\\com\\albertsons\\itemlookup\\mocked-ext-services\\j4uOffers.json"), collectionType);

        return j4U;
    }
}

