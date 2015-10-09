package bmcsampleapp2;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
		if(args.length<2)
		{
			System.out.println("Invalid usage. use -help");
			System.exit(1);
		}
		if(args[0].equals("-help"))
		{
			System.out.println("This java file helps in running shard instances\nUse -c for configuration and routing servers, -s for shardsvr and -r for routing server");
			System.exit(0);
		}
		new File("Data"+args[0]).mkdir();
        String[] config_addr=InetAddress.getLocalHost().toString().split("/");
        System.out.println(config_addr[0]);
        System.out.println(config_addr[1]);
        Runtime r=Runtime.getRuntime();
        String dir_name="Data"+args[0];
		Process p2=null;
		if(args[1].equals("-s"))
		{
        p2=r.exec("mongod -rest -shardsvr -port "+args[0] +" -bind_ip "+config_addr[1]+" -logpath "+dir_name+"\\logpath.txt -dbpath Data"+args[0] );
        }
		else if(args[1].equals("-c"))
		{
			p2=r.exec("mongod -rest -configsvr -port "+args[0] +" -bind_ip "+config_addr[1]+" -logpath "+dir_name+"\\logpath.txt -dbpath Data"+args[0] );
			Integer next_port=Integer.parseInt(args[0])+1;
			String y=next_port.toString();
			String cmd="mongos -port "+ y+" -configdb "+config_addr[1]+":"+args[0]+">Data"+args[0]+"\\logpath.txt";
			Process p3=r.exec(cmd);
			System.out.println(cmd);
		}
		else
		{
			System.out.println("Invalid flag. use -help");
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(p2.getInputStream()));
		BufferedReader br_stderr=new BufferedReader(new InputStreamReader(p2.getErrorStream()));
		String x;
		while((x=br_stderr.readLine())!=null)
		{
			System.out.println(x);
		}
		while((x=br.readLine())!=null)
		{
			System.out.println(x);
		}
       }
}
