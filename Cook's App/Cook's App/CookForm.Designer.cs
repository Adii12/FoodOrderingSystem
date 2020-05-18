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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(CookForm));
            this.sideMenu = new System.Windows.Forms.Panel();
            this.currentPanel = new System.Windows.Forms.Panel();
            this.logoPanel = new System.Windows.Forms.Panel();
            this.Logo = new System.Windows.Forms.PictureBox();
            this.quitButton = new FontAwesome.Sharp.IconButton();
            this.logOutButton = new FontAwesome.Sharp.IconButton();
            this.ordersButton = new FontAwesome.Sharp.IconButton();
            this.dashboardButton = new FontAwesome.Sharp.IconButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.dashboardUserControl1 = new Cook_s_App.UserControls.DashboardUserControl();
            this.ordersUserControl1 = new Cook_s_App.UserControls.OrdersUserControl();
            this.sideMenu.SuspendLayout();
            this.logoPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Logo)).BeginInit();
            this.SuspendLayout();
            // 
            // sideMenu
            // 
            this.sideMenu.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(37)))), ((int)(((byte)(38)))));
            this.sideMenu.Controls.Add(this.currentPanel);
            this.sideMenu.Controls.Add(this.logoPanel);
            this.sideMenu.Controls.Add(this.quitButton);
            this.sideMenu.Controls.Add(this.logOutButton);
            this.sideMenu.Controls.Add(this.ordersButton);
            this.sideMenu.Controls.Add(this.dashboardButton);
            this.sideMenu.Dock = System.Windows.Forms.DockStyle.Left;
            this.sideMenu.Location = new System.Drawing.Point(0, 0);
            this.sideMenu.Margin = new System.Windows.Forms.Padding(2);
            this.sideMenu.Name = "sideMenu";
            this.sideMenu.Size = new System.Drawing.Size(200, 787);
            this.sideMenu.TabIndex = 0;
            // 
            // currentPanel
            // 
            this.currentPanel.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.currentPanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(198)))), ((int)(((byte)(13)))), ((int)(((byte)(92)))));
            this.currentPanel.Location = new System.Drawing.Point(3, 239);
            this.currentPanel.Name = "currentPanel";
            this.currentPanel.Size = new System.Drawing.Size(11, 61);
            this.currentPanel.TabIndex = 2;
            // 
            // logoPanel
            // 
            this.logoPanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(198)))), ((int)(((byte)(13)))), ((int)(((byte)(92)))));
            this.logoPanel.Controls.Add(this.Logo);
            this.logoPanel.Location = new System.Drawing.Point(36, 0);
            this.logoPanel.Name = "logoPanel";
            this.logoPanel.Size = new System.Drawing.Size(120, 155);
            this.logoPanel.TabIndex = 1;
            // 
            // Logo
            // 
            this.Logo.BackColor = System.Drawing.Color.Transparent;
            this.Logo.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.Logo.Image = ((System.Drawing.Image)(resources.GetObject("Logo.Image")));
            this.Logo.Location = new System.Drawing.Point(3, 3);
            this.Logo.Name = "Logo";
            this.Logo.Size = new System.Drawing.Size(114, 149);
            this.Logo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.Logo.TabIndex = 0;
            this.Logo.TabStop = false;
            // 
            // quitButton
            // 
            this.quitButton.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.quitButton.FlatAppearance.BorderSize = 0;
            this.quitButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.quitButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.quitButton.Font = new System.Drawing.Font("Century Gothic", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.quitButton.ForeColor = System.Drawing.Color.White;
            this.quitButton.IconChar = FontAwesome.Sharp.IconChar.PowerOff;
            this.quitButton.IconColor = System.Drawing.Color.White;
            this.quitButton.IconSize = 35;
            this.quitButton.Location = new System.Drawing.Point(169, 757);
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
            this.logOutButton.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.logOutButton.FlatAppearance.BorderSize = 0;
            this.logOutButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.logOutButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.logOutButton.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.logOutButton.ForeColor = System.Drawing.Color.White;
            this.logOutButton.IconChar = FontAwesome.Sharp.IconChar.DoorOpen;
            this.logOutButton.IconColor = System.Drawing.Color.White;
            this.logOutButton.IconSize = 40;
            this.logOutButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.logOutButton.Location = new System.Drawing.Point(19, 447);
            this.logOutButton.Margin = new System.Windows.Forms.Padding(10);
            this.logOutButton.Name = "logOutButton";
            this.logOutButton.Rotation = 0D;
            this.logOutButton.Size = new System.Drawing.Size(177, 61);
            this.logOutButton.TabIndex = 0;
            this.logOutButton.Text = "Log out";
            this.logOutButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.logOutButton.UseVisualStyleBackColor = true;
            this.logOutButton.Click += new System.EventHandler(this.logOutButton_Click);
            // 
            // ordersButton
            // 
            this.ordersButton.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.ordersButton.FlatAppearance.BorderSize = 0;
            this.ordersButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.ordersButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.ordersButton.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ordersButton.ForeColor = System.Drawing.Color.White;
            this.ordersButton.IconChar = FontAwesome.Sharp.IconChar.Tag;
            this.ordersButton.IconColor = System.Drawing.Color.White;
            this.ordersButton.IconSize = 40;
            this.ordersButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.ordersButton.Location = new System.Drawing.Point(19, 343);
            this.ordersButton.Margin = new System.Windows.Forms.Padding(10);
            this.ordersButton.Name = "ordersButton";
            this.ordersButton.Rotation = 0D;
            this.ordersButton.Size = new System.Drawing.Size(171, 61);
            this.ordersButton.TabIndex = 0;
            this.ordersButton.Text = "Orders";
            this.ordersButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.ordersButton.UseVisualStyleBackColor = true;
            this.ordersButton.Click += new System.EventHandler(this.ordersButton_Click);
            // 
            // dashboardButton
            // 
            this.dashboardButton.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.dashboardButton.FlatAppearance.BorderSize = 0;
            this.dashboardButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.dashboardButton.Flip = FontAwesome.Sharp.FlipOrientation.Normal;
            this.dashboardButton.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.dashboardButton.ForeColor = System.Drawing.Color.White;
            this.dashboardButton.IconChar = FontAwesome.Sharp.IconChar.ChartBar;
            this.dashboardButton.IconColor = System.Drawing.Color.White;
            this.dashboardButton.IconSize = 40;
            this.dashboardButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.dashboardButton.Location = new System.Drawing.Point(19, 239);
            this.dashboardButton.Margin = new System.Windows.Forms.Padding(10);
            this.dashboardButton.Name = "dashboardButton";
            this.dashboardButton.Rotation = 0D;
            this.dashboardButton.Size = new System.Drawing.Size(177, 61);
            this.dashboardButton.TabIndex = 0;
            this.dashboardButton.Text = "Dashboard";
            this.dashboardButton.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.dashboardButton.UseVisualStyleBackColor = true;
            this.dashboardButton.Click += new System.EventHandler(this.dashboardButton_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(198)))), ((int)(((byte)(13)))), ((int)(((byte)(92)))));
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(200, 0);
            this.panel1.Margin = new System.Windows.Forms.Padding(2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1048, 20);
            this.panel1.TabIndex = 1;
            // 
            // dashboardUserControl1
            // 
            this.dashboardUserControl1.AutoSize = true;
            this.dashboardUserControl1.BackColor = System.Drawing.Color.White;
            this.dashboardUserControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dashboardUserControl1.Location = new System.Drawing.Point(200, 20);
            this.dashboardUserControl1.Name = "dashboardUserControl1";
            this.dashboardUserControl1.Size = new System.Drawing.Size(1048, 767);
            this.dashboardUserControl1.TabIndex = 2;
            // 
            // ordersUserControl1
            // 
            this.ordersUserControl1.BackColor = System.Drawing.Color.White;
            this.ordersUserControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ordersUserControl1.Location = new System.Drawing.Point(0, 0);
            this.ordersUserControl1.Name = "ordersUserControl1";
            this.ordersUserControl1.Padding = new System.Windows.Forms.Padding(10);
            this.ordersUserControl1.Size = new System.Drawing.Size(1248, 787);
            this.ordersUserControl1.TabIndex = 3;
            // 
            // CookForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1248, 787);
            this.Controls.Add(this.dashboardUserControl1);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.sideMenu);
            this.Controls.Add(this.ordersUserControl1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "CookForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.sideMenu.ResumeLayout(false);
            this.logoPanel.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Logo)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

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
        private System.Windows.Forms.Panel logoPanel;
        private System.Windows.Forms.PictureBox Logo;
        private System.Windows.Forms.Panel currentPanel;
    }
}

