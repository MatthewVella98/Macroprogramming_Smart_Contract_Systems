package com.parser.listener;

import com.parser.model.*;
import org.junit.Assert;
import org.junit.Test;
import com.parser.util.ClassSetupUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TSCustomListenerTest {

    @Test
    //@Ignore
    public void ComputationOnlyTest() { // without data section
        String s = "program \n" +
                "{\n" +
                "    /* -- 1. Both -- */ \n" +
                "    @XOnMainSystem() \n" +
                "    {{\n" +
                "        function PropertyController_createProperty \n" +
                "          ( id: string, propertyType: string ) \n" +
                "        \n" +
                "        @XOnChain() \n" +
                "            {{\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "\n          throw new Error(`property with ${id} doesn't exist`); " +
                "\n" +
                "            }}\n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\"); \n" +
                "    }}\n" +
                "    \n" +
                "    /* -- 2. OnChain -- */\n" +
                "    @XOnChain() \n" +
                "    {{\n" +
                "        function PropertyController___callback\n" +
                "          ( oracleRespondeCode: string, response: number ) \n" +
                "        {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +

                "        const valueResponse = await Property.query( Property, { \n" +
                "        'selector' : {\n" +
                "        'oracleResponseCode' : oracleResponseCode \n" +
                "        }\n" +
                "        });\n" +
                "        }\n" +

                "\n" +
                "     }}\n" +
                "\n" +
                "    /* -- 3. MainSystem -- */\n" +
                "    @XOnMainSystem()\n" +
                "    {{\n" +
                "        function transactionMessage(message: string){\n" +
                "            console.log(message); \n" +
                "        }\n" +
                "    }}\n" +
                "\n" +
                "}\n";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, true);

        ProgramResult programLogicResult = listener.getProgramResult();
        List<ParsingResultInterface> interfaceList = programLogicResult.getLogicItems();
        Assert.assertEquals(3, interfaceList.size());

        String translated = programLogicResult.translate();
        System.out.println(translated);

        // this type of test is useful to see how the input file is translated
        Assert.assertEquals("program {\n" +
                "\n" +
                "@Invokeable()\n" +
                "public async createProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  propertyType: string\n" +
                ") {\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "\n" +
                "          throw new Error(`property with ${id} doesn't exist`);\n" +
                "}\n" +
                "\n" +
                "export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_createProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\");\n" +
                "}\n" +
                "\n" +
                "@Invokeable()\n" +
                "public async __callback(\n" +
                "  oracleRespondeCode: string,\n" +
                "  response: number\n" +
                ") {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "        const valueResponse = await Property.query( Property, { \n" +
                "        'selector' : {\n" +
                "        'oracleResponseCode' : oracleResponseCode \n" +
                "        }\n" +
                "        });\n" +
                "}\n" +
                "\n" +
                "function transactionMessage(message: string) {\n" +
                "\n" +
                "            console.log(message); \n" +
                "        \n" +
                "}\n" +
                "\n" +
                "}", translated);
        System.out.println("******************************");
    }

    @Test
    //@Ignore
    public void ComputationOnlyWhiteSpaceTest() { // without data section, slightly different white spaces
        String s = "program  \n" +
                "{\n" +
                "    /* -- 1. Both -- */ \n" +
                "    @XOnMainSystem() \n" +
                "    {{\n" +
                "        function PropertyController_createProperty \n" +
                "          ( id: string, propertyType: string ) \n" +
                "        \n" +
                "        @XOnChain() \n" +
                "            {{\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "\n" +
                "            }} \n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\"); \n" +
                "    }}\n" +
                "    \n" +
                "    /* -- 2. OnChain Only -- */\n" +
                "    @XOnChain() \n" +
                "    {{\n" +
                "        function PropertyController___callback\n" +
                "          ( oracleRespondeCode: string, response: number ) \n" +
                "        {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "        }\n" +
                "\n" +
                "     }}\n" +
                "\n" +
                "    /* -- 3. MainSystem Only -- */\n" +
                "    @XOnMainSystem()\n" +
                "    {{\n" +
                "        function transactionMessage(message: string){\n" +
                "            console.log(message); \n" +
                "        }\n" +
                "    }}\n" +
                "    \n" +
                "}\n" +
                "\n" +
                "\n";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, true);

        ProgramResult programLogicResult = listener.getProgramResult();
        List<ParsingResultInterface> interfaceList = programLogicResult.getLogicItems();
        Assert.assertEquals(3, interfaceList.size());

        String translated = programLogicResult.translate();
        System.out.println(translated);

        // this type of test is useful to see how the input file is translated
        Assert.assertEquals("program {\n" +
                "\n" +
                "@Invokeable()\n" +
                "public async createProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  propertyType: string\n" +
                ") {\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "}\n" +
                "\n" +
                "export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_createProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                " \n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\");\n" +
                "}\n" +
                "\n" +
                "@Invokeable()\n" +
                "public async __callback(\n" +
                "  oracleRespondeCode: string,\n" +
                "  response: number\n" +
                ") {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "}\n" +
                "\n" +
                "function transactionMessage(message: string) {\n" +
                "\n" +
                "            console.log(message); \n" +
                "        \n" +
                "}\n" +
                "\n" +
                "}", translated);
        System.out.println("******************************");
    }

    @Test
    //@Ignore
    public void ComputationAndDataModelTest() { // with data section
        String s = "program  \n" +
                "{\n" +
                "    /* -- 1. Both -- */ \n" +
                "    @XOnMainSystem() \n" +
                "    {{\n" +
                "        function PropertyController_createProperty \n" +
                "          ( id: string, propertyType: string ) \n" +
                "        \n" +
                "        @XOnChain() \n" +
                "            {{\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "\n" +
                "            }} \n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\"); \n" +
                "    }}\n" +
                "    \n" +
                "    /* -- 2. OnChain Only -- */\n" +
                "    @XOnChain() \n" +
                "    {{\n" +
                "        function PropertyController___callback\n" +
                "          ( oracleRespondeCode: string, response: number ) \n" +
                "        {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "        }\n" +
                "\n" +
                "     }}\n" +
                "\n" +
                "    /* -- 3. MainSystem Only -- */\n" +
                "    @XOnMainSystem()\n" +
                "    {{\n" +
                "        function transactionMessage(message: string){\n" +
                "            console.log(message); \n" +
                "        }\n" +
                "    }}\n" +
                "    \n" +
                "    data Property  {{\n" +
                "   @XOnlyOnChain  @ReadOnly() @Required()  public readonly type = 'io.worldsibu.property';\n" +
                "   @XOnlyOnChain @Required() @Validate(yup.string()) public propertyType:string; \n" +
                "   @XOnlyOnChain public assetOwner:string; \n" +
                "   @XOnlyOnChain public isForSale: boolean; \n" +
                "   @XOnlyOnChain @Validate(yup.string()) public oracleResponseCode: string;\n" +
                "   @XOnlyOnChain @Validate(yup.number()) public dateStartRequest: number;\n" +
                "   @XOnlyOnChain @Validate(yup.number()) public dateOracleResponse: number;\n" +
                "   @XAll public price: number; \n" +
                "  }}\n" +
                "\n" +
                "  \tdata Participant {{\n" +
                "   @XOnlyOnChain public readonly type = 'io.worldsibu.examples.participant';\n" +
                "   @XOnlyOnChain public name: string;\n" +
                "   @XOnlyOnChain public msp: string; \n" +
                "   @XOnlyOnChain public identities: Array<FlatConvectorModel<x509Identities>>;\n" +
                "  }}\n" +
                "\n" +
                "  \tdata Participant_x509Identities{{ \n" +
                "   @XOnlyOnChain public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "   @XOnlyOnChain public status: boolean;\n" +
                "   @XOnlyOnChain public fingerprint: string; \n" +
                "  }}\n" +
                "\n" +
                "}";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, false);

        ProgramResult programResult = listener.getProgramResult();
        List<ParsingResultInterface> logicList = programResult.getLogicItems();
        Assert.assertEquals(3, logicList.size());

        List<ParsingResultInterface> dataList = programResult.getDataItems();
        Assert.assertEquals(3, dataList.size());

        String translated = programResult.translate();
        System.out.println(translated);

        // this type of test is useful to see how the input file is translated
        Assert.assertEquals("program {\n" +
                "\n" +
                "@Invokeable()\n" +
                "public async createProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  propertyType: string\n" +
                ") {\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "}\n" +
                "\n" +
                "export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_createProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                " \n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\");\n" +
                "}\n" +
                "\n" +
                "@Invokeable()\n" +
                "public async __callback(\n" +
                "  oracleRespondeCode: string,\n" +
                "  response: number\n" +
                ") {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "}\n" +
                "\n" +
                "function transactionMessage(message: string) {\n" +
                "\n" +
                "            console.log(message); \n" +
                "        \n" +
                "}\n" +
                "\n" +
                "import * as yup from 'yup':\n" +
                "import {\n" +
                "  ConvectorModel,\n" +
                "  Default,\n" +
                "  ReadOnly,\n" +
                "  Required,\n" +
                "  Validate\n" +
                "} from '@worldsibu/convector-core-model'; \n" +
                "\n" +
                "export class Property extends ConvectorModel<Property> {\n" +
                "\n" +
                "  @ReadOnly() @Required() public readonly type = 'io.worldsibu.property';\n" +
                "\n" +
                "  @Required() @Validate(yup.string()) \n" +
                "  public propertyType: string;\n" +
                "\n" +
                "  \n" +
                "  public assetOwner: string;\n" +
                "\n" +
                "  \n" +
                "  public isForSale: boolean;\n" +
                "\n" +
                "  @Validate(yup.string()) \n" +
                "  public oracleResponseCode: string;\n" +
                "\n" +
                "  @Validate(yup.number()) \n" +
                "  public dateStartRequest: number;\n" +
                "\n" +
                "  @Validate(yup.number()) \n" +
                "  public dateOracleResponse: number;\n" +
                "\n" +
                "  @ReadOnly() @Required() @Validate(yup.number())\n" +
                "  public price: number;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "export class PropertyMainSystem {\n" +
                "  public price: number;\n" +
                "}\n" +
                "\n" +
                "import * as yup from 'yup':\n" +
                "import {\n" +
                "  ConvectorModel,\n" +
                "  Default,\n" +
                "  ReadOnly,\n" +
                "  Required,\n" +
                "  Validate\n" +
                "} from '@worldsibu/convector-core-model'; \n" +
                "\n" +
                "export class Participant extends ConvectorModel<Participant> {\n" +
                "\n" +
                "  @ReadOnly() @Required() public readonly type = 'io.worldsibu.examples.participant';\n" +
                "\n" +
                "  \n" +
                "  public name: string;\n" +
                "\n" +
                "  \n" +
                "  public msp: string;\n" +
                "\n" +
                "  \n" +
                "  public identities: Array<FlatConvectorModel<x509Identities>>;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "export class x509Identities extends ConvectorModel<x509Identities> {\n" +
                "\n" +
                "  @ReadOnly() public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\n" +
                "  \n" +
                "  public status: boolean;\n" +
                "\n" +
                "  \n" +
                "  public fingerprint: string;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "}", translated);
        System.out.println("******************************");
    }

    @Test
    //@Ignore
    public void MultipleComputationsTest() { // with data section
        String s = "program  {\n" +
                "  \tdata Participant_x509Identities {{ \n" +
                "   @XOnlyOnChain public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "   @Validate(yup.boolean()) @Required()\n" +
                "   @XOnlyOnChain public status: boolean;\n" +
                "   @Validate(yup.string()) @Required()\n" +
                "   @XOnlyOnChain public fingerprint: string; \n" +
                "  }}" +
                "\n" +
                "}";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, false);

        ProgramResult programResult = listener.getProgramResult();
        List<ParsingResultInterface> logicList = programResult.getLogicItems();
        Assert.assertEquals(0, logicList.size());

        List<ParsingResultInterface> dataList = programResult.getDataItems();
        Assert.assertEquals(1, dataList.size());

        String translated = programResult.translate();
        System.out.println(translated);

        Assert.assertEquals("program {\n" +
                "\n" +
                "export class x509Identities extends ConvectorModel<x509Identities> {\n" +
                "\n" +
                "  @ReadOnly() public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\n" +
                "  @Validate(yup.boolean()) @Required() \n" +
                "  public status: boolean;\n" +
                "\n" +
                "  @Validate(yup.string()) @Required() \n" +
                "  public fingerprint: string;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "}", translated);
        System.out.println("******************************");
    }

    @Test
    //@Ignore
    public void MultipleDataModelsTest() { // with 3 data sections
        String s = "program  {\n" +
                "     data Property \n" +
                "     {{\n" +
                "\t    @XOnlyOnChain public readonly type = 'io.worldsibu.property';\n" +
                "\t    @XOnlyOnChain public propertyType:string; \n" +
                "\t    @XOnlyOnChain public assetOwner:string; \n" +
                "\t    @XOnlyOnChain public isForSale: boolean; \n" +
                "\t    @XAll public price: number; \n" +
                "     }}\n" +
                "\n" +
                "     data Participant \n" +
                "     {{\n" +
                "\t    @XOnlyOnChain public readonly type = 'io.worldsibu.examples.participant';\n" +
                "\t    @XOnlyOnChain public name: string;\n" +
                "\t    @XOnlyOnChain public msp: string; \n" +
                "\t    @XOnlyOnChain public identities: Array<FlatConvectorModel<x509Identities>>;\n" +
                "     }}\n" +
                "\n" +
                "     data Participant_x509Identities \n" +
                "     {{\n" +
                "\t    @XOnlyOnChain public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\t    @XOnlyOnChain public status: boolean;\n" +
                "\t    @XOnlyOnChain public fingerprint: string; \n" +
                "     }}\n" +
                "}";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, false);

        ProgramResult programResult = listener.getProgramResult();
        List<ParsingResultInterface> logicList = programResult.getLogicItems();
        Assert.assertEquals(0, logicList.size());

        List<ParsingResultInterface> dataList = programResult.getDataItems();
        Assert.assertEquals(3, dataList.size());

        String translated = programResult.translate();
        System.out.println(translated);

        Assert.assertEquals("program {\n" +
                "\n" +
                "\n" +
                "\n" +
                "import * as yup from 'yup':\n" +
                "import {\n" +
                "  ConvectorModel,\n" +
                "  Default,\n" +
                "  ReadOnly,\n" +
                "  Required,\n" +
                "  Validate\n" +
                "} from '@worldsibu/convector-core-model'; \n" +
                "\n" +
                "export class Property extends ConvectorModel<Property> {\n" +
                "\n" +
                "  @ReadOnly() @Required() public readonly type = 'io.worldsibu.property';\n" +
                "\n" +
                "  \n" +
                "  public propertyType: string;\n" +
                "\n" +
                "  \n" +
                "  public assetOwner: string;\n" +
                "\n" +
                "  \n" +
                "  public isForSale: boolean;\n" +
                "\n" +
                "  @ReadOnly() @Required() @Validate(yup.number())\n" +
                "  public price: number;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "export class PropertyMainSystem {\n" +
                "  public price: number;\n" +
                "}\n" +
                "\n" +
                "import * as yup from 'yup':\n" +
                "import {\n" +
                "  ConvectorModel,\n" +
                "  Default,\n" +
                "  ReadOnly,\n" +
                "  Required,\n" +
                "  Validate\n" +
                "} from '@worldsibu/convector-core-model'; \n" +
                "\n" +
                "export class Participant extends ConvectorModel<Participant> {\n" +
                "\n" +
                "  @ReadOnly() @Required() public readonly type = 'io.worldsibu.examples.participant';\n" +
                "\n" +
                "  \n" +
                "  public name: string;\n" +
                "\n" +
                "  \n" +
                "  public msp: string;\n" +
                "\n" +
                "  \n" +
                "  public identities: Array<FlatConvectorModel<x509Identities>>;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "export class x509Identities extends ConvectorModel<x509Identities> {\n" +
                "\n" +
                "  @ReadOnly() public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\n" +
                "  \n" +
                "  public status: boolean;\n" +
                "\n" +
                "  \n" +
                "  public fingerprint: string;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "}", translated);
        System.out.println("******************************");
    }

    /*@Test
    //@Ignore
    public void testCase4_2() { // with data section
        String s = "program  {\n" +
                "  \tdata Participant_x509Identities {{ \n" +
                "   @XOnlyOnChain publi readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "   @Validate(yup.boolean()) @Required()\n" +
                "   @XOnlyOnChain public status: boolean;\n" +
                "   @Validate(yup.string()) @Required()\n" +
                "   @XOnlyOnChain public fingerprint: string; \n" +
                "  }}" +
                "\n" +
                "}";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, false);

        ProgramResult programResult = listener.getProgramResult();
        List<ParsingResultInterface> logicList = programResult.getLogicItems();
        Assert.assertEquals(0, logicList.size());

        List<ParsingResultInterface> dataList = programResult.getDataItems();
        Assert.assertEquals(1, dataList.size());

        String translated = programResult.translate();
        System.out.println(translated);

        Assert.assertEquals("program {\n" +
                "\n" +
                "export class x509Identities extends ConvectorModel<x509Identities> {\n" +
                "\n" +
                "  @ReadOnly() public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\n" +
                "  @Validate(yup.boolean()) @Required() \n" +
                "  public status: boolean;\n" +
                "\n" +
                "  @Validate(yup.string()) @Required() \n" +
                "  public fingerprint: string;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "}", translated);
        System.out.println("******************************");
    }*/

   // @Test
    //@Ignore
    public void testCase5() { // 2 XBoth blocks and 2 XOnChain blocks
        // this test checks if the text blocks are generated for output files - in common case the same data block or logic block
        // can produce text blocks to several output files.
        String s = "program  \n" +
                "{\n" +
                "    /* -- 1. Both -- */ \n" +
                "    @XOnMainSystem() \n" +
                "    {{\n" +
                "        function PropertyController_createProperty \n" +
                "          ( id: string, propertyType: string ) \n" +
                "        \n" +
                "        @XOnChain() \n" +
                "            {{\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "\n" +
                "            }} \n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\"); \n" +
                "    }}\n" +
                "    \n" +
                "    /* -- 1. Both -- */ \n" +
                "    @XOnMainSystem() \n" +
                "    {{\n" +
                "        function PropertyController_sellProperty \n" +
                "          ( id: string, propertyType: string ) \n" +
                "        \n" +
                "        @XOnChain() \n" +
                "            {{\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "\n" +
                "            }} \n" +
                "\n" +
                "        transactionMessage(\"sellProperty Success!\"); \n" +
                "    }}\n" +
                "    \n" +
                "    /* -- 2.1 OnChain Only -- */\n" +
                "    @XOnChain() \n" +
                "    {{\n" +
                "        function PropertyController___callback\n" +
                "          ( oracleRespondeCode: string, response: number ) \n" +
                "        {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "        }\n" +
                "\n" +
                "     }}\n" +

                "    \n" +
                "    /* -- 2.2 OnChain Only -- */\n" +
                "    @XOnChain() \n" +
                "    {{\n" +
                "        function PropertyController___OnchainTest2\n" +
                "          ( oracleRespondeCode: string, response: number ) \n" +
                "        {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "        }\n" +
                "\n" +
                "     }}\n" +

                "\n" +
                "    /* -- 3. MainSystem Only -- */\n" +
                "    @XOnMainSystem()\n" +
                "    {{\n" +
                "        function transactionMessage(message: string){\n" +
                "            console.log(message); \n" +
                "        }\n" +
                "    }}\n" +
                "    \n" +
                "}";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, false);

        ProgramResult programResult = listener.getProgramResult();
        List<ParsingResultInterface> logicList = programResult.getLogicItems();
        Assert.assertEquals(5, logicList.size());

        List<ParsingResultInterface> dataList = programResult.getDataItems();
        Assert.assertEquals(0, dataList.size());

        Map<String, List<ContentEntry>> map = programResult.getMapForOutput();
        System.out.println(map.size());
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\n******\n");
            List<ContentEntry> list = entry.getValue();
            Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition));
            list.forEach(contentEntry -> {
                System.out.println(contentEntry);
                System.out.println("\n=======================\n");
            });
        });

        // This map is a dictionary. Key is a file name and it refers to list of blocks to be output into this file
        // Only 3 files since the input program is reduced
        Assert.assertEquals(3, map.size());

        List<ContentEntry> list = map.get("Property\\property.controller.ts");
        Assert.assertEquals(6, list.size());
        Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition).thenComparing(ContentEntry::getContent));

        ContentEntry contentEntry = list.get(0);
        Assert.assertEquals("import * as yup from 'yup';\n" +
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
                "export class PropertyController extends ConvectorController {", contentEntry.getContent());

        contentEntry = list.get(1);
        Assert.assertEquals("@Invokeable()\n" +
                "public async createProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  propertyType: string\n" +
                ") {\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(2);
        Assert.assertEquals("@Invokeable()\n" +
                "public async sellProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  propertyType: string\n" +
                ") {\n" +
                "            /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "\n" +
                "            let property = new Property(id);\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(3);
        Assert.assertEquals("@Invokeable()\n" +
                "public async __OnchainTest2(\n" +
                "  oracleRespondeCode: string,\n" +
                "  response: number\n" +
                ") {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(4);
        Assert.assertEquals("@Invokeable()\n" +
                "public async __callback(\n" +
                "  oracleRespondeCode: string,\n" +
                "  response: number\n" +
                ") {\n" +
                "\n" +
                "        /* Querying the model using the responseCode */\n" +
                "\n" +
                "        if (!oracleRespondeCode) {\n" +
                "            throw new Error('missing [oracleRespondeCode]');\n" +
                "        }\n" +
                "        \n" +
                "        console.log('[price] set after oracle response');\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(5);
        Assert.assertEquals("\n" +
                "}", contentEntry.getContent());

        list = map.get("Participant\\participant.controller.ts");
        Assert.assertEquals(2, list.size());
        Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition).thenComparing(ContentEntry::getContent));
        contentEntry = list.get(0);
        Assert.assertEquals("import * as yup from 'yup';\n" +
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
                "  };\n", contentEntry.getContent());
        contentEntry = list.get(1);
        Assert.assertEquals("\n" +
                "}", contentEntry.getContent());

        list = map.get("MainSystem\\controllers.ts");
        Assert.assertEquals(4, list.size());
        Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition).thenComparing(ContentEntry::getContent));

        contentEntry = list.get(0);
        Assert.assertEquals("import { Request, Response } from 'express';\n" +
                "import { PropertyControllerBackEnd } from '../convector';\n" +
                "import { ParticipantControllerBackEnd } from '../convector';", contentEntry.getContent());

        contentEntry = list.get(1);
        Assert.assertEquals("export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_createProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                " \n" +
                "\n" +
                "        transactionMessage(\"createProperty Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(2);
        Assert.assertEquals("export async function PropertyController_sellProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_sellProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                " \n" +
                "\n" +
                "        transactionMessage(\"sellProperty Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(3);
        Assert.assertEquals("function transactionMessage(message: string) {\n" +
                "\n" +
                "            console.log(message); \n" +
                "        \n" +
                "}", contentEntry.getContent());

        System.out.println("******************************");
    }

    // @Test
    //@Ignore
    public void testCase6() { // the most real life example, used your file
        // this test checks if the text blocks are generated for output files - in common case the same data block or logic block
        // can produce text blocks to several output files.
        String s = "program  \n" +
                "{ \n" +
                "     @XOnMainSystem() \n" +
                "     {{\n" +
                "\t   function PropertyController_createProperty (\n" +
                "\t   id: string, propertyType: string, ownerID: string,isForSale:boolean,oracleResponseCode: string) \n" +
                "\n" +
                "\t@XOnChain() \n" +
                "\t{{\n" +
                "\t     /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "            this.tx.stub.setEvent('oracle_request_data', { id,k oracleResponseCode });\n" +
                "\n" +
                "\t     let property = new Property(id);\n" +
                "\t     property.propertyType = propertyType;\n" +
                "\t     property.assetOwner = ownerID;\n" +
                "\t     property.isForSale = isForSale;\n" +
                "\t     property.oracleResponseCode = oracleResponseCode; \n" +
                "\n" +
                "\t     /* Time must be deterministic for all peers - When the transaction was created.  */\n" +
                "\t     property.dateStartRequest = this.tx.stub.getTxDate().getTime();\n" +
                "\n" +
                "\t     await property.save()\n" +
                "\n" +
                "\t}}\n" +
                "\t   transactionMessage(\"CreateProperty Success!\");   \n" +
                "     }}\n" +
                "\n" +
                "     @XOnChain() \n" +
                "     {{\n" +
                "\t   function PropertyController___callback ( oracleRespondeCode: string,response: number ) {\n" +
                "\t      /* Querying the model using the responseCode */\n" +
                "\t      if (!oracleRespondeCode) {\n" +
                "\t\tthrow new Error('missing [oracleRespondeCode]');\n" +
                "\t      }\n" +
                "\t      console.log('Callback received');\n" +
                "\t      const valueResponse = await Property.query(Property, {\n" +
                "\t\t'selector': {\n" +
                "\t\t  'oracleResponseCode': oracleRespondeCode\n" +
                "\t\t}\n" +
                "\t      });\n" +
                "\t  \n" +
                "\t      /* Validation */\n" +
                "\t      if (!valueResponse || !valueResponse[0] || !valueResponse[0].id) {\n" +
                "\t\tthrow new Error('No registry can be updated');\n" +
                "\t      }\n" +
                "\t  \n" +
                "\t      /* Updating the model. */\n" +
                "\t      const model = new Property(valueResponse[0]);\n" +
                "\t      model.price = response;\n" +
                "\t      model.oracleResponseCode = '';\n" +
                "\t      model.dateOracleResponse = this.tx.stub.getTxDate().getTime();\n" +
                "\t      await model.save();\n" +
                "\t      \n" +
                "\t      console.log('[price] set after oracle response');\n" +
                "   \t   }\n" +
                "     }}\n" +
                "  \n" +
                "     @XOnMainSystem() \n" +
                "     {{\n" +
                "          function PropertyController_updateForSale ( id:string, isForSale: boolean )  \n" +
                "\t   @XOnChain() \n" +
                "\t    {{\n" +
                "\t\tlet property = await Property.getOne(id);\n" +
                "\t\tconsole.log('Property:');\n" +
                "\t\tconsole.log(Property);\n" +
                "\t\t\n" +
                "\t\tif (!property || !property.id) {\n" +
                "\t\t  throw new Error(`Property with id ${id} does not exist`);\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\t/* Check if the Owner exists */\n" +
                "\t\tconst owner = await Participant.getOne(property.assetOwner);\n" +
                "\t\tconsole.log('Property owner:');\n" +
                "\t\tconsole.log(owner);\n" +
                "\n" +
                "\t\tif (!owner || !owner.id || !owner.identities) {\n" +
                "\t\t  throw new Error('Referenced owner participant does not exist in the ledger');\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* If the Participant is the actual owner of the property, the property can be updated */\n" +
                "\t\tconst ownerCurrentIdentity = owner.identities.filter(identity => identity.status === true)[0];\n" +
                "\t\tif (ownerCurrentIdentity.fingerprint === this.sender) {\n" +
                "\t\t  console.log('Identity can update Property');\n" +
                "\t\t  property.isForSale = isForSale;\n" +
                "\t\t  await property.save();\n" +
                "\t\t} else {\n" +
                "\t\t  throw new Error(`Identity ${this.sender} is not allowed to update Property just ${owner.name} ${ownerCurrentIdentity.fingerprint} can`);\n" +
                "\t\t} \n" +
                "\t\t\t\n" +
                "\t      }}\n" +
                "\t      \n" +
                "\t      transactionMessage(\"updateForSale Success!\"); \n" +
                "     }}\n" +
                "     \n" +
                "     @XOnMainSystem()\n" +
                "     {{\n" +
                "\t   function PropertyController_transferProperty ( id:string, to:string ) \n" +
                "      \t   @XOnChain()\n" +
                "           {{\n" +
                "\t\tlet property = await Property.getOne(id);\n" +
                "\t\t\n" +
                "\t\t/* Property exists check */\n" +
                "\t\tif (!property || !property.id) {\n" +
                "\t\t  throw new Error(`Property with id ${id} does not exist`);\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* Owner exists check */\n" +
                "\t\tconst owner = await Participant.getOne(property.assetOwner);\n" +
                "\t\tif (!owner || !owner.id || !owner.identities) {\n" +
                "\t\t  throw new Error('Referenced owner participant does not exist in the ledger');\n" +
                "\t\t}\n" +
                "\t\t/* Owner is Sender check */\n" +
                "\t\tconst ownerCurrentIdentity = owner.identities.filter(identity => identity.status === true)[0];\n" +
                "\t\tif (ownerCurrentIdentity.fingerprint !== this.sender) {\n" +
                "\t\t  throw new Error(`Identity ${this.sender} is not allowed to update Property just ${owner.name} ${ownerCurrentIdentity.fingerprint} can`);\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* Property is for sale check */\n" +
                "\t\tif(property.isForSale){\n" +
                "\t\t  property.assetOwner = to;\n" +
                "\t\t  await property.save();\n" +
                "\t\t  } else {\n" +
                "\t\t  throw new Error(`The Property with ID ${property.id} is not for sale.`); \n" +
                "\t\t  }\n" +
                "\t    }}\n" +
                "\t  \n" +
                "  \ttransactionMessage(\"Transfer Property Success!\");\n" +
                "     }}\n" +
                "    \n" +
                "      @XOnMainSystem()\n" +
                "      {{\n" +
                "           function PropertyController_getProperty ( id:string ) \n" +
                "\t   @XOnChain() \n" +
                "\t   {{\n" +
                "\t\tconst existing = await Property.getOne(id);\n" +
                "\t\tif (!existing || !existing.id) {\n" +
                "\t\t\tthrow new Error(`No property exists with that ID ${id}`);\n" +
                "\t\t}\n" +
                "\t\t\treturn existing;\n" +
                "\t   }}\n" +
                "   \n" +
                "    \t    transactionMessage(\"Get Property Success!\");\n" +
                "\t}}\n" +
                "\t\n" +
                "     @XOnMainSystem()\n" +
                "     {{\n" +
                "\t  function ParticipantController_register ( id:string,name:string ) \n" +
                "\t    @XOnChain()\n" +
                "\t    {{\n" +
                "\t\t  /* Retrieve to see if exists */\n" +
                "\t\t  const existing = await Participant.getOne(id);\n" +
                "\n" +
                "\t\t  if (!existing || !existing.id) {\n" +
                "\t\t    let participant = new Participant();\n" +
                "\t\t    participant.id = id;\n" +
                "\t\t    participant.name = name || id;\n" +
                "\t\t    participant.msp = this.fullIdentity.getMSPID();\n" +
                "\t\t    \n" +
                "\t\t    /* Create a new identity */\n" +
                "\t\t    participant.identities = [{\n" +
                "\t\t      fingerprint: this.sender,\n" +
                "\t\t      status: true\n" +
                "\t\t    }];\n" +
                "\t\t    \n" +
                "\t\t    await participant.save();\n" +
                "\t\t    \n" +
                "\t\t  } else {\n" +
                "\t\t    throw new Error('Identity exists already, please call changeIdentity fn for updates');\n" +
                "\t\t  }\n" +
                "\t     }}\n" +
                "\t  \n" +
                "\t  transactionMessage(\"Register Participant Success!\"); \n" +
                "     }}\n" +
                "\n" +
                "     @XOnMainSystem()\n" +
                "     {{\n" +
                "\t  function ParticipantController_get( id:string )\n" +
                "\t    \n" +
                "\t      @XOnChain() {{\n" +
                "\t\t  const existing = await Participant.getOne(id);\n" +
                "\t\t  if (!existing || !existing.id) {\n" +
                "\t\t  throw new Error(`No identity exists with that ID ${id}`);\n" +
                "\t\t  }\n" +
                "\t\t  return existing;\n" +
                "\t\t}} \n" +
                "\n" +
                "\t    transactionMessage(\"Get Participant Success!\"); \n" +
                "     }}\n" +
                " \n" +
                "\n" +
                "     @XOnMainSystem()\n" +
                "     {{\n" +
                "\t   function transactionMessage( message: string ) {\n" +
                "\t       console.log(message); \n" +
                "\t   }\n" +
                "     }}\n" +
                "\n" +
                "     data Property \n" +
                "     {{\n" +
                "\t    @XOnlyOnChain public readonly type = 'io.worldsibu.property';\n" +
                "\t    @XOnlyOnChain public propertyType:string; \n" +
                "\t    @XOnlyOnChain public assetOwner:string; \n" +
                "\t    @XOnlyOnChain public isForSale: boolean; \n" +
                "\t    @XAll public price: number; \n" +
                "     }}\n" +
                "\n" +
                "     data Participant \n" +
                "     {{\n" +
                "\t    @XOnlyOnChain public readonly type = 'io.worldsibu.examples.participant';\n" +
                "\t    @XOnlyOnChain public name: string;\n" +
                "\t    @XOnlyOnChain public msp: string; \n" +
                "\t    @XOnlyOnChain public identities: Array<FlatConvectorModel<x509Identities>>;\n" +
                "     }}\n" +
                "\n" +
                "     data Participant_x509Identities \n" +
                "     {{\n" +
                "\t    @XOnlyOnChain public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\t    @XOnlyOnChain public status: boolean;\n" +
                "\t    @XOnlyOnChain public fingerprint: string; \n" +
                "     }}\n" +
                "\n" +
                "}";
        TSCustomListener listener = ClassSetupUtils.setupTsListener(s, false);

        ProgramResult programResult = listener.getProgramResult();
        List<ParsingResultInterface> logicList = programResult.getLogicItems();
        Assert.assertEquals(8, logicList.size());

        List<ParsingResultInterface> dataList = programResult.getDataItems();
        Assert.assertEquals(3, dataList.size());

        Map<String, List<ContentEntry>> map = programResult.getMapForOutput();
        System.out.println(map.size());
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\n******\n");
            List<ContentEntry> list = entry.getValue();
            Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition));
            list.forEach(contentEntry -> {
                System.out.println(contentEntry);
                System.out.println("\n=======================\n");
            });
        });

        // This map is a dictionary. Key is a file name and it refers to list of blocks to be output into this file
        // we expect 6 files
        Assert.assertEquals(6, map.size());


        List<ContentEntry> list = map.get("Property\\property.controller.ts");
        Assert.assertEquals(7, list.size());
        Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition).thenComparing(ContentEntry::getContent));

        ContentEntry contentEntry = list.get(0);
        Assert.assertEquals("import * as yup from 'yup';\n" +
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
                "export class PropertyController extends ConvectorController {", contentEntry.getContent());

        contentEntry = list.get(1);
        Assert.assertEquals("@Invokeable()\n" +
                "public async createProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  propertyType: string,\n" +
                "  @Param(yup.string())\n" +
                "  ownerID: string,\n" +
                "  @Param(yup.boolean())\n" +
                "  isForSale: boolean,\n" +
                "  @Param(yup.string())\n" +
                "  oracleResponseCode: string\n" +
                ") {\n" +
                "\t     /* Set an event. We pass the event name that we want to emit and some data */\n" +
                "            this.tx.stub.setEvent('oracle_request_data', { id,k oracleResponseCode });\n" +
                "\n" +
                "\t     let property = new Property(id);\n" +
                "\t     property.propertyType = propertyType;\n" +
                "\t     property.assetOwner = ownerID;\n" +
                "\t     property.isForSale = isForSale;\n" +
                "\t     property.oracleResponseCode = oracleResponseCode; \n" +
                "\n" +
                "\t     /* Time must be deterministic for all peers - When the transaction was created.  */\n" +
                "\t     property.dateStartRequest = this.tx.stub.getTxDate().getTime();\n" +
                "\n" +
                "\t     await property.save()\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(2);
        Assert.assertEquals("@Invokeable()\n" +
                "public async getProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string\n" +
                ") {\n" +
                "\t\tconst existing = await Property.getOne(id);\n" +
                "\t\tif (!existing || !existing.id) {\n" +
                "\t\t\tthrow new Error(`No property exists with that ID ${id}`);\n" +
                "\t\t}\n" +
                "\t\t\treturn existing;\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(3);
        Assert.assertEquals("@Invokeable()\n" +
                "public async transferProperty(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  to: string\n" +
                ") {\n" +
                "\t\tlet property = await Property.getOne(id);\n" +
                "\t\t\n" +
                "\t\t/* Property exists check */\n" +
                "\t\tif (!property || !property.id) {\n" +
                "\t\t  throw new Error(`Property with id ${id} does not exist`);\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* Owner exists check */\n" +
                "\t\tconst owner = await Participant.getOne(property.assetOwner);\n" +
                "\t\tif (!owner || !owner.id || !owner.identities) {\n" +
                "\t\t  throw new Error('Referenced owner participant does not exist in the ledger');\n" +
                "\t\t}\n" +
                "\t\t/* Owner is Sender check */\n" +
                "\t\tconst ownerCurrentIdentity = owner.identities.filter(identity => identity.status === true)[0];\n" +
                "\t\tif (ownerCurrentIdentity.fingerprint !== this.sender) {\n" +
                "\t\t  throw new Error(`Identity ${this.sender} is not allowed to update Property just ${owner.name} ${ownerCurrentIdentity.fingerprint} can`);\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* Property is for sale check */\n" +
                "\t\tif(property.isForSale){\n" +
                "\t\t  property.assetOwner = to;\n" +
                "\t\t  await property.save();\n" +
                "\t\t  } else {\n" +
                "\t\t  throw new Error(`The Property with ID ${property.id} is not for sale.`); \n" +
                "\t\t  }\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(4);
        Assert.assertEquals("@Invokeable()\n" +
                "public async updateForSale(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.boolean())\n" +
                "  isForSale: boolean\n" +
                ") {\n" +
                "\t\tlet property = await Property.getOne(id);\n" +
                "\t\tconsole.log('Property:');\n" +
                "\t\tconsole.log(Property);\n" +
                "\t\t\n" +
                "\t\tif (!property || !property.id) {\n" +
                "\t\t  throw new Error(`Property with id ${id} does not exist`);\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\t/* Check if the Owner exists */\n" +
                "\t\tconst owner = await Participant.getOne(property.assetOwner);\n" +
                "\t\tconsole.log('Property owner:');\n" +
                "\t\tconsole.log(owner);\n" +
                "\n" +
                "\t\tif (!owner || !owner.id || !owner.identities) {\n" +
                "\t\t  throw new Error('Referenced owner participant does not exist in the ledger');\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t/* If the Participant is the actual owner of the property, the property can be updated */\n" +
                "\t\tconst ownerCurrentIdentity = owner.identities.filter(identity => identity.status === true)[0];\n" +
                "\t\tif (ownerCurrentIdentity.fingerprint === this.sender) {\n" +
                "\t\t  console.log('Identity can update Property');\n" +
                "\t\t  property.isForSale = isForSale;\n" +
                "\t\t  await property.save();\n" +
                "\t\t} else {\n" +
                "\t\t  throw new Error(`Identity ${this.sender} is not allowed to update Property just ${owner.name} ${ownerCurrentIdentity.fingerprint} can`);\n" +
                "\t\t}\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(5);
        Assert.assertEquals("@Invokeable()\n" +
                "public async __callback(\n" +
                "  oracleRespondeCode: string,\n" +
                "  response: number\n" +
                ") {\n" +
                "\t      /* Querying the model using the responseCode */\n" +
                "\t      if (!oracleRespondeCode) {\n" +
                "\t\tthrow new Error('missing [oracleRespondeCode]');\n" +
                "\t      }\n" +
                "\t      console.log('Callback received');\n" +
                "\t      const valueResponse = await Property.query(Property, {\n" +
                "\t\t'selector': {\n" +
                "\t\t  'oracleResponseCode': oracleRespondeCode\n" +
                "\t\t}\n" +
                "\t      });\n" +
                "\t  \n" +
                "\t      /* Validation */\n" +
                "\t      if (!valueResponse || !valueResponse[0] || !valueResponse[0].id) {\n" +
                "\t\tthrow new Error('No registry can be updated');\n" +
                "\t      }\n" +
                "\t  \n" +
                "\t      /* Updating the model. */\n" +
                "\t      const model = new Property(valueResponse[0]);\n" +
                "\t      model.price = response;\n" +
                "\t      model.oracleResponseCode = '';\n" +
                "\t      model.dateOracleResponse = this.tx.stub.getTxDate().getTime();\n" +
                "\t      await model.save();\n" +
                "\t      \n" +
                "\t      console.log('[price] set after oracle response');\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(6);
        Assert.assertEquals("\n" +
                "}", contentEntry.getContent());


        list = map.get("Participant\\participant.controller.ts");
        Assert.assertEquals(4, list.size());
        Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition).thenComparing(ContentEntry::getContent));
        contentEntry = list.get(0);
        Assert.assertEquals("import * as yup from 'yup';\n" +
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
                "  };\n", contentEntry.getContent());

        contentEntry = list.get(1);
        Assert.assertEquals("@Invokeable()\n" +
                "public async get(\n" +
                "  @Param(yup.string())\n" +
                "  id: string\n" +
                ") {\n" +
                "\t\t  const existing = await Participant.getOne(id);\n" +
                "\t\t  if (!existing || !existing.id) {\n" +
                "\t\t  throw new Error(`No identity exists with that ID ${id}`);\n" +
                "\t\t  }\n" +
                "\t\t  return existing;\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(2);
        Assert.assertEquals("@Invokeable()\n" +
                "public async register(\n" +
                "  @Param(yup.string())\n" +
                "  id: string,\n" +
                "  @Param(yup.string())\n" +
                "  name: string\n" +
                ") {\n" +
                "\t\t  /* Retrieve to see if exists */\n" +
                "\t\t  const existing = await Participant.getOne(id);\n" +
                "\n" +
                "\t\t  if (!existing || !existing.id) {\n" +
                "\t\t    let participant = new Participant();\n" +
                "\t\t    participant.id = id;\n" +
                "\t\t    participant.name = name || id;\n" +
                "\t\t    participant.msp = this.fullIdentity.getMSPID();\n" +
                "\t\t    \n" +
                "\t\t    /* Create a new identity */\n" +
                "\t\t    participant.identities = [{\n" +
                "\t\t      fingerprint: this.sender,\n" +
                "\t\t      status: true\n" +
                "\t\t    }];\n" +
                "\t\t    \n" +
                "\t\t    await participant.save();\n" +
                "\t\t    \n" +
                "\t\t  } else {\n" +
                "\t\t    throw new Error('Identity exists already, please call changeIdentity fn for updates');\n" +
                "\t\t  }\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(3);
        Assert.assertEquals("\n" +
                "}", contentEntry.getContent());


        list = map.get("MainSystem\\controllers.ts");
        Assert.assertEquals(8, list.size());
        Collections.sort(list, Comparator.comparingInt(ContentEntry::getPosition).thenComparing(ContentEntry::getContent));

        contentEntry = list.get(0);
        Assert.assertEquals("import { Request, Response } from 'express';\n" +
                "import { PropertyControllerBackEnd } from '../convector';\n" +
                "import { ParticipantControllerBackEnd } from '../convector';", contentEntry.getContent());

        contentEntry = list.get(1);
        Assert.assertEquals("export async function ParticipantController_get(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await ParticipantControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post ParticipantController_get', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                " \n" +
                "\n" +
                "\t    transactionMessage(\"Get Participant Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(2);
        Assert.assertEquals("export async function ParticipantController_register(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await ParticipantControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post ParticipantController_register', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                "\n" +
                "\t  \n" +
                "\t  transactionMessage(\"Register Participant Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(3);
        Assert.assertEquals("export async function PropertyController_createProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_createProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                "\n" +
                "\t   transactionMessage(\"CreateProperty Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(4);
        Assert.assertEquals("export async function PropertyController_getProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_getProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                "\n" +
                "   \n" +
                "    \t    transactionMessage(\"Get Property Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(5);
        Assert.assertEquals("export async function PropertyController_transferProperty(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_transferProperty', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                "\n" +
                "\t  \n" +
                "  \ttransactionMessage(\"Transfer Property Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(6);
        Assert.assertEquals("export async function PropertyController_updateForSale(req: Request, res: Response): Promise<void>{\n" +
                "    try {\n" +
                "         let params = req.body;\n" +
                "              res.status(200).send(await PropertyControllerBackend\n" +
                "                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n" +
                "    } catch(ex){\n" +
                "        console.log('Error post PropertyController_updateForSale', ex.stack);\n" +
                "        res.status(500).send(ex)\n" +
                "    }\n" +
                "\n" +
                "\t      \n" +
                "\t      transactionMessage(\"updateForSale Success!\");\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(7);
        Assert.assertEquals("function transactionMessage(message: string) {\n" +
                "\n" +
                "\t       console.log(message); \n" +
                "\t   \n" +
                "}", contentEntry.getContent());

        System.out.println("******************************");


        list = map.get("Property\\property.model.ts");
        Assert.assertEquals(1, list.size());

        contentEntry = list.get(0);
        Assert.assertEquals("import * as yup from 'yup':\n" +
                "import {\n" +
                "  ConvectorModel,\n" +
                "  Default,\n" +
                "  ReadOnly,\n" +
                "  Required,\n" +
                "  Validate\n" +
                "} from '@worldsibu/convector-core-model'; \n" +
                "\n" +
                "export class Property extends ConvectorModel<Property> {\n" +
                "\n" +
                "  @ReadOnly() @Required() public readonly type = 'io.worldsibu.property';\n" +
                "\n" +
                "  \n" +
                "  public propertyType: string;\n" +
                "\n" +
                "  \n" +
                "  public assetOwner: string;\n" +
                "\n" +
                "  \n" +
                "  public isForSale: boolean;\n" +
                "\n" +
                "  @ReadOnly() @Required() @Validate(yup.number())\n" +
                "  public price: number;\n" +
                "\n" +
                "}", contentEntry.getContent());


        list = map.get("MainSystem\\PropertyMainSystem.Model.ts");
        Assert.assertEquals(1, list.size());

        contentEntry = list.get(0);
        Assert.assertEquals("export class PropertyMainSystem {\n" +
                "  public price: number;\n" +
                "}", contentEntry.getContent());


        list = map.get("Participant\\participant.model.ts");
        Assert.assertEquals(2, list.size());

        contentEntry = list.get(0);
        Assert.assertEquals("import * as yup from 'yup';\n" +
                "import {\n" +
                "  ConvectorModel,\n" +
                "  ReadOnly,\n" +
                "  Required,\n" +
                "  Validate,\n" +
                "  FlatConvectorModel\n" +
                "} from '@worldsibu/convector-core'; \n" +
                "\n" +
                "export class Participant extends ConvectorModel<Participant> {\n" +
                "\n" +
                "  @ReadOnly() @Required() public readonly type = 'io.worldsibu.examples.participant';\n" +
                "\n" +
                "  \n" +
                "  public name: string;\n" +
                "\n" +
                "  \n" +
                "  public msp: string;\n" +
                "\n" +
                "  \n" +
                "  public identities: Array<FlatConvectorModel<x509Identities>>;\n" +
                "\n" +
                "}", contentEntry.getContent());

        contentEntry = list.get(1);
        Assert.assertEquals("export class x509Identities extends ConvectorModel<x509Identities> {\n" +
                "\n" +
                "  @ReadOnly() public readonly type = 'io.worldsibu.examples.x509identity';\n" +
                "\n" +
                "  \n" +
                "  public status: boolean;\n" +
                "\n" +
                "  \n" +
                "  public fingerprint: string;\n" +
                "\n" +
                "}", contentEntry.getContent());
    }

}
