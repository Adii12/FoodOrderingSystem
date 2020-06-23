using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Sockets;
using System.Net;
using System.Windows.Forms;

namespace Cook_s_App.Connection {
    class ConnectionHandler {
        public static String getRequest(String URL) {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri(URL);

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

            HttpResponseMessage response = client.GetAsync(URL).Result;

            if (response.IsSuccessStatusCode) {
                //return response.ToString();
                var data = response.Content.ReadAsStringAsync().Result;
                return data;
            } else {
                Console.WriteLine("Error parsing data from API\n");
                return null;
            }
        }

        public static String SocketClient() {
            try {
                IPHostEntry iphostInfo = Dns.GetHostEntry(Dns.GetHostName());
                IPAddress ipAddress = Dns.GetHostEntry(Dns.GetHostName()).AddressList.FirstOrDefault(ip => ip.AddressFamily == AddressFamily.InterNetwork);
                IPEndPoint localEndPoint = new IPEndPoint(ipAddress, 8000);

                Socket sender = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

                try {
                    sender.Connect(ipAddress, 8000);

                    byte[] lengthSent = Encoding.ASCII.GetBytes("14        ");
                    byte[] messageSent = Encoding.ASCII.GetBytes("!getOrderItems");
                    int byteLengthSent = sender.Send(lengthSent);
                    int byteSent = sender.Send(messageSent);

                    byte[] messageReceived = new byte[1024];

                    int byteRecv = sender.Receive(messageReceived);
                    String orders = Encoding.ASCII.GetString(messageReceived, 0, byteRecv);


                    lengthSent = Encoding.ASCII.GetBytes("11        ");
                    messageSent = Encoding.ASCII.GetBytes("!DISCONNECT");
                    byteLengthSent = sender.Send(lengthSent);
                    byteSent = sender.Send(messageSent);

                    sender.Shutdown(SocketShutdown.Both);
                    sender.Close();

                    return orders;

                }catch (ArgumentNullException ane) {
                    MessageBox.Show(ane.ToString());
                }
                catch (SocketException se) {

                    MessageBox.Show(se.ToString());
                }

                catch (Exception e) {
                    MessageBox.Show(e.ToString());
                }
            }

            catch (Exception e) {

                MessageBox.Show(e.ToString());
            }

            return "Error getting orders from server";
        }
    }
}
