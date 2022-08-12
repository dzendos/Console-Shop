package commands;

import client.Client;
import commands.actions.CmdCheckout;
import commands.actions.CmdGoToPage;
import commands.actions.CmdPutInShoppingCard;
import commands.editting.*;
import commands.siteInfo.*;
import commands.siteInterface.CmdAuthorize;
import commands.siteInterface.CmdQuit;
import commands.siteInterface.CmdRegister;
import server.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Command Factory.
 */
public class CommandFactory {
    private static CommandFactory factory = null;

    private static final Command emptyCommand = new CmdEmpty();

    private static final Map<String, Command> commands = new HashMap<>();

    public static List<Command> interfaceCommands = new ArrayList<>();

    public static Client client;

    /**
     * Creates new Command Factory.
     *
     * @param client the client in which the Command Factory is created
     */
    private CommandFactory(Client client) {

        this.client = client;

        commands.put("help",                 new CmdHelp(Role.GUEST));
        commands.put("quit",                 new CmdQuit(Role.GUEST));
        commands.put("print_possible_pages", new CmdPossiblePages(Role.ADMIN));
        commands.put("add_links",            new CmdAddLink(Role.ADMIN));
        commands.put("print_page_info",      new CmdPageInfo(Role.ADMIN));
        commands.put("print_attached_links", new CmdPrintAttachedLinks(Role.ADMIN));
        commands.put("go_to_page",           new CmdGoToPage(Role.GUEST));
        commands.put("register",             new CmdRegister(Role.GUEST));
        commands.put("authorize",            new CmdAuthorize(Role.GUEST));
        commands.put("get_registered_users", new CmdGetRegisteredUsers(Role.ADMIN));
        commands.put("remove_link",          new CmdRemoveLink(Role.ADMIN));
        commands.put("attach_commands",      new CmdAttachCommands(Role.ADMIN));
        commands.put("remove_command",       new CmdRemoveCommand(Role.ADMIN));
        commands.put("add_product",          new CmdAddProduct(Role.ADMIN));
        commands.put("remove_product",       new CmdRemoveProduct(Role.ADMIN));
        commands.put("my_shopping_card",     new CmdShowShoppingCard(Role.CLIENT));
        commands.put("add_item_in_card",     new CmdPutInShoppingCard(Role.CLIENT));
        commands.put("checkout",             new CmdCheckout(Role.CLIENT));
        commands.put("remove_product_from_list", new CmdRemoveFromShoppingList(Role.CLIENT, client));

        interfaceCommands.add(commands.get("print_attached_links"));
        interfaceCommands.add(commands.get("add_links"));
        interfaceCommands.add(commands.get("remove_link"));
        interfaceCommands.add(commands.get("attach_commands"));
        interfaceCommands.add(commands.get("remove_command"));

        interfaceCommands.add(commands.get("my_shopping_card"));
        interfaceCommands.add(commands.get("remove_product_from_list"));
        interfaceCommands.add(commands.get("checkout"));

        interfaceCommands.add(commands.get("authorize"));
        interfaceCommands.add(commands.get("register"));
        interfaceCommands.add(commands.get("quit"));
    }

    /**
     * Initializes the Command Factory.
     *
     * @param client the client in which the Command Factory is initialized
     */
    public static void initialize(Client client) {
        if (factory == null)
            factory = new CommandFactory(client);
    }

    public static Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Gets command from the String.
     *
     * @param stringCommand the given String
     * @return the command found
     */
    public static Command getCommandByStr(String stringCommand) {
        if (commands.containsKey(stringCommand))
            return commands.get(stringCommand);

        return emptyCommand;
    }
}
