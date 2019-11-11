class Order {
int orderReferenceNumber =0;
int numberOfBricks;
boolean dispatch = false;  
Order( int numberOfBricks)
{
this.orderReferenceNumber += 1;
this.numberOfBricks = numberOfBricks;
}

}
public class AssignmentAPI
{
// storing orders
public Map<int,Order> orderMap = new HashMap<int,Order>();
@POST
@Consumes("application/json")
@Produces("application/json")
  @Path("json")
  public RestResponse<Integer> buy(@QueryParam("norOfBricks") int norOfBricks)
{
System.out.println("number of bricks buying:"+norOfBricks);
Order order = new Order(norOfBricks);
orderMap.put(this.numberOfBricks,order);
return order.orderReferenceNumber;
}

  @GET
@Produces("application/json")
@Path("json")
public Order retriveOrderDetails(@QueryParam("orderReferenceNumber") int orderReferenceNumber)
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
@GET
@Produces("application/json")
@Path("json")
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
@PUT
@Consumes("application/json")
@Produces("application/json")
  @Path("json")
  public int updateOrder(@QueryParam("orderReferenceNumber") int orderReferenceNumber, @QueryParam("numberOfBricks") int numberOfBricks)
  {
    Order order = orderMap.get(orderReferenceNumber);
    order.numberOfBricks = numberOfBricks;
    orderMap.put(orderReferenceNumber,order);
    return orderReferenceNumber;
  }
  // for valid reference number & invalid reference number
  public String dispatchedOrder( Order order)
  {
    for ( int key : orderMap.keySet() ) {
    if(key == order.orderReferenceNumber)
    {
      order.dispatch = true;
      orderMap.put(orderReferenceNumber,order);
return "The Order is marked as dispacthed";
    }
    }  
    if(!orderMap.containsKey(order.orderReferenceNumber)))
      return new Error("a 400 bad request"); 
}
 
    
 @PUT
@Consumes("application/json")
@Produces("application/json")
@Path("json")
     public String preventUpdateOrder(@QueryParam("orderReferenceNumber") int orderReferenceNumber, @QueryParam("numberOfBricks") int numberOfBricks)
  {
    Order order = orderMap.get(orderReferenceNumber);
   if(order.dispatch){
   return new Error("a 400 bad request");
   }
  } 
    
  }
