package project2;

/**
 * CIS 27C
 * Project 2
 * Andrew Headrick
 * May 2010
 */

import java.io.*;

public class RosterCommandLineControls {

    public static void main(String[] args){
        Roster roster = new Roster();
	Console console = System.console();

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
	    case '?' :
		displayHelp(console);
                break;
            default:
                displayHelp(console);
                break;
		
	    }

	} while ( !"q".equals(command) );

	
    }

    public static void printRoster(Console console, Roster roster) {
	console.writer().println(roster.toString());
    }

    public static void displayHelp(Console console) {
	console.writer().println("\nAdd Player (a), Remove Player (r), Print Roster (p), Find Player (f), Display Help (?), Quit (q)\n");
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
	Position position = Position.get(Integer.valueOf(console.readLine("Enter a position code: \n" + Position.positions())));
	String home = console.readLine("Enter a hometown: ");
	String high = console.readLine("Enter a high school: ");
	Double ave = Double.valueOf(console.readLine("Enter a batting average: "));
	Double era = Double.valueOf(console.readLine("Enter an era: "));

	StringBuilder sb = new StringBuilder();
	sb.append("\n\nFirst Name: ").append(fn)
	    .append("\nLastName: ").append(ln)
	    .append("\nNumber: ").append(num)
	    .append("\nPosition: ").append(position.name())
	    .append("\nHometown: ").append(home)
	    .append("\nHigh School: ").append(high)
	    .append("\nBatting Average: ").append(ave.toString())
	    .append("\nERA: ").append(era.toString())
            .append("\n\nPlease confirm (y/n): Create Player? \n\n");

	String yn = console.readLine(sb.toString());

	if("y".equalsIgnoreCase(yn)){
	    Player p = new Player();
	    p.setName(new ShortName(fn, ln));
	    p.setNumber(num);
	    p.setPosition(position);
	    p.setHometown(home);
	    p.setHighSchool(high);
	    p.setEra(era);
	    p.setBattingAverage(ave);
	    
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
}