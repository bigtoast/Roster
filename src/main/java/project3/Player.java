package project3;

/**
 * CIS 27C
 * Project 3
 * Andrew Headrick
 * June 2010
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
    private int hits = 0;
    private int atBats = 0;
    private int earnedRuns = 0;
    private int inningsPitched = 0;
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
    public final double getBattingAverage() {
	return atBats == 0 ? 0 : (double)hits / (double)atBats;
    }

    /**
     * Sets the value of hits
     *
     * @param hits
     */
    public final void setHits(int hits) {
	this.hits = hits;
    }

    public int getHits() {
        return hits;
    }

    public int getAtBats() {
        return atBats;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    public int getEarnedRuns() {
        return earnedRuns;
    }

    public void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    public int getInningsPitched() {
        return inningsPitched;
    }

    public void setInningsPitched(int inningsPitched) {
        this.inningsPitched = inningsPitched;
    }



    /**
     * Gets the value of era
     *
     * @return the value of era
     */
    public final double getEra() {
	return inningsPitched == 0 ? 0 : (double)(earnedRuns * 9) / (double)inningsPitched;
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
                .append("\nAt Bats: " + atBats + " Hits: " + hits)
                .append("\nBatting Average: ").append(getBattingAverage())
                .append("\nERA: ").append(getEra());
        return sb.toString();
    }

}