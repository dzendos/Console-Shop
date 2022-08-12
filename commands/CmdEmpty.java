package commands;

import java.io.Serializable;

/**
 * Represents Empty Command.
 */
public class CmdEmpty extends Command implements Serializable {

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("Such commands.Command does not exist");
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Uses when user enter not correct command name";
    }
}
