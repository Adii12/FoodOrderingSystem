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
    public partial class LoginForm : Form {
        public LoginForm() {
            InitializeComponent();
            
        }

        private void iconButton1_Click(object sender, EventArgs e) {
            System.Environment.Exit(1);
        }

        private void loginButton_Click(object sender, EventArgs e) {
            this.Hide();
            CookForm cookForm = new CookForm();
            cookForm.ShowDialog();
            this.Show();
        }

        private void LoginForm_Load(object sender, EventArgs e) {
            
        }
    }
}
