using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ATM
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            String idcard = textBox1.Text;
            long id;
            if (long.TryParse(idcard, out id))
            {
                if (new Database().existCard(id)) { 
                Form2 form2 = new Form2(id);
                this.Hide();
                form2.Show();
            }
            }
        }
    }
}
