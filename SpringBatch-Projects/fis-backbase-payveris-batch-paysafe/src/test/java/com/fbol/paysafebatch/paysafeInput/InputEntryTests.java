package com.fbol.paysafebatch.paysafeInput;

import com.fbol.paysafebatch.models.paysafeinput.InputEntry;
import com.fbol.paysafebatch.models.paysafeinput.enums.PaysafeTransactionType;
import com.fbol.paysafebatch.models.paysafeinput.enums.TransactionCode;
import org.junit.Assert;
import org.junit.Test;

public class InputEntryTests {
    @Test
    public void inputEntry_ParseString(){
        InputEntry check = new InputEntry("DEPIN            DB011900254000000000012325690000020.55000000007640252Aaron Anderson                               000000001526659PIN TRANSACTION     Jeff Dickey                         2345                                                            ");

        Assert.assertEquals(PaysafeTransactionType.PIN, check.getTransactionType());
        Assert.assertEquals(TransactionCode.DB, check.getTransactionCode());
        Assert.assertEquals(11900254, check.getRoutingNumber());
        Assert.assertEquals(1232569, check.getAccountNumber());
        Assert.assertEquals(20.55f, check.getAmount(), 0);
        Assert.assertEquals(7640252, check.getConfirmationNumber());
        Assert.assertEquals("Aaron Anderson", check.getConsumerName());
        Assert.assertEquals(1526659, check.getTransactionTraceNumber());
        Assert.assertEquals("PIN TRANSACTION", check.getTransactionDescription());
        Assert.assertEquals("Jeff Dickey", check.getPayeeName());
        Assert.assertEquals("2345", check.getPayeeAccountNumber());
        Assert.assertEquals("", check.getCoreSpecificCode());
    }

    @Test
    public void inputEntry_GenerateResponse(){
        InputEntry check = new InputEntry("DEPIN            DB011900254000000000012325690000020.55000000007640252Aaron Anderson                               000000001526659PIN TRANSACTION     Jeff Dickey                         2345                                                            ");
        check.setTransactionApproval(true);
        String expected = "DEPIN            DB011900254000000000012325690000020.55000000007640252Aaron Anderson                               000000001526659PIN TRANSACTION     Jeff Dickey                         2345                              Y                             ";
        Assert.assertEquals(expected, check.generateResponse());
    }
}
