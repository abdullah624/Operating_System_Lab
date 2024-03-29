
import java.net.*; 
import java.io.*; 

public class Client 
{ 
	private Socket socket = null; 
	private DataInputStream input = null; 
	private DataOutputStream out = null; 

	public Client(String address, int port) 
	{ 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Client Connected"); 
			input = new DataInputStream(System.in); 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(Exception i) 
		{ 
			System.out.println(i); 
		} 
		String line = ""; 
		while (!line.equals("By")) 
		{ 
			try
			{ 
				line = input.readLine(); 
				out.writeUTF(line); 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 5555); 
	} 
} 

