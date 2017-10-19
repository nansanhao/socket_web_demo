import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args) throws IOException{
        //创建一个ServerSocket，用于监听客户端Socket的连接请求
        ServerSocket sever=new ServerSocket(8000);
        System.out.println("服务器正在运行，监听"+sever.getLocalPort());
        //采用循环不断接受来自客户端的请求
        while(true){
            //每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
            Socket client=sever.accept();
            System.out.println("服务器被访问！");
            //获取客户端的请求信息并且提取出来
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String header = reader.readLine();
            String file_name=header.split(" ")[1].split("/")[1];

            System.out.println("返回文件："+file_name);
            String file_url="C:\\Users\\38974\\IdeaProjects\\socketWeb\\src\\static\\"+file_name;
            //引入文件
            File file = new File(file_url);
            //用包装纸PrintStream
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            FileReader in = new FileReader(file);
            BufferedReader breader = new BufferedReader(in);
            //
            String s;
            out.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
            out.println("Content-Type:" + "text/html" + ";charset=UTF-8");
            out.println();// 根据 HTTP 协议, 空行将结束头信息
            out.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
            while ((s = breader.readLine()) != null) {
                out.println(s);
            }

            //将Socket对应的输出流包装成PrintStream
            //PrintStream ps=new PrintStream(client.getOutputStream());
            //ps.println("您好，您收到了服务器的新年祝福");
            //关闭输出流，关闭Socket
            //ps.close();
            out.close();
            client.close();
        }
    }
}  