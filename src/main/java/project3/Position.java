package project3;

/**
 * CIS 27C
 * Project 3
 * Andrew Headrick
 * June 2010
 */

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * All applicable positions on the baseball team roster.
 *
 * @author andy
 */
public enum Position {

    FIRST_BASE(1),
    SECOND_BASE(2),
    THIRD_BASE(3),
    SHORT_STOP(4),
    LEFT_FIELD(5),
    CENTER_FIELD(6),
    RIGHT_FIELD(7),
    UTILITY_INFIELDER(8),
    UTILITY_OUTFIELDER(9),
    MANAGER(10),
    BATTING_COACH(11),
    HITTING_COACH(12),
    BULLPEN_COACH(13),
    FIRST_BASE_COACH(14),
    THIRD_BASE_COACH(15),
    TRAINER(16),
    EQUIPMENT_MANAGER(17),
    CATCHER(18),
    PITCHER(19);
            
    private int cardinality;
    private static final Map<Integer, Position> map = new HashMap<Integer, Position>();

    // maintain a map of enums for easy lookup
    static {
        for (Position p : EnumSet.allOf(Position.class)) {
            map.put(p.getCardinality(), p);
        }
    }

    /**
     * Private constructor
     * @param card
     */
    private Position(int card) {
        cardinality = card;
    }

    public int getCardinality() {
        return cardinality;
    }

    /**
     * Return a position based on it's cardinality in list
     *
     * @param int card
     * @return Position
     */
    public static Position get(int card) {
        return map.get(card);
    }

    @Override
    public String toString() {
        return name();
    }

    /**
     * Return a string with all positions.
     *
     * @return String
     */
    public static String positions() {
        StringBuilder sb = new StringBuilder();
        for(Position p: EnumSet.allOf(Position.class)) {
            sb.append(p.name()).append(" (").append(p.getCardinality()).append("), ");
        }

        // return string without trailing comma and space
        return sb.toString().substring(0,sb.length() - 2);
    }
}
