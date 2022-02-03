package com.albertsons.itemlookup.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ItemLookupExceptionConstants {
        DATABASE_EXCEPTION("", "4004", "db_connection_error", "SNG_database", "SNG_database"),
        INVALID_URL("url not valid", "4004", "Invalid Url", "SNG_database", "SNG_database"),
        FILE_NOT_FOUND("file_not _found", "4000", "File not found", "SNG_database", "SNG_database" ),
        ITEM_NOT_FOUND("item_not_found", "4004", "Item not found", "SNG_database", "SNG_database"),
        EXCEPTION("", "4004", "Exception", "SNG_database", "SNG_database");

        private String message;
        private String code;
        private String category;
        private String type;
        private String vendor;

}
