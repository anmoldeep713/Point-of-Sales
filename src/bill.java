
public class bill {
    int billId;
    String dateTime;
    int gtotal;
    String admnEmail;
    String phoneNo;
    String paymentType;
    
    public bill(int bId, String date, int gt, String admail, String phno, String payType)
    {
        billId=bId;
        dateTime=date;
        gtotal=gt;
        admnEmail=admail;
        phoneNo=phno;
        paymentType=payType;
    }
    
}
