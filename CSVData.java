import java.util.Vector;

//data container for CSV data 
public class CSVDataHeader
{
	//the header variable contains the blue print for the data types 
	//that this object is to hold. For example if (String)Name,(int)Age,(double)Number
	//are the raw data of a CSV file then the blue print should go as follows
	//header[0] = "String"; header[1] = "Integer"; header[2] = "Double";
	String[] header;
	//this vector is to contain other vectors to form a 2-d Array pattern. 
	Vector data;
	//this is the descriptor that differenciates this header of data from other header patterns. 
	//from the example above this String should be "Name,Age,Number"
	String name;

	public CSVDataHeader(String[] header,String name)
	{
		this.header = header;
		data = new Vector();
		for(int i=0;i<header.length;i++)
		{
			data.add(i,new Vector());
		}
		
	}

	//add data to the specified index
	public void add(Object data,int index)
	{
		this.data.elementAt(index).add(data);
	}

	//if no index was given then guess where the data is supposed to go 
	//by getting the data class type and matching it with a header blue print
	public void add(Object data)
	{
		int index = 0;
		String type = data.getClass().getName();
		for(int i=0;i<header.length;i++)
		{
			if(type = header[i]){ add(data,i); break;}
		}	  
	}
	public void add(int value)
	{
		add(new Integer(value));
	}	  

	public void add(double value)
	{
		add(new Double(value));
	}

	public void add(String value)
	{
		add(value);
	}

	public String getName(){return name;}
	public String toString(){return getName();}	
}
