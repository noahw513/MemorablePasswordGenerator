import org.apache.commons.cli.*;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) {
        boolean optionSpecCharBool;
        int optionWordCount;
        String parsedWordCount;
        StringBuilder stdOutPass;
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
                MemorablePasswordGenerator memPass = new MemorablePasswordGenerator(optionWordCount, optionSpecCharBool);
                stdOutPass = memPass.genPass();
                System.out.println(stdOutPass);
            } if(cmd.hasOption("c") && !cmd.hasOption("s")) {
                optionSpecCharBool = false;
                parsedWordCount = cmd.getOptionValue("c");
                optionWordCount = parseInt(parsedWordCount);
                MemorablePasswordGenerator memPass = new MemorablePasswordGenerator(optionWordCount, optionSpecCharBool);
                stdOutPass = memPass.genPass();
                System.out.println(stdOutPass);
            } if(cmd.hasOption("s") && !cmd.hasOption("c")) {
                optionSpecCharBool = true;
                parsedWordCount = "3";
                optionWordCount = parseInt(parsedWordCount);
                MemorablePasswordGenerator memPass = new MemorablePasswordGenerator(optionWordCount, optionSpecCharBool);
                stdOutPass = memPass.genPass();
                System.out.println(stdOutPass);
            } if(!cmd.hasOption("c") && !cmd.hasOption("s")) {
                optionWordCount = 3;
                optionSpecCharBool = false;
                MemorablePasswordGenerator memPass = new MemorablePasswordGenerator(optionWordCount, optionSpecCharBool);
                stdOutPass = memPass.genPass();
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

