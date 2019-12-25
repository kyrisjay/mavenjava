package jdbc;

public class Orders {
    private int order_num;
    private String data;
    private int cust_id;

    public Orders() {
    }

    public Orders(int order_num, String data, int cust_id) {
        this.order_num = order_num;
        this.data = data;
        this.cust_id = cust_id;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_num=" + order_num +
                ", data='" + data + '\'' +
                ", cust_id=" + cust_id +
                '}';
    }
}


