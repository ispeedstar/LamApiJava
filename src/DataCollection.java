import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;


public class DataCollection {

	public void doArray()
	{
		System.out.println("DoArray");
		int[] myArray = new int[3];
		myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;
        for(int i=0;i<myArray.length;i++)
        {
             System.out.println(String.valueOf(myArray[i]));
        }
	}
	
	public void doArrayList()
	{
		System.out.println("DoArrayList");
		ArrayList<String> myArrayList = new ArrayList<String>();
		myArrayList.add("A");
		myArrayList.add("BB");
		myArrayList.add("C");
		for (int i=0; i<myArrayList.size();i++)
		{
			System.out.println(myArrayList.get(i));
		}
	}
	
	enum MyColor
    {
        red,    // 0
        blue,   // 1
        green,  // 2
    };
    
	public void doEnum()
	{
		MyColor r = MyColor.red;
		if (r == MyColor.red)
		{
			System.out.println("color is red");
		}
		else
		{
			System.out.println("color is not red");
		}
	}
	
	public void doList()
	{
	
		System.out.println("DoList");
		List<String> myList = new ArrayList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("CC");
		for (String element : myList)
		{
			System.out.println(element);
		}
	}
	
	public void doLinkedList()
	{
		System.out.println("DoLinkedList");
		LinkedList<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("A");
		myLinkedList.addLast("B");
		myLinkedList.addLast("C");
		Iterator iterator =  myLinkedList.iterator();
		/*while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}*/
		
		for(String element : myLinkedList)
		{
			System.out.println(element);
		}
	}
	
	public void doStack()
	{
		System.out.println("DoStack");
		Stack myStack = new Stack();
		myStack.push(11);
		myStack.push(22);
		myStack.push(33);
		for(int i=0;i<myStack.size();i++)
		{
			System.out.println(myStack.pop().toString());
		}
	}
	
	public void doQueue()
	{
		System.out.println("DoQueue");
		Queue<String> myQueue = new LinkedList<String>();
		myQueue.add("A");
		myQueue.add("B");
		myQueue.add("C");
		
		// write queue
		/*while(myQueue.size() > 0)
		{
			System.out.println(myQueue.peek());
			myQueue.poll();
		}*/
		
		for(String element : myQueue)
		{
			System.out.println(element);
		}
	}
	
	public void doSet()
	{
		Set<String> mySet = new TreeSet<String>();
		mySet.add("a");
		mySet.add("b");
		mySet.add("c");
		mySet.add("b"); // not include
			
		Iterator iterator = mySet.iterator();
		while(iterator.hasNext())
		{
			String value = iterator.next().toString();
			System.out.println(value);
		}
		
		
	}
	public void doHashMap()
	{
		System.out.println("DoHashMap");
		Map myMap = new HashMap();
		
		myMap.put("a", "A");
		myMap.put("b", "B");
		myMap.put("c", "C");
		
		Iterator iterator = myMap.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry mapElement = (Map.Entry)iterator.next();
			System.out.print(mapElement.getKey() + ", ");
			System.out.println(mapElement.getValue());
		}
	}
	
	public void doProperties()
	{
		Properties myProp = new Properties();
		
		// set properties key and value
		myProp.setProperty("a", "A");
		myProp.setProperty("b", "B");
		myProp.setProperty("c", "C");
		
		Set<Object> keys = myProp.keySet();
		
		// output properties key and values
		for(Object key : keys)
		{
			String keyStr = key.toString();
			System.out.print(keyStr + ", ");
			System.out.println(myProp.getProperty(keyStr));
			
		}
		
	}
	public void doAll()
	{
		doArray();
		doArrayList();
		doEnum();
		doList();
		doLinkedList();
		doStack();
		doQueue();
		doSet();
		doHashMap();
		doProperties();
	}
} // end class
