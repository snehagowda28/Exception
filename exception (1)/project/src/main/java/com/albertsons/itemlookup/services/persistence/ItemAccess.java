package com.albertsons.itemlookup.services.persistence;

import com.albertsons.itemlookup.persistence.ItemLookupRepo;
import com.albertsons.itemlookup.resources.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemAccess implements IItemAccess {
    @Autowired
    private ItemLookupRepo itemLookupRepo;

    @Override
    public Item findItem(String itemId,String storeId){
        return itemLookupRepo.findByItemIdAndStoreId(itemId,storeId);
    }
}
