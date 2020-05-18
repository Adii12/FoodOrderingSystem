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
    public partial class ActiveOrderLayout : UserControl {
        public static int instanceCounter = -1;
        public ActiveOrderLayout(String orderNumber, String details) {
            InitializeComponent();
            orderNumberLabel.Text = orderNumber;
            detailsLabel.Text = details;
            instanceCounter++;
        }

        private void readyButton_Click(object sender, EventArgs e) {
            instanceCounter--;
            this.Dispose();
        }
    }
}
