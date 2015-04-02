package tk.coolv1994.plugins.warps;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.perms.Permissions;
import tk.coolv1994.gawdserver.utils.Chat;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandSetWarp implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (Permissions.getPermManager().hasPermission(player, "warp.setwarp")) {
            if (args.length >= 4) {
                int x = Integer.parseInt(args[1]);
                int y = Integer.parseInt(args[2]);
                int z = Integer.parseInt(args[3]);
                Warps.warps.setProperty(args[0], String.format("%d %d %d", x, y, z));
                Chat.sendMessage(player, "Warp '" + args[0] + "' has been set to location X:" + x + " Y:" + y + " Z:" + z);
            } else {
                Chat.sendMessage(player, "Use: !setwarp <name> <x> <y> <z>");
            }
        }
    }
}
