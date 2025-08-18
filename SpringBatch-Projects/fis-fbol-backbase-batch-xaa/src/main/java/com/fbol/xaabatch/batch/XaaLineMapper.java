package com.fbol.xaabatch.batch;

import com.fbol.xaabatch.model.Xaa;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class XaaLineMapper implements LineMapper<Xaa> {

    private MultiResourceItemReader delegator;

    public XaaLineMapper(MultiResourceItemReader delegator) {
         this.delegator = delegator;
    }

    @Override
    public Xaa mapLine(String line, int lineNumber) throws Exception {

        String[] fields = line.split("\t");
        ArrayList<String> fieldList = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            fieldList.add(fields[i].replaceAll("\"", ""));
        }

        Xaa xaa = new Xaa();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        if(fieldList.size()>0) {
            xaa.setAccountnumber(String.valueOf(fieldList.get(0)).trim());
            if (fieldList.size() > 1)
                xaa.setFullstatementnumber(String.valueOf(fieldList.get(1)).trim());
            if (fieldList.size() > 2)
                xaa.setStatementdate(LocalDate.parse((String.valueOf(fieldList.get(2)).trim()), formatter));
        }

        return xaa;
    }
}