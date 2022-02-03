//package com.albertsons.itemlookup.controller;
//
//import com.albertsons.itemlookup.resources.model.Item;
//import com.albertsons.itemlookup.resources.model.ItemResponse;
//
//import com.albertsons.itemlookup.services.interfaces.ItemLookup;
//import org.json.simple.parser.ParseException;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//
//public class ItemLookupControllerTest {
//    @InjectMocks
//    private ItemLookupController itemLookupController;
//
//    private ItemLookup itemLookup;
//
//    private ItemResponse mockItemResponse;
//
//    private Item item;
//
//    @Before
//    public void init() throws IOException {
//        itemLookupController = new ItemLookupController();
//        itemLookup = mock(ItemLookup.class);
//        mockItemResponse = mock(ItemResponse.class);
//        item = mock(Item.class);
//        ReflectionTestUtils.setField(itemLookupController, "itemLookup", itemLookup);
//    }
//
//    @Test
//    public void getItem() throws IOException, ParseException {
//        Mockito.when(itemLookup.processRequest("0000000005409", "9879")).thenReturn(mockItemResponse);
//        Mockito.when(mockItemResponse.getAck()).thenReturn("0");
//        Mockito.when(item.getItemId()).thenReturn("0000000005409");
//        Mockito.when(item.getDept()).thenReturn("306");
//        ResponseEntity<ItemResponse>mockItem = itemLookupController.getItem("0000000005409", "9879");
//        assertEquals("0", mockItem.getAck());
//        assertEquals("0000000005409",item.getItemId());
//        assertEquals(mockItemResponse, mockItem);
//        assertEquals("306",item.getDept());
//    }
//}