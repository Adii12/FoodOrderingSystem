using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cook_s_App.UserControls.OrderLayout {
    public partial class PendingOrderLayout : UserControl {
        public String details;
       
        public PendingOrderLayout(String orderNumber, String details) {
            InitializeComponent();
            orderNumberLabel.Text = "#"+orderNumber;
            detailsLabel.Text = details;
        }
            

        private void acceptOrderButton_Click(object sender, EventArgs e) {
            ActiveOrderLayout aol = new ActiveOrderLayout(orderNumberLabel.Text, detailsLabel.Text);
            this.Dispose();
            OrdersUserControl.Instance.activeOrders.Controls.Add(aol);
        }
    }
}
