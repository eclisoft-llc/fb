package com.fbol.paysafebatch.batch.paysafeinputfilejob.retrievestep;

import com.fbol.paysafebatch.models.paysafeinput.InputFile;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RetrieveProcessor implements ItemProcessor<ArrayList<String>, InputFile> {
    @Override
    public InputFile process(ArrayList<String> data) throws Exception {
        return new InputFile(data);
    }
}
