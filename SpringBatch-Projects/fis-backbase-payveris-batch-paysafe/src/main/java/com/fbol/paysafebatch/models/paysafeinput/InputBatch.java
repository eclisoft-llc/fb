package com.fbol.paysafebatch.models.paysafeinput;

import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import com.fbol.paysafebatch.models.paysafeinput.enums.TransactionCode;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InputBatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private InputFile file;
    @OneToMany(mappedBy = "batch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InputEntry> entries;
    private ProcessStatus status;


    // Fields from header.
    private BigInteger batchId;
    private String batchDescription;
    private BigInteger fiId;
    private String fiName;
    private BigInteger holdingAccountNumber;
    private BigInteger holdingAccountRouting;

    // Fields from footer.
    private int totalCreditTransactions;
    private double totalCreditAmount;
    private int totalDebitTransactions;
    private double totalDebitAmount;

    // Fields for the response file.
    private Integer totalApprovedCreditTransactions;
    private Double totalApprovedCreditAmount;
    private Integer totalApprovedDebitTransactions;
    private Double totalApprovedDebitAmount;
    private Integer totalDeniedCreditTransactions;
    private Double totalDeniedCreditAmount;
    private Integer totalDeniedDebitTransactions;
    private Double totalDeniedDebitAmount;

    // Override Methods.
    @Override
    public String toString() {
        String nl = System.lineSeparator();
        String tabNl = nl + "      ";
        StringBuilder sb = new StringBuilder();
        sb.append("{" + nl);

        sb.append("   \"id\": " + id + "," + nl);
        sb.append("   \"entries\": [" + nl);

        for(InputEntry entry : this.entries){
             sb.append("      " + entry.toString().replaceAll(nl, tabNl) + "," + nl);
        }
        sb.append("   ]," + nl);

        sb.append("   \"status\": \"" + status + "\"," + nl);
        sb.append("   \"batchId\": " + batchId + "," + nl);
        sb.append("   \"batchDescription\": \"" + batchDescription + "\"," + nl);
        sb.append("   \"fiId\": " + fiId + "," + nl);
        sb.append("   \"fiName\": \"" + fiName + "\"," + nl);
        sb.append("   \"holdingAccountNumber\": " + holdingAccountNumber + "," + nl);
        sb.append("   \"holdingAccountRouting\": " + holdingAccountRouting + "," + nl);
        sb.append("   \"totalCreditTransactions\": " + totalCreditTransactions + "," + nl);
        sb.append("   \"totalCreditAmount\": " + totalCreditAmount + "," + nl);
        sb.append("   \"totalDebitTransactions\": " + totalDebitTransactions + "," + nl);
        sb.append("   \"totalDebitAmount\": " + totalDebitAmount + "," + nl);
        sb.append("   \"totalApprovedCreditTransactions\": " + totalApprovedCreditTransactions + "," + nl);
        sb.append("   \"totalApprovedCreditAmount\": " + totalApprovedCreditAmount + "," + nl);
        sb.append("   \"totalApprovedDebitTransactions\": " + totalApprovedDebitTransactions + "," + nl);
        sb.append("   \"totalApprovedDebitAmount\": " + totalApprovedDebitAmount + "," + nl);
        sb.append("   \"totalDeniedCreditTransactions\": " + totalDeniedCreditTransactions + "," + nl);
        sb.append("   \"totalDeniedCreditAmount\": " + totalDeniedCreditAmount + "," + nl);
        sb.append("   \"totalDeniedDebitTransactions\": " + totalDeniedDebitTransactions + "," + nl);
        sb.append("   \"totalDeniedDebitAmount\": " + totalDeniedDebitAmount + nl);

        sb.append("}");
        return sb.toString();
    }

    // Helper functions.
    public void AddEntry(InputEntry entry){
        if(this.entries == null){
            this.entries = new HashSet<>();
        }
        entry.setBatch(this);
        entries.add(entry);
    }

    public void updateStatusCascade(ProcessStatus status){
        this.status = status;
        for(InputEntry entry: entries){
            entry.setStatus(status);
        }
    }

    // File Parsers.
    public void parseHeader(String unparsed){
        this.batchId = new BigInteger(StringUtils.substring(unparsed, 2,12));
        this.batchDescription = StringUtils.substring(unparsed, 12, 42).trim();
        this.fiId = new BigInteger(StringUtils.substring(unparsed, 42,52));
        this.fiName = StringUtils.substring(unparsed, 52,82).trim();
        this.holdingAccountNumber = new BigInteger(StringUtils.substring(unparsed, 82, 99));
        this.holdingAccountRouting = new BigInteger(StringUtils.substring(unparsed, 99, 108));
    }

    public void parseFooter(String unparsed){
        this.totalCreditTransactions = Integer.parseInt(StringUtils.substring(unparsed, 22, 32));
        this.totalCreditAmount = Double.parseDouble(StringUtils.substring(unparsed, 32, 47));
        this.totalDebitTransactions = Integer.parseInt(StringUtils.substring(unparsed, 47, 57));
        this.totalDebitAmount = Double.parseDouble(StringUtils.substring(unparsed, 57, 72));
    }

    public void parseEntries(ArrayList<String> unparsedStrings){
        if(entries == null){
            this.entries = new HashSet<InputEntry>();
        }

        for(int i = 0; i < unparsedStrings.size(); i++){
            this.AddEntry(new InputEntry(unparsedStrings.get(i)));
        }
    }

    // Response File String generators.
    public ArrayList<String> generateBatchResponse(){
        ArrayList<String> batch = new ArrayList<String>();
        batch.add(this.generateBatchHeader());
        ArrayList<String> entryResponses = this.generateEnrties();
        batch.addAll(entryResponses);
        batch.add(this.generateBatchFooter());
        return batch;
    }

    public String generateBatchHeader(){
        StringBuilder sb = new StringBuilder();

        sb.append("BH"); // 1-2
        sb.append(StringUtils.leftPad(this.batchId.toString(), 10, '0')); // 3-12
        sb.append(StringUtils.rightPad(this.batchDescription, 30, ' ')); // 13-42
        sb.append(StringUtils.leftPad(this.fiId.toString(), 10, '0')); // 43-52
        sb.append(StringUtils.rightPad(this.fiName, 30, ' ')); // 53-82
        sb.append(StringUtils.leftPad(this.holdingAccountNumber.toString(), 17, '0')); // 83-99
        sb.append(StringUtils.leftPad(this.holdingAccountRouting.toString(), 9, '0')); // 100-108
        for(Integer i = 0; i < 142; i++){ // 109-250
            sb.append(" ");
        }
        return sb.toString();
    }

    public ArrayList<String> generateEnrties(){
        ArrayList<String> resp = new ArrayList<String>();

        for(InputEntry entry : this.entries){
            resp.add(entry.generateResponse());
        }

        return resp;
    }

    public String generateBatchFooter(){
        StringBuilder sb = new StringBuilder();

        this.setTotals();
        Integer apprCrTrans = this.getTotalApprovedCreditTransactions();
        double appCrAmt = this.getTotalApprovedCreditAmount();
        Integer deniedCrTrans = this.getTotalDeniedCreditTransactions();
        double denCrAmt = this.getTotalDeniedCreditAmount();
        Integer apprDbTrans = this.getTotalApprovedDebitTransactions();
        double appDbAmt = this.getTotalApprovedDebitAmount();
        Integer deniedDbTrans = this.getTotalDeniedDebitTransactions();
        double denDbAmt = this.getTotalDeniedDebitAmount();
        double netAmount = appCrAmt - appDbAmt;
        TransactionCode netCode = TransactionCode.DB;
        if(netAmount > 0){
            netCode = TransactionCode.CR;
        }

        sb.append("BF"); // 1-2
        sb.append(StringUtils.leftPad(this.batchId.toString(), 10, '0')); // 3-12
        sb.append(StringUtils.leftPad(this.fiId.toString(), 10, '0')); // 13-22
        sb.append(StringUtils.leftPad(apprCrTrans.toString(), 10, '0')); // 23-32
        sb.append(new DecimalFormat("000000000000.00").format(appCrAmt)); // 33-47
        sb.append(StringUtils.leftPad(deniedCrTrans.toString(), 10, '0')); // 48-57
        sb.append(new DecimalFormat("000000000000.00").format(denCrAmt)); // 58-72
        sb.append(StringUtils.leftPad(apprDbTrans.toString(), 10, '0')); // 73-82
        sb.append(new DecimalFormat("000000000000.00").format(appDbAmt)); // 83-97
        sb.append(StringUtils.leftPad(deniedDbTrans.toString(), 10, '0')); // 98-107
        sb.append(new DecimalFormat("000000000000.00").format(denDbAmt)); // 108-122
        sb.append(new DecimalFormat("000000000000.00").format(netAmount)); // 123-137
        sb.append(netCode.toString());
        for(Integer i = 0; i < 111; i++){ // 140-250
            sb.append(" ");
        }

        return sb.toString();
    }

    // Calculations needed for response file.
    public int getTotalApprovedCreditTransactions(){
        if(this.totalApprovedCreditTransactions != null){
            return this.totalApprovedCreditTransactions;
        }
        int resp = 0;

        for(InputEntry entry : this.entries){
            if(entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.CR){
                resp++;
            }
        }
        this.totalApprovedCreditTransactions = resp;
        return resp;
    }

    public int getTotalApprovedDebitTransactions(){
        if(this.totalApprovedDebitTransactions != null){
            return this.totalApprovedDebitTransactions;
        }
        int resp = 0;

        for(InputEntry entry : this.entries){
            if(entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.DB){
                resp++;
            }
        }

        this.totalApprovedDebitTransactions = resp;
        return resp;
    }

    public double getTotalApprovedCreditAmount(){
        if(this.totalApprovedCreditAmount != null){
            return this.totalApprovedCreditAmount;
        }
        double resp = 0.0;

        for(InputEntry entry : this.entries){
            if(entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.CR){
                resp += entry.getAmount();
            }
        }
        this.totalApprovedCreditAmount = resp;
        return resp;
    }

    public double getTotalApprovedDebitAmount(){
        if(this.totalApprovedDebitAmount != null){
            return this.totalApprovedDebitAmount;
        }
        double resp = 0.0;

        for(InputEntry entry : this.entries){
            if(entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.DB){
                resp += entry.getAmount();
            }
        }

        this.totalApprovedDebitAmount = resp;
        return resp;
    }

    public Integer getTotalDeniedCreditTransactions(){
        if(this.totalDeniedCreditTransactions != null){
            return this.totalDeniedCreditTransactions;
        }

        Integer resp = 0;

        for(InputEntry entry : this.entries){
            if(!entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.CR){
                resp++;
            }
        }

        this.totalDeniedCreditTransactions = resp;
        return resp;
    }

    public Integer getTotalDeniedDebitTransactions(){
        if(this.totalDeniedDebitTransactions != null){
            return this.totalDeniedDebitTransactions;
        }
        Integer resp = 0;

        for(InputEntry entry : this.entries){
            if(!entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.DB){
                resp++;
            }
        }

        this.totalDeniedDebitTransactions = resp;
        return resp;
    }

    public double getTotalDeniedCreditAmount(){
        if(this.totalDeniedCreditAmount != null){
            return this.totalDeniedCreditAmount;
        }
        double resp = 0.0;

        for(InputEntry entry : this.entries){
            if(!entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.CR){
                resp += entry.getAmount();
            }
        }

        this.totalDeniedCreditAmount = resp;
        return resp;
    }

    public double getTotalDeniedDebitAmount(){
        if(this.totalDeniedDebitAmount != null){
            return this.totalDeniedDebitAmount;
        }
        double resp = 0.0;

        for(InputEntry entry : this.entries){
            if(!entry.getTransactionApproval() && entry.getTransactionCode() == TransactionCode.DB){
                resp += entry.getAmount();
            }
        }

        this.totalDeniedDebitAmount = resp;
        return resp;
    }

    public void setTotals(){
        this.totalApprovedCreditTransactions = 0;
        this.totalApprovedCreditAmount = 0.0;
        this.totalApprovedDebitTransactions = 0;
        this.totalApprovedDebitAmount = 0.0;
        this.totalDeniedCreditTransactions = 0;
        this.totalDeniedCreditAmount = 0.0;
        this.totalDeniedDebitTransactions = 0;
        this.totalDeniedDebitAmount = 0.0;

        for(InputEntry entry : this.entries){
            if(entry.getTransactionCode() == TransactionCode.CR){
                if(entry.getTransactionApproval()){
                    // Approved credit transactions.
                    this.totalApprovedCreditTransactions++;
                    this.totalApprovedCreditAmount += entry.getAmount();
                } else {
                    // Denied credit transactions.
                    this.totalDeniedCreditTransactions++;
                    this.totalDeniedCreditAmount += entry.getAmount();
                }
            } else if(entry.getTransactionCode() == TransactionCode.DB){ // this should be everything else, but just in case we still check.
                if(entry.getTransactionApproval()){
                    // Approved debit transactions.
                    this.totalApprovedDebitTransactions++;
                    this.totalApprovedDebitAmount += entry.getAmount();
                } else {
                    // Denied debit transactions.
                    this.totalDeniedDebitTransactions++;
                    this.totalDeniedDebitAmount += entry.getAmount();
                }
            } else {
                System.out.println("Transaction code with entry: '" + Integer.toString(entry.getId()) + "' is invalid.");
            }
        }
    }

    // Extra fields from the file that we wont save.
    public int getTotalTransactions(){
        return this.totalCreditTransactions + this.totalDebitTransactions;
    }

    public double getTotalAmount(){
        return this.totalCreditAmount + this.totalDebitAmount;
    }

    // Constructors
    public InputBatch(){
        this.status = ProcessStatus.New;
        this.entries = new HashSet<InputEntry>();
    }

    public InputBatch(ArrayList<String> unparsedStrings) {
        this.parseHeader(unparsedStrings.get(0));
            this.parseEntries(new ArrayList<String>(unparsedStrings.subList(1, (unparsedStrings.size() - 1))));
        this.parseFooter(unparsedStrings.get(unparsedStrings.size() - 1));
        this.status = ProcessStatus.Read;
    }

    // Getters and setters.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getBatchId() {
        return batchId;
    }

    public void setBatchId(BigInteger batchId) {
        this.batchId = batchId;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public BigInteger getFiId() {
        return fiId;
    }

    public void setFiId(BigInteger fiId) {
        this.fiId = fiId;
    }

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    public BigInteger getHoldingAccountNumber() {
        return holdingAccountNumber;
    }

    public void setHoldingAccountNumber(BigInteger holdingAccountNumber) {
        this.holdingAccountNumber = holdingAccountNumber;
    }

    public BigInteger getHoldingAccountRouting() {
        return holdingAccountRouting;
    }

    public void setHoldingAccountRouting(BigInteger holdingAccountRouting) {
        this.holdingAccountRouting = holdingAccountRouting;
    }

    public int getTotalCreditTransactions() {
        return totalCreditTransactions;
    }

    public void setTotalCreditTransactions(int totalCreditTransactions) {
        this.totalCreditTransactions = totalCreditTransactions;
    }

    public double getTotalCreditAmount() {
        return totalCreditAmount;
    }

    public void setTotalCreditAmount(double totalCreditAmount) {
        this.totalCreditAmount = totalCreditAmount;
    }

    public int getTotalDebitTransactions() {
        return totalDebitTransactions;
    }

    public void setTotalDebitTransactions(int totalDebitTransactions) {
        this.totalDebitTransactions = totalDebitTransactions;
    }

    public double getTotalDebitAmount() {
        return totalDebitAmount;
    }

    public void setTotalDebitAmount(double totalDebitAmount) {
        this.totalDebitAmount = totalDebitAmount;
    }

    public InputFile getFile() {
        return file;
    }

    public void setFile(InputFile file) {
        this.file = file;
    }

    public Set<InputEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<InputEntry> entries) {
        this.entries = entries;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }
}
