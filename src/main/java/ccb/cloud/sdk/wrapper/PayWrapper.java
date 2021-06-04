package ccb.cloud.sdk.wrapper;

import ccb.cloud.sdk.dto.RefundRequestDTO;
import ccb.cloud.sdk.dto.RefundResponseDTO;
import com.ccb.wlpt.RequestProcess;
import java.io.ByteArrayInputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping({"/ccb/pay"})
public class PayWrapper {
    @PostMapping({"/refund"})
    @ResponseBody
    public RefundResponseDTO refund(@RequestBody RefundRequestDTO requestDTO) {
        RefundResponseDTO responseDTO = new RefundResponseDTO();
        try {
            String certFile = requestDTO.getCertFilePath();
            String configFile = requestDTO.getConfigFilePath();
            String merchantId = requestDTO.getMerchantId();
            String custId = requestDTO.getCustId();
            String certPassword = requestDTO.getCertPassword();
            String transPwd = requestDTO.getTransPwd();
            String txCode = requestDTO.getTxCode();
            String language = requestDTO.getLanguage();
            String refundAmt = requestDTO.getRefundAmt();
            String payRecordNo = requestDTO.getPayRecordNo();
            String refundNo = requestDTO.getRefundNo();
            String url = requestDTO.getUrl();
            String initCert = RequestProcess.initFileCert(merchantId, custId, certFile, certPassword, configFile);
            System.out.println(initCert);
            if (initCert == null || initCert.length() == 0) {
                String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><TX><REQUEST_SN>" + refundNo + "</REQUEST_SN><CUST_ID>" + merchantId + "</CUST_ID><USER_ID>" + custId + "</USER_ID><PASSWORD>" + transPwd + "</PASSWORD><TX_CODE>" + txCode + "</TX_CODE><LANGUAGE>" + language + "</LANGUAGE><TX_INFO><MONEY>" + refundAmt + "</MONEY><ORDER>" + payRecordNo + "</ORDER><REFUND_CODE>" + refundNo + "</REFUND_CODE></TX_INFO></TX>";
                String responseXml = RequestProcess.sendRequest(url, xml);
                SAXReader reader = new SAXReader();
                Document document = reader.read(new ByteArrayInputStream(responseXml.getBytes("GBK")));
                Element rootElement = document.getRootElement();
                QName qName = rootElement.getQName();
                String tx = qName.getName();
                if (tx != null && tx.length() > 0) {
                    Element returnCodeNode = rootElement.element("RETURN_CODE");
                    Element returnMsgNode = rootElement.element("RETURN_MSG");
                    String returnCode = returnCodeNode.getStringValue();
                    if ("000000".equalsIgnoreCase(returnCode)) {
                        Element txInfo = rootElement.element("TX_INFO");
                        Element orderNumNode = txInfo.element("ORDER_NUM");
                        String returnMsg = returnMsgNode.getStringValue();
                        responseDTO.setRETURN_CODE(returnCode);
                        responseDTO.setRETURN_MSG(returnMsg);
                        responseDTO.setORDER_NUM(orderNumNode.getStringValue());
                        responseDTO.setTX_INFO(txInfo.getStringValue());
                    } else {
                        String returnMsg = returnMsgNode.getStringValue();
                        responseDTO.setRETURN_CODE(returnCode);
                        responseDTO.setRETURN_MSG(returnMsg);
                    }
                } else {
                    responseDTO.setRETURN_CODE("99997");
                }
            } else {
                responseDTO.setRETURN_CODE("99998");
            }
        } catch (Exception e) {
            responseDTO.setRETURN_CODE("99999");
        }
        return responseDTO;
    }
}
