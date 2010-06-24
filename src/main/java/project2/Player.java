package project2;

/**
 * CIS 27C
 * Project 2
 * Andrew Headrick
 * May 2010
 */

/**
 * Player class.
 *
 * A player can be anyone on the team roster including non-field players like
 * manager and equipment manager.
 * 
 * @author andy
 */
public class Player {
    private ShortName name;
    private String number;
    private Position position;
    private Double battingAverage;
    private Double era;
    private String hometown;
    private String highSchool;

    
    public final void setName(ShortName name) {
	this.name = name;
    }

    public final ShortName getName(){
	return name;
    }

    /**
     * Gets the value of number
     *
     * @return the value of number
     */
    public final String getNumber() {
	return this.number;
    }

    /**
     * Sets the value of number
     *
     * @param argNumber Value to assign to this.number
     */
    public final void setNumber(final String argNumber) {
	this.number = argNumber;
    }

    /**
     * Gets the value of position
     *
     * @return the value of position
     */
    public final Position getPosition() {
	return this.position;
    }

    /**
     * Sets the value of position
     *
     * @param argPosition Value to assign to this.position
     */
    public final void setPosition(final Position argPosition) {
	this.position = argPosition;
    }

    /**
     * Gets the value of battingAverage
     *
     * @return the value of battingAverage
     */
    public final Double getBattingAverage() {
	return this.battingAverage;
    }

    /**
     * Sets the value of battingAverage
     *
     * @param argBattingAverage Value to assign to this.battingAverage
     */
    public final void setBattingAverage(final Double argBattingAverage) {
	this.battingAverage = argBattingAverage;
    }

    /**
     * Gets the value of era
     *
     * @return the value of era
     */
    public final Double getEra() {
	return this.era;
    }

    /**
     * Sets the value of era
     *
     * @param argEra Value to assign to this.era
     */
    public final void setEra(final Double argEra) {
	this.era = argEra;
    }

    /**
     * Gets the value of hometown
     *
     * @return the value of hometown
     */
    public final String getHometown() {
	return this.hometown;
    }

    /**
     * Sets the value of hometown
     *
     * @param argHometown Value to assign to this.hometown
     */
    public final void setHometown(final String argHometown) {
	this.hometown = argHometown;
    }

    /**
     * Gets the value of highSchool
     *
     * @return the value of highSchool
     */
    public final String getHighSchool() {
	return this.highSchool;
    }

    /**
     * Sets the value of highSchool
     *
     * @param argHighSchool Value to assign to this.highSchool
     */
    public final void setHighSchool(final String argHighSchool) {
	this.highSchool = argHighSchool;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName().toString())
                .append("\nPosition: ").append(getPosition())
                .append("\nNumber: ").append(getNumber())
                .append("\nHometown: ").append(getHometown())
                .append("\nHigh School: ").append(getHighSchool())
                .append("\nBatting Average: ").append(getBattingAverage())
                .append("\nERA: ").append(getEra());
        return sb.toString();
    }

}