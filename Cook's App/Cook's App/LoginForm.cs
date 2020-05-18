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

namespace Cook_s_App {
    public partial class LoginForm : Form {
        public LoginForm() {
            InitializeComponent();
            
        }

        private void iconButton1_Click(object sender, EventArgs e) {
            System.Environment.Exit(1);
        }

        private void loginButton_Click(object sender, EventArgs e) {
            if (usernameBox.Text == DummyClass.USERNAME && passwordBox.Text == DummyClass.PASSWORD) {
                this.Hide();
                CookForm cookForm = new CookForm();
                cookForm.ShowDialog();
                this.Show();
                errorLabel.Visible = false;
            }
            else {
                errorLabel.Visible = true;
                errorLabel.Text = "Account does not exists or credentials are wrong!";
                
            }
        }

        private void LoginForm_Load(object sender, EventArgs e) {
            
        }

        private void label4_Click(object sender, EventArgs e) {

        }
    }
}
