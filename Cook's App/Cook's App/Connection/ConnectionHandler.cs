using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Net.Http.Headers;

namespace Cook_s_App.Connection {
    class ConnectionHandler {
        public static String getRequest(String URL) {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri(URL);

            client.DefaultRequestHeaders.Accept.Add (new MediaTypeWithQualityHeaderValue("application/json"));

            HttpResponseMessage response = client.GetAsync(URL).Result;

            if(response.IsSuccessStatusCode) {
                //return response.ToString();
                var data = response.Content.ReadAsStringAsync().Result;
                return data;
            } else {
                Console.WriteLine("Error parsing data from API\n");
                return null;
            }
        }
    }
}
