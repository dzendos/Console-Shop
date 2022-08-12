package commands;

import server.Role;

import java.io.Serializable;

/**
 * Represents the Command.
 */
public abstract class Command implements Serializable {
    public Role accessRole  = null;

    /**
     * Executes the command.
     */
    public abstract void execute();

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    public abstract String getDescription();
}
