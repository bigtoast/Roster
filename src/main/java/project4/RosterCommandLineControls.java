package project4;

/**
 * CIS 27C
 * Project 4
 * Andrew Headrick
 * June 2010
 */

import java.io.*;

public class RosterCommandLineControls {

    public static void main(String[] args){
        Roster roster = new Roster();
	Console console = System.console();
        
        console.writer().println("\nWelcome to Project 4 Roster!!\n");

	String command;

	do {
            displayHelp(console);
	    command = console.readLine("> ");

	    switch (command.charAt(0)) {
	    case 'a' :
		addPlayer(console, roster);
		break;
	    case 'r' :
		removePlayer(console, roster);
		break;
	    case 'p' :
		printRoster(console, roster);
		break;
	    case 'f' :
		findPlayer(console, roster);
		break;
            case 's' :
                saveRoster(console, roster);
                break;
            case 'o':
                Roster r = openRoster(console);
                if (r != null)
                    roster = r;
                break;
            case 'v':
                teamAverage(console, roster);
                break;
            case 'e':
                teamEra(console, roster);
                break;
	    case '?' :
		displayHelp(console);
                break;
            default:
                displayHelp(console);
                break;
		
	    }

	} while ( !"q".equals(command) );

	
    }

    public static void saveRoster(Console console, Roster roster) {
        String path = console.readLine("Enter file path and name: ");
        try{
            FileWriter fw = new FileWriter(path);
            RosterUtils.writeTo(roster, fw);
            fw.close();
        } catch( Exception e){
            console.writer().println("Save failed due to: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        console.writer().println("Roster saved to: " + path);

    }

    public static Roster openRoster(Console console) {
        String path = console.readLine("Enter file path and name: ");
        try {
            return RosterUtils.readFrom(new FileReader(path));
        } catch (Exception e){
            console.writer().println("Open roster failed due to: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static void printRoster(Console console, Roster roster) {
	console.writer().println(roster.toString());
    }

    public static void displayHelp(Console console) {
	console.writer().println("\nAdd Player (a), Remove Player (r), Print Roster (p), Find Player (f), Team Batting Ave (v), Team ERA (e), Save Roster (s), Open Roster (o), Display Help (?), Quit (q)\n");
    }
    
    public static void removePlayer(Console console, Roster roster) {
	String num = console.readLine("Enter the number of the player you wish to remove: ");
	Player p = roster.getPlayerByNumber(num);
	if(p == null)
	    console.writer().println("No player for that number is on the roster.");
	else
	    roster.remove(p);
    }

    public static void addPlayer(Console console, Roster roster) {

	String fn = console.readLine("Enter a first name: ");
	String ln = console.readLine("Enter a last name: ");
	String num = console.readLine("Enter a number: ");
	Position position = Position.get(Integer.valueOf(console.readLine("Enter a position code: \n" + Position.positions() + " : ")));
	String home = console.readLine("Enter a hometown: ");
	String high = console.readLine("Enter a high school: ");
        int atBats = Integer.valueOf(console.readLine("Enter at bats: ")).intValue();
	int hits = Integer.valueOf( console.readLine("Enter hits: ")).intValue();
        int inningsPitched = 0;
        int earnedRuns = 0;
        if(Position.PITCHER.equals(position)){
            earnedRuns = Integer.valueOf(console.readLine("Enter earned runs: ")).intValue();
            inningsPitched = Integer.valueOf(console.readLine("Enter innings pitched: ")).intValue();
        }

	StringBuilder sb = new StringBuilder();
	sb.append("\n\nFirst Name: ").append(fn)
	    .append("\nLastName: ").append(ln)
	    .append("\nNumber: ").append(num)
	    .append("\nPosition: ").append(position.name())
	    .append("\nHometown: ").append(home)
	    .append("\nHigh School: ").append(high)
	    .append("\nAt Bats: ").append(atBats)
            .append("\nHits: ").append(hits);
        if(Position.PITCHER.equals(position)){
            sb.append("\nInnings Pitched: ").append(inningsPitched)
              .append("\nEarned Runs: ").append(earnedRuns);
        }
        sb.append("\n\nPlease confirm (y/n): Create Player? \n\n");

	String yn = console.readLine(sb.toString());

	if("y".equalsIgnoreCase(yn)){
	    Player p = new Player();
	    p.setName(new ShortName(fn, ln));
	    p.setNumber(num);
	    p.setPosition(position);
	    p.setHometown(home);
	    p.setHighSchool(high);
	    p.setHits(hits);
            p.setAtBats(atBats);
            p.setInningsPitched(inningsPitched);
            p.setEarnedRuns(earnedRuns);
	    
	    roster.add(p);
            console.writer().println(p.getName().toString() + " added to Roster.\n\n");
            return;
	}

        console.writer().println("Player NOT added to Roster.\n\n");
    }

    public static void findPlayer(Console console, Roster roster) {
        String numOrLn = console.readLine("Enter the number or last name of the player: ");

        if(numOrLn.trim().matches("^\\d+$")){
            Player p = roster.getPlayerByNumber(numOrLn.trim());
            if(p != null)
            console.writer().println(p.toString());
            return;
        } else {
            Player[] pp = roster.getPlayerByLastName(numOrLn.trim());
            console.writer().println(pp.length + " players found");

            for(Player p : pp){
                console.writer().println(p.toString());
            }
        }
        
    }

    public static void teamAverage(Console console, Roster roster) {
        console.writer().println("Team batting average: " + roster.average());
    }

    public static void teamEra(Console console, Roster roster) {
        console.writer().println("Team earned runs average: " + roster.era());
    }
}