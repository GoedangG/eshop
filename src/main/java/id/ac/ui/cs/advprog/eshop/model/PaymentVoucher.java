package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentStatus;
import java.util.Map;

public class PaymentVoucher extends Payment{
    public PaymentVoucher(String id, String method, Map<String, String> paymentData) {
        super(id, method, paymentData);
    }

    public PaymentVoucher(String id, String method, Map<String, String> paymentData, String status){
        super(id, method, paymentData, status);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData){
        if(paymentData.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            int num = 0;
            for(char c : paymentData.get("voucherCode").toCharArray()){
                if(Character.isDigit(c)){
                    num++;
                }
            }
            this.paymentData = paymentData;
            if(paymentData.get("voucherCode").length() == 16 && paymentData.get("voucherCode").startsWith("ESHOP") && num == 8){
                this.status = PaymentStatus.SUCCESS.getValue();
            }else{
                this.status = PaymentStatus.REJECTED.getValue();
            }
        }
    }
}
