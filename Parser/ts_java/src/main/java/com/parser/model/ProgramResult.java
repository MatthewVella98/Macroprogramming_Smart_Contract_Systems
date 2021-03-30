package com.parser.model;

import java.io.File;
import java.util.*;

// This is a wrapper class, represents the result of translation.
public class ProgramResult implements ParsingResultInterface {

    private List<ParsingResultInterface> logicItems = new ArrayList<>();

    private List<ParsingResultInterface> dataItems = new ArrayList<>();

    public List<ParsingResultInterface> getDataItems() {
        return dataItems;
    }

    public List<ParsingResultInterface> getLogicItems() {
        return logicItems;
    }

    public void setLogicItems(List<ParsingResultInterface> logicItems) {
        this.logicItems = logicItems;
    }

    public void setDataItems(List<ParsingResultInterface> dataItems) {
        this.dataItems = dataItems;
    }

    @Override
    public String translate() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("program {\n\n");

        StringJoiner stringJoiner = new StringJoiner("\n\n");
        if (logicItems != null) {
            logicItems.forEach(item -> {
                stringJoiner.add(item.translate());
            });
        }

        stringBuilder.append(stringJoiner.toString());

        if (dataItems != null) {
            dataItems.forEach(item -> {
                stringBuilder.append(item.translate());
            });
        }

        stringBuilder.append("\n\n}");

        return stringBuilder.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {
        List<FileEntityResult> list = new ArrayList<>();

        return list;
    }

    public Map<String, List<ContentEntry>> getMapForOutput() {
        Map<String, List<ContentEntry>> mapForOutput = new HashMap<>();

        if (logicItems != null) {

            //--------------------------------------------
            // some parts in files are added once even if the corresponding @XBoth block has two occurrences.
            StringBuilder sb = new StringBuilder();

            sb.append("import * as yup from 'yup';\n" +
                    "import {\n" +
                    "  Controller,\n" +
                    "  ConvectorController,\n" +
                    "  Invokable,\n" +
                    "  Param\n" +
                    "} from '@worldsibu/convector-core-controller';\n" +
                    "\n" +
                    "import { Property } from './property.model';\n" +
                    "import { Participant } from 'participant-cc';\n" +
                    "\n" +
                    "@Controller('property')\n" +
                    "export class PropertyController extends ConvectorController {");

            FileEntityResult result1 = new FileEntityResult();
            result1.setPath(PROPERY_DIR + File.separator + PROPERTY_CONTROLLER_TS);
            result1.setContent(sb.toString());
            result1.setPositionInFile(0);

            populateMap(mapForOutput, result1);
            //--------------------------------------------

            // closing brace should be added only once as well
            FileEntityResult result3 = new FileEntityResult();
            result3.setPath(PROPERY_DIR + File.separator + PROPERTY_CONTROLLER_TS);
            result3.setContent("\n}"); // for controller
            result3.setPositionInFile(1000); // should be in the end

            populateMap(mapForOutput,result3);
            //--------------------------------------------

            sb = new StringBuilder();

            sb.append("import { Request, Response } from 'express';\n" +
                    "import { PropertyControllerBackEnd } from '../convector';\n" +
                    "import { ParticipantControllerBackEnd } from '../convector';");

            result1 = new FileEntityResult();
            result1.setPath(MAIN_SYSTEM_DIR + File.separator + CONTROLLERS_TS);
            result1.setContent(sb.toString());
            result1.setPositionInFile(0);

            populateMap(mapForOutput, result1);
            //--------------------------------------------

            sb = new StringBuilder();

            sb.append("import * as yup from 'yup';\n" +
                    "\n" +
                    "import {\n" +
                    "  Controller,\n" +
                    "  ConvectorController,\n" +
                    "  Invokable,\n" +
                    "  Param,\n" +
                    "  BaseStorage\n" +
                    "} from '@worldsibu/convector-core';\n" +
                    "\n" +
                    "import { Participant } from './participant.model';\n" +
                    "import { ClientIdentity } from 'fabric-shim';\n" +
                    "\n" +
                    "@Controller('participant')\n" +
                    "export class ParticipantController extends ConvectorController {\n" +
                    "  \n" +
                    "  get fullIdentity(): ClientIdentity {\n" +
                    "    const stub = (BaseStorage.current as any).stubHelper;\n" +
                    "    return new ClientIdentity(stub.getStub());\n" +
                    "  };\n");

            result1 = new FileEntityResult();
            result1.setPath(PARTICIPANT_DIR + File.separator + PARTICIPANT_CONTROLLER_TS);
            result1.setContent(sb.toString());
            result1.setPositionInFile(0);

            populateMap(mapForOutput, result1);
            //--------------------------------------------

            FileEntityResult result2 = new FileEntityResult();
            result2.setPath(PARTICIPANT_DIR + File.separator + PARTICIPANT_CONTROLLER_TS);
            result2.setContent("\n}"); // for controller
            result2.setPositionInFile(1000); // should be in the end

            populateMap(mapForOutput, result2);

            //--------------------------------------------



            //--------------------------------------------
            populateMap(mapForOutput, logicItems);
        }

        if (dataItems != null) {
            populateMap(mapForOutput, dataItems);
        }


        return mapForOutput;
    }

    public static void populateMap(Map<String, List<ContentEntry>> mapForOutput, FileEntityResult fileEntity){
        if (fileEntity == null) {
            return;
        }
        if (mapForOutput.get(fileEntity.getPath()) == null) {
            List<ContentEntry> list = new ArrayList<>();
            list.add(new ContentEntry(fileEntity.getContent(), fileEntity.getPositionInFile()));
            mapForOutput.put(fileEntity.getPath(), list);
        } else {
            List<ContentEntry> list = mapForOutput.get(fileEntity.getPath());
            list.add(new ContentEntry(fileEntity.getContent(), fileEntity.getPositionInFile()));
        }
    }

    // as the result, content (list of strings) for the same file, produced by different blocks
    // can be get from map by filename (key in mapForOutput)
    public static void populateMap(Map<String, List<ContentEntry>> mapForOutput, List<ParsingResultInterface> logicOrDataResults) {
        if (logicOrDataResults == null) {
            return;
        }
        logicOrDataResults.forEach(logicResult -> {
            List<FileEntityResult> listFiles = logicResult.getFileEntities();
            listFiles.forEach(fileEntity -> {
                populateMap(mapForOutput, fileEntity);
            });
        });
    }
}
