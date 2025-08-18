package com.fbol.paysafebatch.paysafeInput;

import org.junit.Test;

public class InputBatchTests {
    @Test
    public void inputBatch_ParseConstructor(){

    }

    @Test
    public void inputBatch_ParseHeader(){
        String header = "BH0000023321P2P Transfers                 0000000001Payveris Test Bank            00000000000012345211170101                                                                                                                                              ";
    }

    @Test
    public void inputBatch_ParseFooter(){
        String footer = "BF000002332100000000010000000000000000000000.000000000001000000000020.550000000001000000000020.55                                                                                                                                                         ";

    }

    @Test void inputBatch_ParseEntries(){

    }

    @Test
    public void inputBatch_GenerateResponse(){

    }

    @Test
    public void inputBatch_GenerateHeader(){

    }

    @Test
    public void inputBatch_GenerateFooter(){

    }

    @Test
    public void inputBatch_GenerateEntries(){

    }
}
