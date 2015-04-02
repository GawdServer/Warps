package tk.coolv1994.plugins.warps;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.launcher.Launch;
import tk.coolv1994.gawdserver.utils.Chat;

import java.util.Arrays;

/**
 * Created by Vinnie on 2/17/2015.
 */
public class CommandWarp implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        if (args.length >= 1) {
            if (Warps.warps.containsKey(args)) {
                Launch.sendCommand("tp " + player + " " + Warps.warps.getProperty(args[0]));
            } else {
                // Broadcast so people don't think it goes somewhere.
                Chat.broadcast("Warp '" + args[0] + "' does not exist.");
            }
        } else {
            Chat.sendMessage(player, "Use: !warp <name>");
            Chat.sendMessage(player, "Warps: " + Arrays.toString(Warps.warps.keySet().toArray()));
        }
    }
}
