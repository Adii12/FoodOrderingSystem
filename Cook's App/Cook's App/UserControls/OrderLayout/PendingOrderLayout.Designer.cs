namespace Cook_s_App.UserControls.OrderLayout {
    partial class PendingOrderLayout {
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
            this.orderNumberLabel = new System.Windows.Forms.Label();
            this.acceptOrderButton = new System.Windows.Forms.Button();
            this.orderDetailsButton = new System.Windows.Forms.Button();
            this.detailsLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // orderNumberLabel
            // 
            this.orderNumberLabel.AutoSize = true;
            this.orderNumberLabel.Font = new System.Drawing.Font("Century Gothic", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.orderNumberLabel.Location = new System.Drawing.Point(14, 14);
            this.orderNumberLabel.Name = "orderNumberLabel";
            this.orderNumberLabel.Size = new System.Drawing.Size(212, 32);
            this.orderNumberLabel.TabIndex = 0;
            this.orderNumberLabel.Text = "#OrderNumber";
            // 
            // acceptOrderButton
            // 
            this.acceptOrderButton.FlatAppearance.BorderSize = 0;
            this.acceptOrderButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.acceptOrderButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.acceptOrderButton.Location = new System.Drawing.Point(712, 157);
            this.acceptOrderButton.Name = "acceptOrderButton";
            this.acceptOrderButton.Size = new System.Drawing.Size(75, 30);
            this.acceptOrderButton.TabIndex = 1;
            this.acceptOrderButton.Text = "Accept";
            this.acceptOrderButton.UseVisualStyleBackColor = true;
            this.acceptOrderButton.Click += new System.EventHandler(this.acceptOrderButton_Click);
            // 
            // orderDetailsButton
            // 
            this.orderDetailsButton.FlatAppearance.BorderSize = 0;
            this.orderDetailsButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.orderDetailsButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.orderDetailsButton.Location = new System.Drawing.Point(631, 157);
            this.orderDetailsButton.Name = "orderDetailsButton";
            this.orderDetailsButton.Size = new System.Drawing.Size(75, 30);
            this.orderDetailsButton.TabIndex = 1;
            this.orderDetailsButton.Text = "Details";
            this.orderDetailsButton.UseVisualStyleBackColor = true;
            // 
            // detailsLabel
            // 
            this.detailsLabel.AutoSize = true;
            this.detailsLabel.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.detailsLabel.Location = new System.Drawing.Point(17, 70);
            this.detailsLabel.Name = "detailsLabel";
            this.detailsLabel.Size = new System.Drawing.Size(318, 24);
            this.detailsLabel.TabIndex = 2;
            this.detailsLabel.Text = "Pizza | Ketchup | Sprite 500ml";
            // 
            // PendingOrderLayout
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.Controls.Add(this.detailsLabel);
            this.Controls.Add(this.orderDetailsButton);
            this.Controls.Add(this.acceptOrderButton);
            this.Controls.Add(this.orderNumberLabel);
            this.Name = "PendingOrderLayout";
            this.Padding = new System.Windows.Forms.Padding(10);
            this.Size = new System.Drawing.Size(800, 200);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label orderNumberLabel;
        private System.Windows.Forms.Button orderDetailsButton;
        public System.Windows.Forms.Button acceptOrderButton;
        private System.Windows.Forms.Label detailsLabel;
    }
}
