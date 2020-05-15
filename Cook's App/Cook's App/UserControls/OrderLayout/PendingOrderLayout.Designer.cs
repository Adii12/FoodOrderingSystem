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
            this.SuspendLayout();
            // 
            // orderNumberLabel
            // 
            this.orderNumberLabel.AutoSize = true;
            this.orderNumberLabel.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.orderNumberLabel.Location = new System.Drawing.Point(4, 4);
            this.orderNumberLabel.Name = "orderNumberLabel";
            this.orderNumberLabel.Size = new System.Drawing.Size(127, 19);
            this.orderNumberLabel.TabIndex = 0;
            this.orderNumberLabel.Text = "#OrderNumber";
            // 
            // acceptOrderButton
            // 
            this.acceptOrderButton.FlatAppearance.BorderSize = 0;
            this.acceptOrderButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.acceptOrderButton.Location = new System.Drawing.Point(173, 74);
            this.acceptOrderButton.Name = "acceptOrderButton";
            this.acceptOrderButton.Size = new System.Drawing.Size(75, 23);
            this.acceptOrderButton.TabIndex = 1;
            this.acceptOrderButton.Text = "Accept";
            this.acceptOrderButton.UseVisualStyleBackColor = true;
            // 
            // orderDetailsButton
            // 
            this.orderDetailsButton.FlatAppearance.BorderSize = 0;
            this.orderDetailsButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.orderDetailsButton.Location = new System.Drawing.Point(92, 74);
            this.orderDetailsButton.Name = "orderDetailsButton";
            this.orderDetailsButton.Size = new System.Drawing.Size(75, 23);
            this.orderDetailsButton.TabIndex = 1;
            this.orderDetailsButton.Text = "Details";
            this.orderDetailsButton.UseVisualStyleBackColor = true;
            // 
            // PendingOrderLayout
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.Controls.Add(this.orderDetailsButton);
            this.Controls.Add(this.acceptOrderButton);
            this.Controls.Add(this.orderNumberLabel);
            this.Name = "PendingOrderLayout";
            this.Size = new System.Drawing.Size(247, 96);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label orderNumberLabel;
        private System.Windows.Forms.Button acceptOrderButton;
        private System.Windows.Forms.Button orderDetailsButton;
    }
}
