package com.albertsons.itemlookup.persistence;

import com.albertsons.itemlookup.resources.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLookupRepo extends MongoRepository<Item,String> {

     Item findByItemIdAndStoreId(String itemId,String storeId);

}
