package io.github.gawdserver.warps;


import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.perms.Permissions;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandSetWarp implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "warps.set")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 4) {
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            int z = Integer.parseInt(args[3]);
            Warps.setWarp(args[0], String.format("%d %d %d", x, y, z));
            Chat.sendMessage(player, "Warp '" + args[0] + "' has been set to location X:" + x + " Y:" + y + " Z:" + z);
        } else {
            Chat.sendMessage(player, "Use: !setwarp <name> <x> <y> <z>");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        if (args.length >= 4) {
            int x = Integer.parseInt(args[1]);
            int y = Integer.parseInt(args[2]);
            int z = Integer.parseInt(args[3]);
            Warps.setWarp(args[0], String.format("%d %d %d", x, y, z));
            Chat.sendMessage(Sender.CONSOLE.name(), "Warp '" + args[0] + "' has been set to location X:" + x + " Y:" + y + " Z:" + z);
        } else {
            Chat.sendMessage(Sender.CONSOLE.name(), "Use: !setwarp <name> <x> <y> <z>");
        }
    }
}
