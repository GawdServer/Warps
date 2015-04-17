package tk.coolv1994.plugins.warps;

import tk.coolv1994.gawdapi.Gawd;
import tk.coolv1994.gawdapi.events.Command;
import tk.coolv1994.gawdapi.perms.Permissions;
import tk.coolv1994.gawdapi.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandWarp implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (!Permissions.hasPermission(player, "warps.use")) {
            Chat.sendMessage(player, "No permission.");
            return;
        }
        if (args.length >= 1) {
            if (Warps.hasWarp(args[0])) {
                Gawd.sendCommand("tp " + player + " " + Warps.getWarp(args[0]));
            } else {
                // Broadcast so people don't think it goes somewhere.
                Chat.broadcast("Warp '" + args[0] + "' does not exist.");
            }
        } else {
            Chat.sendMessage(player, "Use: !warp <name>");
            Chat.sendMessage(player, "Warps: " + Warps.getWarpSet());
        }
    }
}
