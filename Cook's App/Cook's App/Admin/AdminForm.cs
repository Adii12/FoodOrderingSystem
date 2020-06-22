using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cook_s_App.Admin {
    public partial class AdminForm : Form {
        public AdminForm() {
            InitializeComponent();
            errorLabel.Hide();
        }

        private void backButton_Click(object sender, EventArgs e) {
            this.Dispose();
            LoginForm lf = new LoginForm();
            lf.Show();
        }

        private void quitButton_Click(object sender, EventArgs e) {
            System.Environment.Exit(1);
        }

        private void addCookButton_Click(object sender, EventArgs e) {
            addCook();
        }

        private void addCook() {
            if (firstNameBox.TextLength > 0 && lastNameBox.TextLength > 0) {
                if (passwordBox.Text == confirmPasswordBox.Text) {
                    errorLabel.ForeColor = Color.Green;
                    errorLabel.Text = "Cook added succesfully!";
                    errorLabel.Show();
                }
                else {
                    errorLabel.ForeColor = Color.Red;
                    errorLabel.Text = "Passwords do not match!";
                    errorLabel.Show();
                }
            }
            else {
                errorLabel.ForeColor = Color.Red;
                errorLabel.Text = "Fields cannot be empty!";
                errorLabel.Show();
            }
        }
    }
}
