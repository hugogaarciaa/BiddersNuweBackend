package com.hackathon.hackathon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hackathon.model.Bidder;
import com.hackathon.hackathon.model.Item;

@Service
public class HackathonService {

    private static final String ITEM_NOT_FOUND = "Item not found";
    private static final String OFFER_ACCEPTED = "Offer accepted";
    private static final String OFFER_REJECTED = "Offer rejected";

    private List<Item> items;

    @Autowired
    public HackathonService(List<Item> items) {
        this.items = items;
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    public List<Item> getItemsByType(String type) {
        List<Item> itemsByType = new ArrayList<>();
        for (Item item : items) {
            if (item.getType().equals(type)) {
                itemsByType.add(item);
            }
        }
        return itemsByType;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String makeOffer(String itemName, double amount, Bidder bidder) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                if (item.getHighestOffer() < amount) {
                    item.setHighestOffer(amount);
                    item.setCurrentBidder(bidder);
                    return OFFER_ACCEPTED;
                } else {
                    return OFFER_REJECTED;
                }
            }
        }
        return ITEM_NOT_FOUND;
    }

    public Map<String, String> getWinningBidder() {
        Map<String, String> winningBidders = new HashMap<>();
        for (Item item : items) {
            if (item.getCurrentBidder() != null) {
                winningBidders.put(item.getName(), item.getCurrentBidder().getName());
            }
        }
        return winningBidders;
    }
}
