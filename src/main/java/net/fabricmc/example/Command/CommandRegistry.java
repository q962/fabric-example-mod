package net.fabricmc.example.Command;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class CommandRegistry {

    public static void register(){
        CommandRegistrationCallback.EVENT.register(new FooCommand());
    }
}
