package me.acclashcorporation.crucialplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (args.length == 0){
                player.sendMessage(ChatColor.RED + "You need to enter some arguments");
                player.sendMessage(ChatColor.YELLOW + "To teleport yourself: /tp <otherplayer>");
                player.sendMessage(ChatColor.YELLOW + "To teleport others: /tp <player> <otherplayer>");
            }else if (args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);


                try{
                    player.teleport(target.getLocation());
                }catch(NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "Player does not exist.");
                }
            }else if (args.length == 2){
                //first player
                Player playerToSend = Bukkit.getPlayer(args[0]);
                Player target = Bukkit.getPlayer(args[1]);
                try{
                    playerToSend.teleport(target.getLocation());
                }catch(NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "Player does not exist.");
                }
            }

        }



        return true;
    }
}
