package com.albertsons.itemlookup.services.implementation;



import com.albertsons.itemlookup.exception.ItemNotFoundException;
import com.albertsons.itemlookup.gateway.J4UGateway;
import com.albertsons.itemlookup.resources.model.ClubPrice;
import com.albertsons.itemlookup.resources.model.Item;
import com.albertsons.itemlookup.resources.model.ItemResponse;
import com.albertsons.itemlookup.resources.model.J4U;
import com.albertsons.itemlookup.services.interfaces.ItemLookup;
import com.albertsons.itemlookup.services.persistence.IItemAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.albertsons.itemlookup.resources.constants.ItemLookupConstants.FilePath;


@Service
@RequiredArgsConstructor
public class ItemLookupImpl implements ItemLookup {

    private final IItemAccess itemAccess;
    private final ItemResponse itemResponse;
    private final J4UGateway j4UGateway;

    @Override
    public ResponseEntity<?> processRequest(String itemId, String storeId) throws IOException, ItemNotFoundException {
        List<ClubPrice> clubPrice = getClubPrice();
        List<J4U> j4uOffers = fetchUpc2j4u(itemId, storeId, "oktatoken");
        int length = j4uOffers.size();
        Item item = itemAccess.findItem(itemId, storeId);
        if (item == null) {
            throw new ItemNotFoundException();
        }
        item.setClubPrice(clubPrice);
        item.setJfuOffers(j4uOffers);
        item.setJfuOfferCount(length);
        if (item.getItemId() != null) {
            itemResponse.setAck("0");
            itemResponse.setMessage("Item found successfully!");
            itemResponse.setData(item);
        }
        return new ResponseEntity(itemResponse, HttpStatus.OK);
    }

    private List<ClubPrice> getClubPrice() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        CollectionType collectionType = typeFactory.constructCollectionType(
                List.class, ClubPrice.class);
        return (List<ClubPrice>) objectMapper.readValue(new File(FilePath), collectionType);
    }

    private List<J4U> fetchUpc2j4u(String paddedScanCode, String storeId, String oktatoken) throws IOException {
        return j4UGateway.getJ4uCoupon(paddedScanCode, storeId, oktatoken);
    }
}



