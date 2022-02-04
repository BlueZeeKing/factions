package io.icker.factions.command;

import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.suggestion.Suggestions;
import net.minecraft.server.command.ServerCommandSource;
import com.mojang.brigadier.context.CommandContext;
import java.util.concurrent.CompletableFuture;
import io.icker.factions.database.Faction;

import java.util.ArrayList;

public class FactionSuggestions implements SuggestionProvider<ServerCommandSource> {
  public CompletableFuture<Suggestions> getSuggestions(CommandContext<ServerCommandSource> context, SuggestionsBuilder builder) {
    ArrayList<Faction> factions = Faction.all();

    for (Faction F : factions) {
      builder.suggest(F.name);
    }

    return builder.buildFuture();
  }
}