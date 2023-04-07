package me.blueslime.inventoryhandlerapi.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CustomInventoryClickEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final String id;

    public CustomInventoryClickEvent(Player player, String id) {
        this.player = player;
        this.id = id;
    }

    public HandlerList getHandlers() {
        return handlerList;
    }

    public Player getPlayer() {
        return player;
    }

    public String getId() {
        return id;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
