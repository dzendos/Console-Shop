package server;

import java.io.Serializable;

/**
 * Determine roles of the user.
 */
public enum Role implements Serializable {
    ADMIN,
    CLIENT,
    GUEST
}
