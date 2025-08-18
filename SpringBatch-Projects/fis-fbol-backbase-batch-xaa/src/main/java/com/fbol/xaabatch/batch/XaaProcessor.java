package com.fbol.xaabatch.batch;


import com.fbol.xaabatch.model.Xaa;
import org.springframework.batch.item.ItemProcessor;

public class XaaProcessor implements ItemProcessor<Xaa, Xaa>
{
  public Xaa process(Xaa xaa) throws Exception
  {
    xaa.setFilename(xaa.getResource().getFilename());
    return xaa;
  }
}