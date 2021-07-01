package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Events extends ListenerAdapter
{
    public void onGuildMemberJoin(GuildMemberJoinEvent event)
    {
        String naam = event.getMember().getAsMention();
        String message = "Hallo " + naam + ", welkom in de server";

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.RED);
        join.setDescription(message);

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event)
    {
        String naam = event.getMember().getAsMention();
        String message = naam + "heeft de server verlaten, kinda sus 🤔";

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.ORANGE);
        join.setDescription(message);

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }

    /*public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        event.getMessage().addReaction(":red:776722667721850911").queue();
    }*/



}
