package com.albertsons.itemlookup.resources.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ClubPrice {
    private String promoFactor;
    private String promoMethod;
    private double promoPrice;
    private int promoMaxQty;
    private int promoMinQty;
    private String offerId;
    private boolean cms_flag;
    private int rawOfferPrice;
    private String offerMessage;
    private boolean offerMsg1;
    private String saved;
}
