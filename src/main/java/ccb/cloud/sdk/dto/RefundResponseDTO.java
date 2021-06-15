package ccb.cloud.sdk.dto;

public class RefundResponseDTO {
    private String RETURN_CODE;

    private String RETURN_MSG;

    private String TX_INFO;

    private String ORDER_NUM;

    public String getRETURN_CODE() {
        return this.RETURN_CODE;
    }

    public void setRETURN_CODE(String RETURN_CODE) {
        this.RETURN_CODE = RETURN_CODE;
    }

    public String getRETURN_MSG() {
        return this.RETURN_MSG;
    }

    public void setRETURN_MSG(String RETURN_MSG) {
        this.RETURN_MSG = RETURN_MSG;
    }

    public String getTX_INFO() {
        return this.TX_INFO;
    }

    public void setTX_INFO(String TX_INFO) {
        this.TX_INFO = TX_INFO;
    }

    public String getORDER_NUM() {
        return this.ORDER_NUM;
    }

    public void setORDER_NUM(String ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
    }
}
