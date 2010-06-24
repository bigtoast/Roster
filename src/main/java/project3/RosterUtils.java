/**
 * CIS 27C
 * Project 3
 * Andrew Headrick
 * June 2010
 */

package project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.Reader;


/**
 *
 * @author andy
 */
public class RosterUtils {
    private static String SEP = "|";

    public static void writeTo(Player p, Writer writer) throws IOException {
        PrintWriter pw = new PrintWriter(writer);
        StringBuilder sb = new StringBuilder();
        sb.append(p.getName().GetFirst()).append(SEP)
            .append(p.getName().GetLast()).append(SEP)
            .append(p.getNumber()).append(SEP)
            .append(p.getPosition()).append(SEP)
            .append(p.getAtBats()).append(SEP)
            .append(p.getHits()).append(SEP)
            .append(p.getEarnedRuns()).append(SEP)
            .append(p.getInningsPitched()).append(SEP)
            .append(p.getHometown()).append(SEP)
            .append(p.getHighSchool()).append(SEP);

       pw.println(sb.toString());
    }

    public static void writeTo(Roster r, Writer writer) throws IOException {
        for(Player p: r.getPlayers()){
            writeTo(p, writer);
        }
        writer.flush();
    }

    public static Player readFrom(String str) {
        String[] vals = str.split("[|]");
        Player p = new Player();
        p.setName(new ShortName(vals[0], vals[1]));
        p.setNumber(vals[2]);
        p.setPosition(Position.valueOf(vals[3]));
        p.setAtBats(Integer.valueOf(vals[4]).intValue());
        p.setHits(Integer.valueOf(vals[5]).intValue());
        p.setEarnedRuns(Integer.valueOf(vals[6]).intValue());
        p.setInningsPitched(Integer.valueOf(vals[7]).intValue());
        p.setHometown(vals[8]);
        p.setHighSchool(vals[9]);
        return p;
    }
    
    public static Roster readFrom(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        Roster r = new Roster();
        String str;
        while(true){
            if((str = br.readLine()) == null)
                break;

            r.add(readFrom(str));
        }
        
        return r;
    }

}
