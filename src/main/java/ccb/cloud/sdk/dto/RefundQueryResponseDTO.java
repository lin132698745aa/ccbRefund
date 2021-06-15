package ccb.cloud.sdk.dto;

import java.util.HashMap;
import java.util.List;

public class RefundQueryResponseDTO {
    private String RETURN_CODE;

    private String RETURN_MSG;

    private String tPage;

    private String curPage;

    private String notice;

    private List<HashMap> orderList;

    private String xml;

    public String getRETURN_CODE() {
        return RETURN_CODE;
    }

    public void setRETURN_CODE(String RETURN_CODE) {
        this.RETURN_CODE = RETURN_CODE;
    }

    public String getRETURN_MSG() {
        return RETURN_MSG;
    }

    public void setRETURN_MSG(String RETURN_MSG) {
        this.RETURN_MSG = RETURN_MSG;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String gettPage() {
        return tPage;
    }

    public void settPage(String tPage) {
        this.tPage = tPage;
    }

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public List<HashMap> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<HashMap> orderList) {
        this.orderList = orderList;
    }
}
