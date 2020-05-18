using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Cook_s_App.Dummy;

namespace Cook_s_App.UserControls {
    public partial class DashboardUserControl : UserControl {
        public DashboardUserControl() {
            InitializeComponent();
            StartTimer();
            welcomeLabel.Text = "Hi, " + DummyClass.COOK_NAME + "!";
        }
        
        private void StartTimer() {
            timer1.Interval = 500;
            timer1.Tick += new EventHandler(timer_tick);
            timer1.Enabled = true;
        }

        void timer_tick(object sender, EventArgs e) {
            timeLabel.Text = DateTime.Now.ToString("HH:mm:ss");
            dateLabel.Text = DateTime.Now.ToString("dd/MMMM/yyyy");
        }
    }
}
