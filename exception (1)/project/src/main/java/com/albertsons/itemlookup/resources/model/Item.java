package com.albertsons.itemlookup.resources.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "items")

public class Item {
    @Id
    private String id;
    @Field(name = "item_id")
    private String itemId;
    private String sku;
    private String pos_description;
    private String ext_description;
    private int sell_multiple;
    private double sell_price;
    private double crv;
    private String link_code;
    private boolean food_stamp;
    private boolean restricted_item;
    private boolean ewic;
    private boolean weight_item;
    private String dept;
    private boolean tax_item;
    private boolean club_item;
    private int smic;
    private String bpn_no;
    private boolean points_apply;
    private boolean non_discountable;
    private String sellby_unit;
    @Field(name = "store_id")
    private String storeId;
    private String image_url;
    private String scan_code;
    private String  upc_type;
    private String sellByWeight;
    private String promoOfferPrice;
    private boolean strikeThroughPrice;
    private List<ClubPrice> clubPrice;
    private int jfuOfferCount;
    private List<J4U> jfuOffers;
}
