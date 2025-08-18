package com.fbol.paysafebatch.models.paysafeinput;

import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class InputFile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "file", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InputBatch> batches;
    private ProcessStatus status;

    private String fileName;

    // Fields from header.
    private String originatorId;
    private String fileDescription;
    private String dateFileSent;
    private String fiProcessorName;
    private BigInteger fiProcessorId;
    private BigInteger paysafeFileId;

    // Fields from footer.
    private int totalBatches;
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

    // Helper functions.
    public void AddBatch(InputBatch batch){
        if(this.batches == null){
            this.batches = new HashSet<>();
        }
        batch.setFile(this);
        batches.add(batch);
    }

    public void updateStatusCascade(ProcessStatus status){
        this.status = status;
        for(InputBatch batch: batches){
            batch.setStatus(status);
        }
    }

    // Override Methods
    @Override
    public String toString() {
        String nl = System.lineSeparator();
        String tabNl = nl + "      ";
        StringBuilder sb = new StringBuilder();
        sb.append("{" + nl);

        sb.append("   \"id\": " + id + "," + nl);
        sb.append("   \"batches\": [" + nl);

        for(InputBatch batch : this.batches){
            sb.append("      " + batch.toString().replaceAll(nl, tabNl) + "," + nl);
        }
        sb.append("   ]," + nl);

        sb.append("   \"status\": \"" + status + "\"," + nl);
        sb.append("   \"originatorId\": \"" + originatorId + "\"," + nl);
        sb.append("   \"fileDescription\": \"" + fileDescription + "\"," + nl);
        sb.append("   \"dateFileSent\": \"" + dateFileSent + "\"," + nl);
        sb.append("   \"fiProcessorName\": \"" + fiProcessorName + "\"," + nl);
        sb.append("   \"fiProcessorId\": " + fiProcessorId + "," + nl);
        sb.append("   \"paysafeFileId\": " + paysafeFileId + "," + nl);
        sb.append("   \"totalBatches\": " + totalBatches + "," + nl);
        sb.append("   \"totalCreditTransactions\": " + totalCreditTransactions + "," + nl);
        sb.append("   \"totalCreditAmount: " + totalCreditAmount + "," + nl);
        sb.append("   \"totalDebitTransactions\": " + totalDebitTransactions + "," + nl);
        sb.append("   \"totalDebitAmount\": " + totalDebitAmount + "," + nl);
        sb.append("   \"totalApprovedCreditTransactions\": " + totalApprovedCreditTransactions + "," + nl);
        sb.append("   \"totalApprovedCreditAmount\": " + totalApprovedCreditAmount + "," + nl);
        sb.append("   \"totalApprovedDebitTransactions\": " + totalApprovedDebitTransactions + "," + nl);
        sb.append("   \"totalApprovedDebitAmount\": " + totalApprovedDebitAmount + "," + nl);
        sb.append("   \"totalDeniedCreditTransactions\": " + totalDeniedCreditTransactions + "," + nl);
        sb.append("   \"totalDeniedCreditAmount\": " + totalDeniedCreditAmount + "," + nl);
        sb.append("   \"totalDeniedDebitTransactions\": " + totalDeniedDebitTransactions + "," + nl);
        sb.append("   \"totalDeniedDebitAmount\": " + totalDeniedDebitAmount + "," + nl);

        sb.append("}");
        return sb.toString();
    }

    // File Generation Methods.
    public ArrayList<String> GenerateFileResponse(){
        ArrayList<String> resp = new ArrayList<String>();
        resp.add(this.GenerateHeader());
        resp.addAll(this.GenerateBatches());
        resp.add(this.GenerateFooter());
        return resp;
    }

    public String GenerateHeader(){
        StringBuilder sb = new StringBuilder();

        sb.append("FH"); // 1-2
        sb.append(StringUtils.rightPad(this.originatorId, 30, ' ')); // 3-32
        sb.append(StringUtils.rightPad("Paysafe Return File", 30, ' ')); // 33-62
        sb.append(this.dateFileSent); // 63-70
        sb.append(StringUtils.rightPad(this.fiProcessorName, 30, ' ')); // 71-100
        sb.append(StringUtils.leftPad(this.fiProcessorId.toString(), 10, '0')); // 101-110
        sb.append(StringUtils.leftPad(this.paysafeFileId.toString(), 10, '0')); // 111-120
        for(Integer i = 0; i < 130; i++){ // 121-250
            sb.append(" ");
        }

        return sb.toString();
    }

    public ArrayList<String> GenerateBatches(){
        ArrayList<String> resp = new ArrayList<>();
        for(InputBatch batch : this.batches){
            resp.addAll(batch.generateBatchResponse());
        }
        return resp;
    }

    public String GenerateFooter(){
        StringBuilder sb = new StringBuilder();

        Integer numOfBatches = this.batches.size();
        this.setTotals();

        sb.append("FF"); // 1-2
        sb.append(StringUtils.leftPad(this.fiProcessorId.toString(), 10, '0')); // 3-12
        sb.append(StringUtils.leftPad(numOfBatches.toString(), 10, '0')); // 13-22
        sb.append(StringUtils.leftPad(this.getTotalApprovedCreditTransactions().toString(), 10, '0')); // 23-32
        sb.append(new DecimalFormat("000000000000.00").format(this.getTotalApprovedCreditAmount())); // 33-47
        sb.append(StringUtils.leftPad(this.getTotalDeniedCreditTransactions().toString(), 10, '0')); // 48-57
        sb.append(new DecimalFormat("000000000000.00").format(this.getTotalDeniedCreditAmount())); // 58-72
        sb.append(StringUtils.leftPad(this.getTotalApprovedDebitTransactions().toString(), 10, '0')); // 73-82
        sb.append(new DecimalFormat("000000000000.00").format(this.getTotalApprovedDebitAmount())); // 83-97
        sb.append(StringUtils.leftPad(this.getTotalDeniedDebitTransactions().toString(), 10, '0')); // 98-107
        sb.append(new DecimalFormat("000000000000.00").format(this.getTotalDeniedDebitAmount())); // 108-122
        for(int i = 0; i < 128; i++){ // 123-250
            sb.append(" ");
        }

        return sb.toString();
    }

    //File Parsers.
    public void parseHeader(String unparsed){
        this.originatorId = StringUtils.substring(unparsed, 2, 32).trim();
        this.fileDescription = StringUtils.substring(unparsed, 32, 62).trim();
        this.dateFileSent = StringUtils.substring(unparsed, 62, 70).trim();
        this.fiProcessorName = StringUtils.substring(unparsed, 70, 100).trim();
        this.fiProcessorId = new BigInteger(StringUtils.substring(unparsed, 100, 110));
        this.paysafeFileId = new BigInteger(StringUtils.substring(unparsed, 110, 120));
    }

    public void parseFooter(String unparsed){
        this.totalBatches = Integer.parseInt(StringUtils.substring(unparsed, 12, 22));
        this.totalCreditTransactions = Integer.parseInt(StringUtils.substring(unparsed, 22, 32));
        this.totalCreditAmount = Double.parseDouble(StringUtils.substring(unparsed, 32, 47));
        this.totalDebitTransactions = Integer.parseInt(StringUtils.substring(unparsed, 47, 57));
        this.totalDebitAmount = Double.parseDouble(StringUtils.substring(unparsed, 57, 72));
    }

    // Extra fields from the file that we wont save.
    public int getTotalTransactions(){
        return totalCreditTransactions + totalDebitTransactions;
    }

    public double getTotalAmount(){
        return totalCreditAmount + totalDebitAmount;
    }

    // Calculations needed for response file.
    public Integer getTotalApprovedCreditTransactions(){
        if(this.totalApprovedCreditTransactions != null){
            return this.totalApprovedCreditTransactions;
        }
        int resp = 0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalApprovedCreditTransactions();
        }

        this.totalApprovedCreditTransactions = resp;
        return resp;
    }

    public double getTotalApprovedCreditAmount(){
        if(this.totalApprovedCreditAmount != null){
            return this.totalApprovedCreditAmount;
        }
        double resp = 0.0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalApprovedCreditAmount();
        }

        this.totalApprovedCreditAmount = resp;
        return resp;
    }

    public Integer getTotalApprovedDebitTransactions(){
        if(this.totalApprovedDebitTransactions != null){
            return this.totalApprovedDebitTransactions;
        }
        int resp = 0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalApprovedDebitTransactions();
        }

        this.totalApprovedDebitTransactions = resp;
        return resp;
    }

    public double getTotalApprovedDebitAmount(){
        if(this.totalApprovedDebitAmount != null){
            return this.totalApprovedDebitAmount;
        }
        double resp = 0.0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalApprovedDebitAmount();
        }

        this.totalApprovedDebitAmount = resp;
        return resp;
    }

    public Integer getTotalDeniedCreditTransactions(){
        if(this.totalDeniedCreditTransactions != null){
            return this.totalDeniedCreditTransactions;
        }
        Integer resp = 0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalDeniedCreditTransactions();
        }

        this.totalDeniedCreditTransactions = resp;
        return resp;
    }

    public double getTotalDeniedCreditAmount(){
        if(this.totalDeniedCreditAmount != null){
            return this.totalDeniedCreditAmount;
        }
        double resp = 0.0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalDeniedCreditAmount();
        }

        this.totalDeniedCreditAmount = resp;
        return resp;
    }

    public Integer getTotalDeniedDebitTransactions(){
        if(this.totalDeniedDebitTransactions != null){
            return this.totalDeniedDebitTransactions;
        }
        int resp = 0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalDeniedDebitTransactions();
        }

        this.totalDeniedDebitTransactions = resp;
        return resp;
    }

    public double getTotalDeniedDebitAmount(){
        if(this.totalDeniedDebitAmount != null){
            return this.totalDeniedDebitAmount;
        }
        double resp = 0.0;

        for(InputBatch batch : this.batches){
            resp += batch.getTotalDeniedDebitAmount();
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

        for(InputBatch batch : this.batches){
            this.totalApprovedCreditTransactions += batch.getTotalApprovedCreditTransactions();
            this.totalApprovedCreditAmount += batch.getTotalApprovedCreditAmount();
            this.totalApprovedDebitTransactions += batch.getTotalApprovedDebitTransactions();
            this.totalApprovedDebitAmount += batch.getTotalApprovedDebitAmount();
            this.totalDeniedCreditTransactions += batch.getTotalDeniedCreditTransactions();
            this.totalDeniedCreditAmount += batch.getTotalDeniedCreditAmount();
            this.totalDeniedDebitTransactions += batch.getTotalDeniedDebitTransactions();
            this.totalDeniedDebitAmount += batch.getTotalDeniedDebitAmount();
        }
    }

    // Constructors.
    public InputFile(){
        this.status = ProcessStatus.New;
        this.batches = new HashSet<InputBatch>();
    }

    public InputFile(ArrayList<String> unparsedStrings){
        this.batches = new HashSet<InputBatch>();
        this.status = ProcessStatus.Read;
        this.fileName = unparsedStrings.get(0);
        for(int i = 1; i < unparsedStrings.size(); i++){
            String single = unparsedStrings.get(i);
            String indicator = StringUtils.substring(single, 0, 2);
            switch(indicator){
                case "FH": {
                    this.parseHeader(single);
                    break;
                }
                case "BH": {
                    ArrayList<String> batchStrings = new ArrayList<String>();
                    batchStrings.add(single);
                    Boolean inBatch = true;
                    while(inBatch){
                        i++;
                        String batchSingle = unparsedStrings.get(i);
                        String batchIndicator = StringUtils.substring(batchSingle, 0, 2);
                        switch(batchIndicator){
                            case "DE": {
                                batchStrings.add(batchSingle);
                                break;
                            }
                            case "BF": {
                                batchStrings.add(batchSingle);
                                inBatch = false;
                                break;
                            }
                            default: {
                                throw new RuntimeException("There is an unexpected string within the batch. Please double check the file and try again.");
                            }
                        }
                    }
                    this.AddBatch(new InputBatch(batchStrings));
                    break;
                }
                case "FF": {
                    this.parseFooter(single);
                    break;
                }
                default: {
                    // We check this because the file usually has a blank line at the end.
                    single = single.trim();
                    if(single.length() > 0){
                        throw new RuntimeException("There is an unexpected string within the file. Please double check the file and try again.");
                    }
                }
            }
        }
    }

    // Getters and setters.
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<InputBatch> getBatches() {
        return batches;
    }

    public void setBatches(Set<InputBatch> batches) {
        this.batches = batches;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getDateFileSent() {
        return dateFileSent;
    }

    public void setDateFileSent(String dateFileSent) {
        this.dateFileSent = dateFileSent;
    }

    public BigInteger getFiProcessorId() {
        return fiProcessorId;
    }

    public void setFiProcessorId(BigInteger fiProcessorId) {
        this.fiProcessorId = fiProcessorId;
    }

    public BigInteger getPaysafeFileId() {
        return paysafeFileId;
    }

    public void setPaysafeFileId(BigInteger paysafeFileId) {
        this.paysafeFileId = paysafeFileId;
    }

    public int getTotalBatches() {
        return totalBatches;
    }

    public void setTotalBatches(int totalBatches) {
        this.totalBatches = totalBatches;
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

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }

    public String getFiProcessorName() {
        return fiProcessorName;
    }

    public void setFiProcessorName(String fiProcessorName) {
        this.fiProcessorName = fiProcessorName;
    }
}
