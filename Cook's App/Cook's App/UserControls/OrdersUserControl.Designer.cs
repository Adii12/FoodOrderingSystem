namespace Cook_s_App.UserControls {
    partial class OrdersUserControl {
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.pendingOrdersLabel = new System.Windows.Forms.Label();
            this.activeOrdersLabel = new System.Windows.Forms.Label();
            this.activeOrdersPanel = new System.Windows.Forms.FlowLayoutPanel();
            this.pendingOrdersPanel = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // pendingOrdersLabel
            // 
            this.pendingOrdersLabel.AutoSize = true;
            this.pendingOrdersLabel.Font = new System.Drawing.Font("Century Gothic", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.pendingOrdersLabel.Location = new System.Drawing.Point(13, 57);
            this.pendingOrdersLabel.Name = "pendingOrdersLabel";
            this.pendingOrdersLabel.Size = new System.Drawing.Size(233, 36);
            this.pendingOrdersLabel.TabIndex = 0;
            this.pendingOrdersLabel.Text = "Pending orders:";
            // 
            // activeOrdersLabel
            // 
            this.activeOrdersLabel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.activeOrdersLabel.AutoSize = true;
            this.activeOrdersLabel.Font = new System.Drawing.Font("Century Gothic", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.activeOrdersLabel.Location = new System.Drawing.Point(889, 57);
            this.activeOrdersLabel.Name = "activeOrdersLabel";
            this.activeOrdersLabel.Size = new System.Drawing.Size(210, 36);
            this.activeOrdersLabel.TabIndex = 0;
            this.activeOrdersLabel.Text = "Active orders:";
            // 
            // activeOrdersPanel
            // 
            this.activeOrdersPanel.Location = new System.Drawing.Point(895, 101);
            this.activeOrdersPanel.Name = "activeOrdersPanel";
            this.activeOrdersPanel.Size = new System.Drawing.Size(820, 946);
            this.activeOrdersPanel.TabIndex = 2;
            // 
            // pendingOrdersPanel
            // 
            this.pendingOrdersPanel.AutoScroll = true;
            this.pendingOrdersPanel.Location = new System.Drawing.Point(19, 101);
            this.pendingOrdersPanel.Name = "pendingOrdersPanel";
            this.pendingOrdersPanel.Size = new System.Drawing.Size(820, 946);
            this.pendingOrdersPanel.TabIndex = 3;
            // 
            // OrdersUserControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.Controls.Add(this.pendingOrdersPanel);
            this.Controls.Add(this.activeOrdersPanel);
            this.Controls.Add(this.activeOrdersLabel);
            this.Controls.Add(this.pendingOrdersLabel);
            this.Name = "OrdersUserControl";
            this.Padding = new System.Windows.Forms.Padding(10);
            this.Size = new System.Drawing.Size(1720, 1060);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label pendingOrdersLabel;
        private System.Windows.Forms.Label activeOrdersLabel;
        private System.Windows.Forms.FlowLayoutPanel activeOrdersPanel;
        private System.Windows.Forms.FlowLayoutPanel pendingOrdersPanel;
    }
}
