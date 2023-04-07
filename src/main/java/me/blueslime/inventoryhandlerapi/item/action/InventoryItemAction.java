package me.blueslime.inventoryhandlerapi.item.action;

import me.blueslime.inventoryhandlerapi.event.CustomInventoryClickEvent;

import java.util.function.Predicate;

public class InventoryItemAction {

    private Predicate<CustomInventoryClickEvent> clickEvent;

    public InventoryItemAction(Predicate<CustomInventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public void setClickEvent(Predicate<CustomInventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public Predicate<CustomInventoryClickEvent> getClickEvent() {
        return clickEvent;
    }
}
