package me.blueslime.menuhandlerapi.item.action;

import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Predicate;

public class InventoryItemAction {

    private Predicate<InventoryClickEvent> clickEvent;

    public InventoryItemAction(Predicate<InventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public void setClickEvent(Predicate<InventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public Predicate<InventoryClickEvent> getClickEvent() {
        return clickEvent;
    }
}
