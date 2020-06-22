using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Cook_s_App.UserControls.OrderLayout;
using Newtonsoft.Json.Linq;
using Cook_s_App.Connection;
using System.Drawing.Text;

namespace Cook_s_App.UserControls {
    public partial class OrdersUserControl : UserControl {
        PendingOrderLayout[] samplePendingOrder;
        static OrdersUserControl obj;

        public static OrdersUserControl Instance {
            get {
                if (obj == null)
                    obj = new OrdersUserControl();
                return obj;
            }
        }

        public OrdersUserControl() {
            InitializeComponent();
            obj = this;
            samplePendingOrder = new PendingOrderLayout[100];
            //createSampleOrders();
            getOrders();
        }

        private void createSampleOrders() {
            for (int i = 0; i < 7; i++) {
                samplePendingOrder[i] = new PendingOrderLayout(i+1000+"", "Pizza | Ketchup \n Cola(500ml)");
                pendingOrdersPanel.Controls.Add(samplePendingOrder[i]);
            }
        }

        private void getOrders() {
            String URL = "https://food-order-bbcce.firebaseio.com/Orders.json";
            JObject data = JObject.Parse(ConnectionHandler.getRequest(URL));
            //JArray dataarr = (JArray)data;
            //String status = data.SelectToken("status");
            JProperty parent = (JProperty)data.Parent;
            //String name = parent.Name;
            MessageBox.Show(data.Root.ToString());
            //MessageBox.Show(data.Values<string>.ToString());
           samplePendingOrder[0] = new PendingOrderLayout(data.Children().Values().ToString() , data["-M9Te98tJAds8ga9RT0h"]["status"].ToString());
            pendingOrdersPanel.Controls.Add(samplePendingOrder[0]);
        }

        public FlowLayoutPanel activeOrders {
            get { return activeOrdersPanel; }
            set { activeOrdersPanel = value; }
        }
    }
}
