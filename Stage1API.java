class Order {
int orderReferenceNumber =0;
int numberOfBricks;
Order( int numberOfBricks)
{
this.orderReferenceNumber += 1;
this.numberOfBricks = numberOfBricks;
}

}
public class Stage1API
{
// storing orders
public Map<int,Order> orderMap = new HashMap<int,Order>();
public int buy(int norOfBricks)
{
System.out.println("number of bricks buying:"+norOfBricks);
Order order = new Order(norOfBricks);
orderMap.put(this.numberOfBricks,order);
return order.orderReferenceNumber;
}

public Order retriveOrderDetails(int orderReferenceNumber)
{
Order order = orderMap.get(orderReferenceNumber);
if(order != null)
{
return order;
}
else
{
return null;
}
}

public List<Order> retriveAllOrderDetail()
{
List<Order> allOrders = new ArrayList<Order>();
Set allOrderRef = orderMap.keySet();
for(int i=0; i<allOrderRef.size();i++)
{
Order order = allOrderRef.get(i);
allOrders.add(order);
}
return allOrders;
}
