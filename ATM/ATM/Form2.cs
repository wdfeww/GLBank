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
    public partial class Form2 : Form
    {
        private Bitmap picture;
        private Graphics g;
        private long id;
        private String pinCode = "";
        public Form2(long id)
        {
            
            
            InitializeComponent();
            this.id = id;
            enableKeyboard(false);
            btn_left1.Enabled = false;
            btn_left2.Enabled = false;
            btn_left3.Enabled = false;
            btn_left4.Enabled = false;
            btn_right1.Enabled = false;
            btn_right2.Enabled = false;
            btn_right3.Enabled = false;
            btn_right4.Enabled = false;
            picture = new Bitmap(452, 252);
            g = Graphics.FromImage(picture);
            g.Clear(Color.White);
            
            if(new Database().isCardBlocked(id))
            {
                cardBlocked();
            }
            else
            {
                enterPin();
            }

          
        }
        private void selectLanguage()
        {
            setLeft4("Slovencina");
            setRight4("English");
        }
        private void enableKeyboard(bool enabled)
        {
            btn1.Enabled = enabled;
            btn2.Enabled = enabled;
            btn3.Enabled = enabled;
            btn4.Enabled = enabled;
            btn5.Enabled = enabled;
            btn6.Enabled = enabled;
            btn7.Enabled = enabled;
            btn8.Enabled = enabled;
            btn9.Enabled = enabled;
            btn0.Enabled = enabled;
            btnC.Enabled = enabled;
            btnOK.Enabled = enabled;
        }

        private void updateShowPin()
        {
            Console.WriteLine(pinCode);
            g.Clear(Color.White);
            g.DrawString("Enter pin", new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            String pin = "";
            for (int i = 0; i < pinCode.Length; i++)
                pin += "*";
            g.DrawString(pin, new Font("Tahoma", 18), Brushes.Black, new Point(150, 200));
            pictureBox1.Image = picture;
        }
        private void enterPin()
        {
            Console.WriteLine(pinCode);
            enableKeyboard(true);
            g.DrawString("Enter pin", new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            pictureBox1.Image = picture;

        }
        private void cardBlocked()
        {
            g.DrawString("Card is blocked", new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            pictureBox1.Image = picture;
        }
        private void setLeft4(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(10, 220));
            pictureBox1.Image = picture;
        }
        private void setLeft3(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(10, 150));
            pictureBox1.Image = picture;
        }
        private void setLeft2(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(10, 80));
            pictureBox1.Image = picture;
        }
        private void setLeft1(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(10, 10));
            pictureBox1.Image = picture;
        }

        private void setRight4(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(300, 220));
            pictureBox1.Image = picture;
        }
        private void setRight3(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(300, 150));
            pictureBox1.Image = picture;
        }
        private void setRight2(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(300, 80));
            pictureBox1.Image = picture;
        }
        private void setRight1(string v)
        {
            g.DrawString(v, new Font("Tahoma", 18), Brushes.Black, new Point(300, 10));
            pictureBox1.Image = picture;
        }
        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void button9_Click(object sender, EventArgs e)
        {
            if(pinCode.Length!=0)
            pinCode = pinCode.Remove(pinCode.Length - 1);
            updateShowPin();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "3";
                updateShowPin();
            }

        }

        private void btn1_Click(object sender, EventArgs e)
        {
            if(pinCode.Length<4)
            {
                pinCode +=  "1";
                updateShowPin();
            }
            
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "2";
                updateShowPin();
            }
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "4";
                updateShowPin();
            }
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "5";
                updateShowPin();
            }
        }

        private void btn6_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "6";
                updateShowPin();
            }
        }

        private void btn7_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "7";
                updateShowPin();
            }
        }

        private void btn8_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "8";
                updateShowPin();
            }
        }

        private void btn9_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "9";
                updateShowPin();
            }
        }

        private void btn0_Click(object sender, EventArgs e)
        {
            if (pinCode.Length < 4)
            {
                pinCode += "0";
                updateShowPin();

            }
        }

        private void btnOK_Click(object sender, EventArgs e)
        {

        }
    }
}
