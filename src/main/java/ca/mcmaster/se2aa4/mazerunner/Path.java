package ca.mcmaster.se2aa4.mazerunner;

/**
 * Path keeps track of the runner's movements and provides a factorized representation of the path.
 */
public class Path {
    private String CanonizedPath = ""; // Stores the canonical path as a string

    /**
     * Adds a movement to the path.
     *
     * @param value The movement to add (e.g., "F", "R").
     */
    public void addPath(String value) {
        CanonizedPath = CanonizedPath + value;
    }

    /**
     * Gets the canonical path as a string.
     *
     * @return The canonical path.
     */
    public String getCanonizedPath() {
        return CanonizedPath;
    }

    /**
     * Gets the factorized representation of the path.
     * For example, "FFF" becomes "3F".
     *
     * @return The factorized path.
     */
    public String getFactorizedPath() {
        String FactorizedPath = "";
        String target = "";
        int repeats = 0;
        for (int i = 0; i < CanonizedPath.length(); i++) {
            if (target.equals(CanonizedPath.substring(i, i + 1))) {
                repeats++;
            } else {
                if (!target.equals("")) {
                    FactorizedPath += repeats + "" + target;
                }
                target = CanonizedPath.substring(i, i + 1);
                repeats = 1;
            }
        }
        FactorizedPath += repeats + "" + target;
        return FactorizedPath;
    }
}