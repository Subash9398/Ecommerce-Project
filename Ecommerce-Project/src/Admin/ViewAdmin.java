package Admin;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ViewAdmin implements IViewAdmin{
	private IPresenterAdmin presenteradmin; 
	
	public void setPresenter(IPresenterAdmin prese) throws SQLException {
		// TODO Auto-generated method stub
		this.presenteradmin = prese;
		showdetails();
	}
	 @SuppressWarnings("resource")
	void showdetails() throws SQLException
	{
		Scanner scannerObject=new Scanner(System.in);
		System.out.println("Add products press 1");
		System.out.println("remove products press 2");
		System.out.println("View products press 3");
		System.out.println("exit press 4");
		int option=scannerObject.nextInt();
		switch(option)
		{
		case 1:addproducts();break;
		case 2:removeproducts();break;
		case 3:viewproducts();break;
		case 4:System.exit(0);;
		}
	}
	public void addproducts() throws SQLException
	{
		Scanner scannerObject=new Scanner(System.in);
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("Enter the Product_Name");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the Category_Name");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the Product_Description");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the Qty");
		al.add(scannerObject.nextLine());
		System.out.println("Enter the price");
		al.add(scannerObject.nextLine());
		System.out.println("Please select option \n 1.print \n 2.Store  \n 3 Re-enter");
		int data=scannerObject.nextInt();
		switch(data)
		{
		case 1:
		{
		    System.out.println(al);
		    break;
		}
		case 2:
			try {
				{
					System.out.println(presenteradmin.addproducts(al));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}break;
		    case 3:
		    {
		    	al.removeAll(al);al.clear();
		    	addproducts();break;
		    }
	}
		scannerObject.close();showdetails();	
	}
//	public void removeproducts() throws SQLException
//	{
//		Scanner scannerObject=new Scanner(System.in);
//		IViewList viewlist=new ViewList();
//		viewlist.setPresenter(new PresenterList(viewlist,new ModelList()));
//		System.out.println("Enter the S_No if you want to remove");
//		int S_No=scannerObject.nextInt();
//		System.out.println(presenteradmin.removeProducts(S_No));
//		showdetails();	
//	}
//	public void viewproducts() throws SQLException
//	{
//		IViewList viewlist=new ViewList();
//		viewlist.setPresenter(new PresenterList(viewlist,new ModelList()));
//		showdetails();
//	}
public static void main(String args[]) throws SQLException {
		
		IViewAdmin viewadmin=new ViewAdmin();
		viewadmin.setPresenter(new PresenterAdmin(viewadmin,new ModelAdmin()));
		
	}

}
