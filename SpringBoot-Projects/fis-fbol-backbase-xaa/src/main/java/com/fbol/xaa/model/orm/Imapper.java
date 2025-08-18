package com.fbol.xaa.model.orm;

import com.fbol.xaa.model.Xaa;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface Imapper {

    @Select({"SELECT accountnumber,fullstatementnumber, statementdate FROM XAASTATEMENTS WHERE accountnumber=#{accnum}"})
    @Options(statementType = StatementType.PREPARED)
    List<Xaa> getbyaccnum(@Param("accnum") String accnum);

    @Select({"SELECT accountnumber,fullstatementnumber, statementdate FROM XAASTATEMENTS WHERE accountnumber=#{accnum}" +
            " AND statementdate=#{date}"})
    @Options(statementType = StatementType.PREPARED)
    List<Xaa> getbyaccnumanddate(@Param("accnum") String accnum,@Param("date") LocalDateTime date);

    @Select({"SELECT accountnumber,fullstatementnumber, statementdate FROM XAASTATEMENTS WHERE accountnumber=#{accnum}" +
            " AND statementdate>=#{sdate}"})
    @Options(statementType = StatementType.PREPARED)
    List<Xaa> getbyaccnumandsdate(@Param("accnum") String accnum,@Param("sdate") LocalDateTime sdate);

    @Select({"SELECT accountnumber,fullstatementnumber, statementdate FROM XAASTATEMENTS WHERE accountnumber=#{accnum}" +
            " AND statementdate<=#{edate}"})
    @Options(statementType = StatementType.PREPARED)
    List<Xaa> getbyaccnumandedate(@Param("accnum") String accnum,@Param("edate") LocalDateTime edate);

    @Select({"SELECT accountnumber,fullstatementnumber, statementdate FROM XAASTATEMENTS WHERE accountnumber=#{accnum}" +
            " AND statementdate>=#{sdate} AND statementdate<=#{edate}"})
    @Options(statementType = StatementType.PREPARED)
    List<Xaa> getbyaccnumandsdateandedate(@Param("accnum") String accnum,@Param("sdate") LocalDateTime sdate,
                                          @Param("edate") LocalDateTime edate);
}

