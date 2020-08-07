package me.landervanlaer.littleprojects.mail;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * A class to read a .mbox file and do some things with it
 */
public class MboxReader {
    public MboxReader(String fileName) throws IOException {
        Scanner reader = new Scanner(new File(fileName));
        String prev = reader.nextLine();
        for(int i = 0; i < 10; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(prev);
            System.out.println(prev);

            String s = reader.nextLine();

            int j = 0;
            do {
                builder.append(s);
                builder.append('\n');
                s = reader.nextLine();
            } while(!s.startsWith("From") && j++ < 1000);
            System.out.println(prev);
//            \/\\:\*\?"<>\|
            prev = prev.replaceAll("[^a-zA-Z0-9-_.\\s'@]", "").substring("From ".length());

            PrintWriter pw = new PrintWriter("C:\\Users\\LanderVanLaer\\Documents\\MAIL\\new mails\\" + prev + ".mbox", StandardCharsets.UTF_8);
            pw.print(builder.toString());
            pw.close();
            builder.setLength(0);
            prev = s;
        }
    }

    public static void main(String[] args) throws IOException {
        new MboxReader("C:\\Users\\LanderVanLaer\\Documents\\MAIL\\mails.mbox");
    }
}
