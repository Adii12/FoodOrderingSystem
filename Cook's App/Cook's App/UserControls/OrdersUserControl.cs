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
            createSampleOrders();            
        }

        private void createSampleOrders() {
            for (int i = 0; i < 7; i++) {
                samplePendingOrder[i] = new PendingOrderLayout(i+1000, "Pizza | Ketchup \n Cola(500ml)");
                pendingOrdersPanel.Controls.Add(samplePendingOrder[i]);
            }
        }

        public FlowLayoutPanel activeOrders {
            get { return activeOrdersPanel; }
            set { activeOrdersPanel = value; }
        }
    }
}
