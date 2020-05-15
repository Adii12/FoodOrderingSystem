namespace Cook_s_App {
    partial class CookForm {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.sideMenu = new System.Windows.Forms.Panel();
            this.quitButton = new FontAwesome.Sharp.IconButton();
            this.logOutButton = new FontAwesome.Sharp.IconButton();
            this.ordersButton = new FontAwesome.Sharp.IconButton();
            this.dashboardButton = new FontAwesome.Sharp.IconButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.dashboardUserControl1 = new Cook_s_App.UserControls.DashboardUserControl();
            this.ordersUserControl1 = new Cook_s_App.UserControls.OrdersUserControl();
            this.sideMenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // sideMenu
            // 
            this.sideMenu.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(37)))), ((int)(((byte)(38)))));
            this.sideMenu.Controls.Add(this.quitButton);
            this.sideMenu.Controls.Add(this.logOutButton);
            this.sideMenu.Controls.Add(this.ordersButton);
            this.sideMenu.Controls.Add(this.dashboardButton);
            this.sideMenu.Dock = System.Windows.Forms.DockStyle.Left;
            this.sideMenu.Location = new System.Drawing.Point(0, 0);
            this.sideMenu.Margin = new System.Windows.Forms.Padding(2);
            this.sideMenu.Name = "sideMenu";
            this.sideMenu.Size = new System.Drawing.Size(156, 430);
            this.sideMenu.TabIndex = 0;
            // 
            // quitButton
            // 
            this.quitButton.FlatAppearance.BorderSize = 0;
            this.quitButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.quitButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.quitButton.Font = new System.Drawing.Font("Century Gothic", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.quitButton.ForeColor = System.Drawing.Color.White;
            this.quitButton.IconChar = FontAwesome.Sharp.IconChar.PowerOff;
            this.quitButton.IconColor = System.Drawing.Color.White;
            this.quitButton.IconSize = 40;
            this.quitButton.Location = new System.Drawing.Point(108, 399);
            this.quitButton.Margin = new System.Windows.Forms.Padding(2);
            this.quitButton.Name = "quitButton";
            this.quitButton.Rotation = 0D;
            this.quitButton.Size = new System.Drawing.Size(26, 28);
            this.quitButton.TabIndex = 0;
            this.quitButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.quitButton.UseVisualStyleBackColor = true;
            this.quitButton.Click += new System.EventHandler(this.quitButton_Click);
            // 
            // logOutButton
            // 
            this.logOutButton.FlatAppearance.BorderSize = 0;
            this.logOutButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.logOutButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.logOutButton.Font = new System.Drawing.Font("Century Gothic", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.logOutButton.ForeColor = System.Drawing.Color.White;
            this.logOutButton.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
            this.logOutButton.IconColor = System.Drawing.Color.White;
            this.logOutButton.IconSize = 40;
            this.logOutButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.logOutButton.Location = new System.Drawing.Point(6, 261);
            this.logOutButton.Margin = new System.Windows.Forms.Padding(2);
            this.logOutButton.Name = "logOutButton";
            this.logOutButton.Rotation = 0D;
            this.logOutButton.Size = new System.Drawing.Size(145, 35);
            this.logOutButton.TabIndex = 0;
            this.logOutButton.Text = "Log out";
            this.logOutButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.logOutButton.UseVisualStyleBackColor = true;
            this.logOutButton.Click += new System.EventHandler(this.logOutButton_Click);
            // 
            // ordersButton
            // 
            this.ordersButton.FlatAppearance.BorderSize = 0;
            this.ordersButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.ordersButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.ordersButton.Font = new System.Drawing.Font("Century Gothic", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ordersButton.ForeColor = System.Drawing.Color.White;
            this.ordersButton.IconChar = FontAwesome.Sharp.IconChar.Tag;
            this.ordersButton.IconColor = System.Drawing.Color.White;
            this.ordersButton.IconSize = 40;
            this.ordersButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.ordersButton.Location = new System.Drawing.Point(9, 192);
            this.ordersButton.Margin = new System.Windows.Forms.Padding(2);
            this.ordersButton.Name = "ordersButton";
            this.ordersButton.Rotation = 0D;
            this.ordersButton.Size = new System.Drawing.Size(145, 35);
            this.ordersButton.TabIndex = 0;
            this.ordersButton.Text = "Orders";
            this.ordersButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.ordersButton.UseVisualStyleBackColor = true;
            this.ordersButton.Click += new System.EventHandler(this.ordersButton_Click);
            // 
            // dashboardButton
            // 
            this.dashboardButton.FlatAppearance.BorderSize = 0;
            this.dashboardButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.dashboardButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.dashboardButton.Font = new System.Drawing.Font("Century Gothic", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.dashboardButton.ForeColor = System.Drawing.Color.White;
            this.dashboardButton.IconChar = FontAwesome.Sharp.IconChar.ChartBar;
            this.dashboardButton.IconColor = System.Drawing.Color.White;
            this.dashboardButton.IconSize = 40;
            this.dashboardButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.dashboardButton.Location = new System.Drawing.Point(9, 123);
            this.dashboardButton.Margin = new System.Windows.Forms.Padding(2);
            this.dashboardButton.Name = "dashboardButton";
            this.dashboardButton.Rotation = 0D;
            this.dashboardButton.Size = new System.Drawing.Size(145, 35);
            this.dashboardButton.TabIndex = 0;
            this.dashboardButton.Text = "Dashboard";
            this.dashboardButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.dashboardButton.UseVisualStyleBackColor = true;
            this.dashboardButton.Click += new System.EventHandler(this.dashboardButton_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(215)))), ((int)(((byte)(38)))), ((int)(((byte)(66)))));
            this.panel1.Location = new System.Drawing.Point(156, 0);
            this.panel1.Margin = new System.Windows.Forms.Padding(2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(593, 10);
            this.panel1.TabIndex = 1;
            // 
            // dashboardUserControl1
            // 
            this.dashboardUserControl1.Location = new System.Drawing.Point(156, 10);
            this.dashboardUserControl1.Name = "dashboardUserControl1";
            this.dashboardUserControl1.Size = new System.Drawing.Size(590, 420);
            this.dashboardUserControl1.TabIndex = 2;
            // 
            // ordersUserControl1
            // 
            this.ordersUserControl1.Location = new System.Drawing.Point(156, 10);
            this.ordersUserControl1.Name = "ordersUserControl1";
            this.ordersUserControl1.Size = new System.Drawing.Size(590, 420);
            this.ordersUserControl1.TabIndex = 3;
            // 
            // CookForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(746, 430);
            this.Controls.Add(this.dashboardUserControl1);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.sideMenu);
            this.Controls.Add(this.ordersUserControl1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "CookForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.sideMenu.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel sideMenu;
        private System.Windows.Forms.Panel panel1;
        private FontAwesome.Sharp.IconButton dashboardButton;
        private FontAwesome.Sharp.IconButton quitButton;
        private FontAwesome.Sharp.IconButton logOutButton;
        private FontAwesome.Sharp.IconButton ordersButton;
        private UserControls.DashboardUserControl dashboardUserControl1;
        private UserControls.OrdersUserControl ordersUserControl1;
    }
}

