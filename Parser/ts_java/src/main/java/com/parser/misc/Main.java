package com.parser.misc;

import com.parser.listener.TSCustomListener;
import com.parser.model.ContentEntry;
import com.parser.model.ProgramResult;
import com.parser.util.ClassSetupUtils;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        // https://mincong.io/2019/08/06/introduction-to-commons-cli/
        // CLI Handling 
        Options options = new Options();
        Option optHelp = Option.builder("h")
                .longOpt("help")
                .desc("Prints help")
                .build();
        options.addOption(optHelp);

        options.addOption("in", "input", true, "Path to input file");

        options.addOption("out", "output", true, "Path to output directory, needs slash in the end");

        Option optVerbose = Option.builder("v")
                .longOpt("verbose")
                .desc("Verbose output")
                .build();
        options.addOption(optVerbose);

        Option optClean = Option.builder("clean")
                .longOpt("cleanOutputDir")
                .desc("Clean output directory")
                .build();
        options.addOption(optClean);

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = commandLineParser.parse(options, args);
        } catch (ParseException e) {
            System.out.println("Can't read command line. Reason " + e.getMessage());
        }
        // ----------------
        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("cmd", options, true);
            return;
        }

        boolean needCleanUp = false;
        if (cmd.hasOption("clean")) {
            needCleanUp = true;
        }
        // ----------------

        String pathOut = "";
        if (cmd.hasOption("out")) {
            pathOut = cmd.getOptionValue("out");
            // Returns if the option doesn't exist in the command line
            if (StringUtils.isNotBlank(pathOut)) {
                System.out.println("Output files will be created in " + pathOut);
                File out = new File(pathOut);
                if (out.exists()) {
                    System.out.println("Output path exists " + pathOut);
                    if (!out.isDirectory()) {
                        System.out.println("Output path isn't a folder, exiting");
                        return;
                    }
                    if (needCleanUp) {

                        try {
                            FileUtils.deleteDirectory(out);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        out.mkdirs();
                    }

                } else {
                    System.out.println("Output path doesn't exist " + pathOut);
                    System.out.println("Creating it");
                    out.mkdirs();
                }

            } else {
                System.out.println("You didn't specify output folder! Exiting");
                return;

            }
        } else {
            System.out.println("You didn't specify option out with output folder! Exiting");
            return;
        }

        // Reading input file
        BufferedReader inReader = null;
        if (cmd.hasOption("in")) {
            String pathIn = cmd.getOptionValue("in");
            // Returns null if the option doesn't exist in the command line
            if (StringUtils.isNotBlank(pathIn)) {
                try {
                    inReader = new BufferedReader(new FileReader(new File(pathIn)));
                } catch (FileNotFoundException e) {
                    System.out.println("File " + pathIn + " not found!");
                    e.printStackTrace();
                }
            } else {
                System.out.println("You didn't specify input file! Will read from stdin");
                inReader = new BufferedReader(new InputStreamReader(System.in));
            }
        } else {
            System.out.println("You didn't specify option in with input file! Will read from stdin");
            inReader = new BufferedReader(new InputStreamReader(System.in));
        }

        StringBuffer stringBuffer = new StringBuffer();
        inReader.lines().forEach(line -> {
            stringBuffer.append(line + System.lineSeparator().toString());
        });
        String sample = stringBuffer.toString();

        // Creating a listener, to process the input file
        TSCustomListener listener = ClassSetupUtils.setupTsListener(sample, cmd.hasOption("v"));

        ProgramResult result = listener.getProgramResult();
        Map<String, List<ContentEntry>> mapForOutput = result.getMapForOutput();

        // Iterating through the dictionary. Key = file name and refers to the list of text blocks to be output
        for (Map.Entry<String, List<ContentEntry>> entry : mapForOutput.entrySet()) {
            System.out.println("dealing with file " + entry.getKey());
            String filename = entry.getKey();
            List<ContentEntry> contentList = entry.getValue();
            // Sorting text blocks belonging to each file according to their position
            Collections.sort(contentList, Comparator.comparingInt(ContentEntry::getPosition));

            String fullPath = pathOut + File.separator + filename;
            File fileOutput = new File(fullPath);
            // Creating dirs for output file
            fileOutput.getParentFile().mkdirs();

            // This class will add two chars "new line" after each text block
            StringJoiner stringJoiner = new StringJoiner("\n\n");
            contentList.forEach(contentEntry -> stringJoiner.add(contentEntry.getContent()));

            try (FileOutputStream fooStream = new FileOutputStream(fileOutput, false)) { // "false" => rewrite of file
                byte[] myBytes = stringJoiner.toString().getBytes();
                // Writing output file
                fooStream.write(myBytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
