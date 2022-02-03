package com.albertsons.itemlookup.services.implementation;



import com.albertsons.itemlookup.services.interfaces.BusinessUtilsService;
import static com.albertsons.itemlookup.resources.constants.ItemLookupConstants.*;

public class BusinessUtilsServiceImpl implements BusinessUtilsService {
    @Override
    public String getUpcType(String scanCode){
            int codeLength = scanCode.length();
            // 13 || 12 as UPCA
            if (14 > codeLength && codeLength > 11) {
                return UPCA;
            }
            // 5 || 4 as PLU (Product Look Up)
            if (6 > codeLength && codeLength > 3) {
                return PLU;
            }
            // UPCE with lengt 8
            if (codeLength == 8) {
                return UPCE;
            }
            // old bizerba scales
            if (codeLength == 26 || codeLength == 19 || codeLength == 30) {
                return CODE128;
            }

            if (codeLength == 16) {
                return DATABAR;
            }
            // if it doesn't match, return upc
            return UPC;
    }

}
