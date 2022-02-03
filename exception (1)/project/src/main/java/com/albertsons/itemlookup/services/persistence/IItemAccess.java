package com.albertsons.itemlookup.services.persistence;

import com.albertsons.itemlookup.resources.model.Item;
import org.springframework.stereotype.Component;

@Component
public interface IItemAccess {
     Item findItem(String itemId, String storeId);
}
