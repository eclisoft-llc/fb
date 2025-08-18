package com.fbol.paysafebatch.paysafeInput;

import org.junit.Test;

public class InputFileTests {
    @Test
    public void inputFile_ParseConstructor(){

    }

    @Test
    public void inputFile_ParseHeader(){
        String header = "FHPayveris Bill Payment         ONLINE BILL PAY               03312020IBT                           00000000020000283008                                                                                                                                  ";
    }

    @Test
    public void inputFile_ParseFooter(){
        String footer = "FF000000000200000000030000000000000000000000.000000000004000000000079.640000000004000000000079.64                                                                                                                                                         ";
    }

    @Test
    public void inputFile_GenerateResponse(){

    }

    @Test
    public void inputFile_GenerateHeader(){

    }

    @Test
    public void inputFile_GenerateFooter(){

    }

    @Test
    public void inputFile_GenerateBatches(){

    }
}
