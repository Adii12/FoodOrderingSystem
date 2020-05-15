using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cook_s_App {
    public partial class CookForm : Form {
        public CookForm() {
            InitializeComponent();
            dashboardUserControl1.BringToFront();
        }

        private void ordersButton_Click(object sender, EventArgs e) {
            ordersUserControl1.BringToFront();
        }

        private void dashboardButton_Click(object sender, EventArgs e) {
            dashboardUserControl1.BringToFront();
        }

        private void quitButton_Click(object sender, EventArgs e) {
            System.Environment.Exit(1);
        }

        private void logOutButton_Click(object sender, EventArgs e) {
            this.Dispose();
        }
    }
}
