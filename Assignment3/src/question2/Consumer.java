package question2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Consumer extends Thread{

	Thread1 thread;
	FileInputStream fis;
	ObjectInput ois;
	HashMap<Project, ArrayList<Employee>> map;

	Consumer(Thread1 thread) throws IOException
	{
		this.thread=thread;
		fis = new FileInputStream("File.txt");
		ois = new ObjectInputStream(fis);
	}

	public void run()
	{
		synchronized (thread)
		{
			try {
				thread.wait();
				System.out.println("Deserialize call by consumer...\nDeserialized Data : ");
				map=(HashMap<Project, ArrayList<Employee>>) ois.readObject();
				ois.close();
			} catch (InterruptedException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for(Entry<Project, ArrayList<Employee>> temp : map.entrySet())
			{
				System.out.println("The project");
				System.out.println(temp.getKey()+" Has the following employees");
				System.out.println("Employees..");
				for(Employee t : temp.getValue())
				{
					System.out.println(t);
				}
			}
		}
	}
}
