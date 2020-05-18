using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Cook_s_App.Dummy;

namespace Cook_s_App.Admin {
    public partial class AdminLoginForm : Form {
        public AdminLoginForm() {
            InitializeComponent();
        }

        private void loginButton_Click(object sender, EventArgs e) {
            if(usernameBox.Text==DummyClass.ADMIN_USER && passwordBox.Text == DummyClass.ADMIN_PASS) {
                AdminForm af = new AdminForm();
                af.Show();
                this.Hide();
            }
            else {
                errorLabel.Text = "Wrong Credentials!";
                errorLabel.Show();
            }
        }
    }
}
