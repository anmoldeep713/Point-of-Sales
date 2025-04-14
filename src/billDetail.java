
public class billDetail {
    int billDetailId;
    int billId;
    String prodName;
    int offerPrice;
    int quantity;
    public billDetail(int billdid, int bid, String pname, int opr, int qt)
    {
        billDetailId= billdid;
        billId=bid;
        prodName=pname;
        offerPrice=opr;
        quantity=qt;
    }
}
