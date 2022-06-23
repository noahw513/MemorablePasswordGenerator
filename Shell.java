import org.apache.commons.cli.*;
import static java.lang.Integer.parseInt;

public class Shell {
    public static void main(String[] args) {
        // if no count given, default to 3
        // if no spec char bool, default to false
        // Options options = new Options();
        boolean DEBUG, optionSpecCharBool;
        DEBUG = false;
        int optionWordCount;
        String parsedWordCount;
        StringBuilder stdOutPass = new StringBuilder();
        Options options = new Options();
        options.addOption(Option.builder("c")
                .longOpt("--word-count")
                .hasArg(true)
                .desc("Number of words used in password. Defaults to 3 if not provided.")
                .required(false)
                .build());
        options.addOption(Option.builder("s")
                .longOpt("--special-character")
                .hasArg(false)
                .desc("Specifies if a special character should be appended to the password. Defaults to false.")
                .required(false)
                .build());
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption("c") && cmd.hasOption("s")) {
                parsedWordCount = cmd.getOptionValue("c");
                optionWordCount = parseInt(parsedWordCount);
                optionSpecCharBool = true;
                if(DEBUG) {
                    System.out.println("Options c & s present.");
                    System.out.println("parsedWordCount - " + parsedWordCount);
                    System.out.println("optionSpecCharBool - " + optionSpecCharBool);
                }
                stdOutPass = memorablePasswordGenerator.genMemPass(optionWordCount, optionSpecCharBool);
                System.out.println(stdOutPass);
            }
            if(cmd.hasOption("c") && !cmd.hasOption("s")) {
                optionSpecCharBool = false;
                parsedWordCount = cmd.getOptionValue("c");
                optionWordCount = parseInt(parsedWordCount);
                if(DEBUG) {
                    System.out.println("Option c present.");
                    System.out.println("parsedWordCount - " + parsedWordCount);
                }
                stdOutPass = memorablePasswordGenerator.genMemPass(optionWordCount, optionSpecCharBool);
                System.out.println(stdOutPass);
            }
            if(cmd.hasOption("s") && !cmd.hasOption("c")) {
                optionSpecCharBool = true;
                parsedWordCount = "3";
                optionWordCount = parseInt(parsedWordCount);
                if(DEBUG) {
                    System.out.println("Option s present.");
                    System.out.println("ParsedWordCount - " + parsedWordCount);
                    System.out.println("optionSpecCharBool - " + optionSpecCharBool);
                }
                stdOutPass = memorablePasswordGenerator.genMemPass(optionWordCount, optionSpecCharBool);
                System.out.println(stdOutPass);
            }
            if(cmd.hasOption("")) {
                optionWordCount = 3;
                optionSpecCharBool = false;
                if(DEBUG) {
                    System.out.println("No options present.");
                }
                stdOutPass = memorablePasswordGenerator.genMemPass(optionWordCount, optionSpecCharBool);
                System.out.println(stdOutPass);
            }
        } catch(ParseException parseException) {
            parseException.printStackTrace();
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("", options);
            System.exit(1);
        }
    }
}
