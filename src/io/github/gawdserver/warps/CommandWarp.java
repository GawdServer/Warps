package io.github.gawdserver.warps;


import io.github.gawdserver.api.Server;
import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandWarp implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "warps.use")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 1) {
            if (Warps.hasWarp(args[0])) {
                Server.sendCommand("tp " + player + " " + Warps.getWarp(args[0]));
            } else {
                // Broadcast so people don't think it goes somewhere.
                Chat.broadcast("Warp '" + args[0] + "' does not exist.");
            }
        } else {
            Chat.sendMessage(player, "Use: !warp <name>");
            Chat.sendMessage(player, "Warps: " + Warps.getWarpSet());
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        if (args.length >= 2) {
            if (Warps.hasWarp(args[1])) {
                Server.sendCommand("tp " + args[0] + " " + Warps.getWarp(args[1]));
            } else {
                // Broadcast so people don't think it goes somewhere.
                Chat.broadcast("Warp '" + args[1] + "' does not exist.");
            }
        } else {
            Chat.sendMessage(Sender.CONSOLE.name(), "Use: !warp <player> <name>");
            Chat.sendMessage(Sender.CONSOLE.name(), "Warps: " + Warps.getWarpSet());
        }
    }
}
