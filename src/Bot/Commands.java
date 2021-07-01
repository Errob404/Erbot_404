package Bot;

import Domain.PokemonGame.Player.Player;
import Domain.PokemonGame.PlayerDB.DB;
import Domain.PokemonGame.SuperPokemon.Pokemon;
import Domain.PokemonGame.SuperPokemon.Pokemons.Bulbasaur;
import Domain.PokemonGame.SuperPokemon.Pokemons.Charmander;
import Domain.PokemonGame.SuperPokemon.Pokemons.Squirtle;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Commands extends ListenerAdapter
{
    DB database = new DB();
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        // Informatie display
        if (args[0].equalsIgnoreCase(Bot.prefix + "info"))
        {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Erbot 404 Information");
            info.setDescription("Informatie over de functies van de bot");
            info.setColor(0xff0000);
            info.setFooter("Created by Errob 404", event.getMember().getUser().getAvatarUrl());

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
        }

        // Apply for role
        if (args[0].equalsIgnoreCase(Bot.prefix + "roles"))
        {
            EmbedBuilder roles = new EmbedBuilder();

            roles.setColor(Color.red);
            roles.setTitle("Rollen");
            roles.setDescription("Hier kan je je aanmelden voor een rol");
            roles.addField("One time only", ":one:", false);
            roles.addField("Among us", ":two:", false);
            roles.addField("Regular visitor", ":three:", false);

            MessageEmbed message = roles.build();

            event.getChannel().sendMessage(message).queue(reaction -> {
                reaction.addReaction("U+0031 U+20E3").queue();
                reaction.addReaction("U+0032 U+20E3").queue();
                reaction.addReaction("U+0033 U+20E3").queue();
            });
        }

        //Charmander test
        if (args[0].equalsIgnoreCase(Bot.prefix + "Charmander"))
        {
            MessageEmbed mes = new Charmander().giveInfo();
            event.getChannel().sendMessage(mes).queue();
        }

        //Squirtle
        if (args[0].equalsIgnoreCase(Bot.prefix + "squirtle"))
        {
            MessageEmbed mes = new Squirtle().giveInfo();
            event.getChannel().sendMessage(mes).queue();
        }

        //register player
        if (args[0].equalsIgnoreCase(Bot.prefix + "register"))
        {
            database.registerPlayer(event.getAuthor().getName());
            event.getChannel().sendMessage( event.getAuthor().getAsMention()+ ", succesfully registered as a new pokemon player").queue();
        }

        //give playerinfo
        if (args[0].equalsIgnoreCase(Bot.prefix + "playerinfo"))
        {
            Player player = database.getPlayer(event.getAuthor().getName());
            if (player == null){
                notregisteredMessage(event);
            } else {
                MessageEmbed mes = player.getPlayerInfo();
                event.getChannel().sendMessage(mes).queue();
            }
        }

        //Add pokemon
        if (args[0].equalsIgnoreCase(Bot.prefix + "addpokemon"))
        {
            if (args.length != 2){
                event.getChannel().sendMessage("This command was used incorrectly").queue();
                event.getChannel().sendMessage("The correct format is !addPokemon 'PokemonName'").queue();
            } else {
                String pokemonName = args[1];
                Player player = database.getPlayer(event.getAuthor().getName());
                if (player == null) {
                    notregisteredMessage(event);
                }
                boolean addedPokemon = false;
                if (pokemonName.equalsIgnoreCase("Charmander")) {
                    player.addPokemonToTeam(new Charmander());
                    event.getChannel().sendMessage("Succesfully registered a new Charmander").queue();
                    addedPokemon = true;
                } else if (pokemonName.equalsIgnoreCase("Squirtle")) {
                    player.addPokemonToTeam(new Squirtle());
                    event.getChannel().sendMessage("Succesfully registered a new Squirtle").queue();
                    addedPokemon = true;
                } else if (pokemonName.equalsIgnoreCase("Bulbasaur")) {
                    player.addPokemonToTeam(new Bulbasaur());
                    event.getChannel().sendMessage("Succesfully registered a new Bulbasaur").queue();
                    addedPokemon = true;
                }
                if (!addedPokemon) {
                    event.getChannel().sendMessage("The chosen Pokemon was not found, please try a valid name").queue();
                    event.getChannel().sendMessage("All valid Pokemon can be found using the !allPokemons command").queue();
                }
            }
        }

        //Nickname pokemon
        if (args[0].equalsIgnoreCase(Bot.prefix + "nickname"))
        {
            if (args.length != 3){
                event.getChannel().sendMessage("Incorrect usage, please use as following: !nickname pokemonnumber(1-6) Nickname, nickname cant contain spaces").queue();
            } else {
                Player player = database.getPlayer(event.getAuthor().getName());
                int pokemonNumber = Integer.parseInt(args[1]) - 1;
                try {
                    Pokemon pokemon = player.getTeam().get(pokemonNumber);
                    pokemon.setNaam(args[2]);
                    event.getChannel().sendMessage("Succesfully changed nickname").queue();
                } catch (IndexOutOfBoundsException exc){
                    event.getChannel().sendMessage("You picked a number that doesnt exist in your team").queue();
                }
            }
        }

        //Add role to member
        //To be continued
    }

    public void notregisteredMessage(GuildMessageReceivedEvent event){
        event.getChannel().sendMessage("You have not yet registered as a pokemon player.").queue();
        event.getChannel().sendMessage("If you want to register, you can use the !register command").queue();
    }

}
