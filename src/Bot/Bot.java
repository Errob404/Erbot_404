package Bot;

import Domain.PokemonGame.PlayerDB.DB;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot
{
    public static JDA jda;
    public static String prefix = "!";

    //Main method
    public static void main(String[] args) throws LoginException {
        //Activeer bot
        JDABuilder builder = JDABuilder.createDefault("ODE1OTU1MzEwODYxNzQ2MTg2.YDz7mQ.J7sOugZMd6gUD6NLnIO8KgWU96Y");
        jda = builder.build();

        //Status
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setActivity(Activity.playing("---Getting a upgrade---"));

        //Events
        jda.addEventListener(new Commands());
        jda.addEventListener(new Events());
    }
}
