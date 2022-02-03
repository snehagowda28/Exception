package com.albertsons.itemlookup.services.interfaces;



import com.albertsons.itemlookup.exception.ItemNotFoundException;
import com.albertsons.itemlookup.resources.model.ClubPrice;
import com.albertsons.itemlookup.resources.model.J4U;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface ItemLookup {
     ResponseEntity<?> processRequest(String item_id, String store_id) throws IOException, ItemNotFoundException;
}
