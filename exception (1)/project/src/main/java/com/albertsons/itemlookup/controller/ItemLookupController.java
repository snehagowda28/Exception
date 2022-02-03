package com.albertsons.itemlookup.controller;


import com.albertsons.itemlookup.exception.UrlNotFoundException;
import com.albertsons.itemlookup.services.interfaces.ItemLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.albertsons.itemlookup.resources.constants.ItemLookupConstants.ItemLookupURL;


@RestController
public class ItemLookupController extends Exception{

    private static String Url;
    @Autowired
    private ItemLookup itemLookup;


    @Value("${spring.message}")
    public String message;

    @GetMapping("/env")
    public String hello() {
        return message;
    }

    @RequestMapping(value = ItemLookupURL, method = RequestMethod.GET)
    public ResponseEntity<?> getItem(@RequestParam("itemId") String itemId, @RequestParam("storeId") String storeId) throws Exception{
            return itemLookup.processRequest(itemId, storeId);
    }

    @RequestMapping(value = "/*")
    public void getUrl() throws UrlNotFoundException {
        throw new UrlNotFoundException();
    }
}

//  return  new ResponseEntity<>(itemLookupImpl.getItem(itemId), HttpStatus.OK);