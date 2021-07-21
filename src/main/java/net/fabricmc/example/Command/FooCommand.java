package net.fabricmc.example.Command;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.example.Entity.CookieCreeperEntityModelBuilder;
import net.fabricmc.example.Entity.ZombieEntityModelBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class FooCommand implements CommandRegistrationCallback {

    public int count = 0;

    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("foo").executes(context -> {

            CookieCreeperEntityModelBuilder.CONFIG.read();
            ZombieEntityModelBuilder.CONFIG.read();

            System.out.println("cookie_creeper_"+count++);

            return 1;
        }));
    }
}
