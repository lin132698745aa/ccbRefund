package ccb.cloud.sdk.dto;

public class RefundRequestDTO {
    private String merchantId;

    private String custId;

    private String transPwd;

    private String certPassword;

    private String txCode;

    private String language;

    private String url;

    private String certFilePath;

    private String configFilePath;

    private String refundNo;

    private String refundAmt;

    private String payRecordNo;

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getTransPwd() {
        return this.transPwd;
    }

    public void setTransPwd(String transPwd) {
        this.transPwd = transPwd;
    }

    public String getCertPassword() {
        return this.certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getTxCode() {
        return this.txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCertFilePath() {
        return this.certFilePath;
    }

    public void setCertFilePath(String certFilePath) {
        this.certFilePath = certFilePath;
    }

    public String getConfigFilePath() {
        return this.configFilePath;
    }

    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public String getRefundNo() {
        return this.refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getRefundAmt() {
        return this.refundAmt;
    }

    public void setRefundAmt(String refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getPayRecordNo() {
        return this.payRecordNo;
    }

    public void setPayRecordNo(String payRecordNo) {
        this.payRecordNo = payRecordNo;
    }
}
