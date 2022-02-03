package com.albertsons.itemlookup.resources.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class J4U {
    private String offerId;
    private String offerPrice;
    private String description;
    private String status;
    private String startDate;
    private String endDate;
    private String offerTs;
    private String usageType;
    private String offerPgm;
    private String offerSubPgm;
    private String purchaseInd;
    private String extlOfferId;
    private String brand;
    private String category;
    private int minPurchaseQty;
    private int maxPurchaseQty;
    private int price;
    private String imageId;
    private String vndrBannerCd;
    private String purchaseRank;
    private String deleted;
}
