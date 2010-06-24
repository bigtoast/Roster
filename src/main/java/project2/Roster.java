package project2;

/**
 * CIS 27C
 * Project 2
 * Andrew Headrick
 * May 2010
 */

/**
 * Roster.java
 *
 * The roster is backed be a simple array of Players. Players can be added,
 * removed, listed and looked up by last name or number. It is not thread safe.
 *
 */

public class Roster {
    private Player[] players = new Player[0];
    
    public Roster(Player[] players){
	add(players);
    }

    /**
     * lost a few points on the last assignment for not having a constructor
     * that takes in an object of the same type.
     *
     * @param Roster roster
     */
    public Roster(Roster roster){
        players = roster.getPlayers();
    }

    public Roster(){}

    /**
     * Add an array of players. If any of the players are already on the roster
     * they won't be added twice
     *
     * @param Player[] players
     */
    public void add(Player[] players){
	for(Player p : players)
	    add(p);
    }

    /**
     * Add a player to the roster. If the player is already on the roster, they
     * won't be added twice.
     *
     * @param Player player
     */
    public void add(Player player){
	// don't add the same player twice
        if(!contains(player)){
            Player[] newP = new Player[players.length + 1];
            System.arraycopy(players, 0, newP, 0, players.length);
            newP[players.length] = player;
            this.players = newP;
        }
    }
    
    /**
     * Remove player from roster. If the player is not on the roster the method
     * will return silently.
     *
     * @param Player player
     */
    public void remove(Player player){
        if(!contains(player))
            return;

	Player[] newP = new Player[players.length - 1];
	int j = 0;
	for(Player p : players){
	    if(!player.equals(p))
		newP[j++] = p;
	}
	this.players = newP;
    }

    /**
     * Is the player on the roster.
     *
     * @param Player player
     * @return boolean
     */
    public boolean contains(Player player){
        for(Player p: players){
            if(player.equals(p))
                return true;
        }
        return false;
    }
    
    /**
     * Many teams have multiple players with the same last
     * name which is why this returns an array. If no player exists on the
     * roster with the given name and empty array will be returned.
     *
     * @param String last name
     * @return Player[]
     */
    public Player[] getPlayerByLastName(String lastName){
	Player[] pa = new Player[0];
	for( Player p : players){
	  if(lastName.equals(p.getName().GetLast())) {
	      Player[] npa = new Player[pa.length + 1];
              System.arraycopy(pa, 0, npa, 0, pa.length);
              npa[pa.length] = p;
              pa = npa;
          }

      	}
	return pa;
    }

    /**
     * Look up a player by their number.
     *
     * Null will be returned if the player doesn't exist.
     *
     * @param String number
     * @return Player | null
     */
    public Player getPlayerByNumber(String num){
	for(Player p :players){
	    if(p.getNumber().equals(num))
		return p;
	}
	return null;
    }

    /**
     * Find players for a given position. This returns an array because there may
     * by more than one player for a given position.
     *
     * @param Position position
     * @return Player[]
     */
    public Player[] getPlayerByPosition(Position position){
        Player[] pa = new Player[0];
	for( Player p : players){
	  if(position.equals(p.getPosition())) {
	      Player[] npa = new Player[pa.length + 1];
              System.arraycopy(pa, 0, npa, 0, pa.length);
              npa[pa.length] = p;
              pa = npa;
          }

      	}
	return pa;
    }

    /**
     * Return number of players on roster.
     *
     * @return int
     */
    public int getPlayerCount(){ return players.length; }
    
    /**
     * Return an array of player. Note that this is not
     * the underlaying array so any changes to it will not
     * be relected in the roster.
     *
     * @return Player[]
     */
    public Player[] getPlayers() { 
	Player[] p = new Player[players.length];
	System.arraycopy(players,0,p,0,players.length);
	return p;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Team Roster: ").append(players.length).append(" players\n")
                .append("+-------------------------------+\n");
        for(Player p : players) {
           sb.append(p.toString());
           sb.append("\n+-------------------------------+\n");
        }
        return sb.toString();
    }
}