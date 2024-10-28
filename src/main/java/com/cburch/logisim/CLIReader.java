package com.cburch.logisim;

import com.cburch.logisim.file.LoadFailedException;
import com.cburch.logisim.file.Loader;
import com.cburch.logisim.file.LogisimFile;
import com.cburch.logisim.proj.Project;

import java.io.File;
import java.util.Map;

public class CLIReader {
    static void read(File fileToOpen) {
//        final var fileToOpen = args.getFilesToOpen().get(0);
        final var loader = new Loader(null);
        LogisimFile file;
        try {
//            file = loader.openLogisimFile(fileToOpen, args.getSubstitutions());
            file = loader.openLogisimFile(fileToOpen, Map.of());
        } catch (LoadFailedException e) {
//            logger.error("{}", S.get("ttyLoadError", fileToOpen.getName()));
            System.exit(-1);
            return;
        }
        final var proj = new Project(file);
//        if (args.isFpgaDownload()) {
//            if (!args.fpgaDownload(proj)) System.exit(-1);
//        }

//        final var circuitToTest = args.getCircuitToTest();
//        final var circuit = (circuitToTest == null || circuitToTest.length() == 0)
//                ? file.getMainCircuit()
//                : file.getCircuit(circuitToTest);
        final var circuit = file.getMainCircuit();
        System.out.println(circuit.getComponents());

//        var format = args.getTtyFormat();
//        if ((format & FORMAT_STATISTICS) != 0) {
//            format &= ~FORMAT_STATISTICS;
//            displayStatistics(file, circuit);
//        }
//        if (format == 0) { // no simulation remaining to perform, so just exit
//            System.exit(0);
//        }
    }
}
