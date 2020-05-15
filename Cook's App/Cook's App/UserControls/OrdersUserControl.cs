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
        public OrdersUserControl() {
            InitializeComponent();
            PendingOrderLayout samplePendingOrder = new PendingOrderLayout();
            createSampleOrders();
        }

        private void createSampleOrders() {
            for (int i = 0; i < 3; i++) {
                PendingOrderLayout samplePendingOrder = new PendingOrderLayout();
                pendingOrdersPanel.Controls.Add(samplePendingOrder);
                samplePendingOrder.Location = new Point(0, i * 150);
            }
        }
    }
}
