package pages;

import server.Role;

import java.io.Serializable;

/**
 * Represents the Page of Statistics.
 */
public class PageStatistics extends Page implements Serializable {
    private static PageStatistics statistics = null;

    /**
     * Creates new PageStatistics.
     */
    PageStatistics() {
        super("Statistics", Role.ADMIN);

        content = "SITE STATISTICS:\n";
    }

    /**
     * Returns the instance of the PageStatistics.
      * @return the instance of the PageStatistics
     */
    public static Page getStatisticsPage() {
        if (statistics == null)
            statistics = new PageStatistics();

        return statistics;
    }
}
