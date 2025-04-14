
public class cart {
    String prodName;
    String catName;
    int quantity;
    int offerPrice;
    int totalPrice;
    int removedStock;
    
    public cart( String pname, String cname, int qt, int opr, int tpr, int rstck)
    {
        prodName=pname;
        catName=cname;
        quantity=qt;
        offerPrice=opr;
        totalPrice=tpr;
        removedStock= rstck;
    }
}
