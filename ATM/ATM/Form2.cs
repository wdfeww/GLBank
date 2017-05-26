using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ATM
{
    public enum State
    {
        LOGIN, CHOOSELANGUAGE,MAINSCREEN,CHANGEPASSWORD, CONFIRMCHANGEPASSWORD, BALANCE, WITHDRAWMONEY, CONFIRMWITHDRAW, OTHERVALUE, ERROR
    }
    public enum Lang
    {
        SLOVAK, ENGLISH
    }
    
    public partial class Form2 : Form
    {
        private int[] array = new int[] { 0, 0, 0, 0, 0, 0 };
        private int wAmount;
        private string[] messages;
        private Bitmap picture;
        private Graphics g;
        private long id;
        private String pinCode = "", newPinCode="", newPinCodeConfirm = "", value="";
        private int numberOfAttempts = 3;
        private State state;
        private Lang language;
        public Form2(long id)   
        {

            InitializeComponent();
            this.id = id;
            enableKeyboard(false);
            toggleButtons(false, false, false, true, false, false, false, true);
            picture = new Bitmap(452, 252);
            g = Graphics.FromImage(picture);
            g.Clear(Color.White);
            selectLanguage();
            
            state = State.CHOOSELANGUAGE;
          
        }
        private void toggleButtons(bool btnL1, bool btnL2, bool btnL3, bool btnL4, bool btnR1, bool btnR2, bool btnR3, bool btnR4  )
        {
            btn_left1.Enabled = btnL1;
            btn_left2.Enabled = btnL2;
            btn_left3.Enabled = btnL3;
            btn_left4.Enabled = btnL4;
            btn_right1.Enabled = btnR1;
            btn_right2.Enabled = btnR2;
            btn_right3.Enabled = btnR3;
            btn_right4.Enabled = btnR4;
        }
        private void selectLanguage()
        {
            g.Clear(Color.White);
            g.DrawString("Select language", new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
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

            g.Clear(Color.White);
            g.DrawString(messages[0], new Font("Tahoma", 18), Brushes.Black, new Point(150, 80));
            g.DrawString(messages[1]+": " + numberOfAttempts, new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            String pin = "";
            for (int i = 0; i < pinCode.Length; i++)
                pin += "*";
            g.DrawString(pin, new Font("Tahoma", 18), Brushes.Black, new Point(150, 200));
            pictureBox1.Image = picture;
        }
        private void enterPin()
        {
            g.Clear(Color.White);
            if (numberOfAttempts >= 1)
            {
                pinCode = "";
                enableKeyboard(true);
                g.DrawString(messages[0], new Font("Tahoma", 18), Brushes.Black, new Point(150, 80));
                g.DrawString(messages[1]+": " + numberOfAttempts, new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            }
            else
            {
                enableKeyboard(false);
                cardBlocked();
            }
            
            
            pictureBox1.Image = picture;

        }
        private void cardBlocked()
        {
            g.DrawString(messages[2], new Font("Tahoma", 18), Brushes.Red, new Point(150, 150));
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
            if (state == State.LOGIN)
            {
                if (pinCode.Length != 0)
                    pinCode = pinCode.Remove(pinCode.Length - 1);
                updateShowPin();
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length != 0)
                {
                    newPinCode = newPinCode.Remove(newPinCode.Length - 1);
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length != 0)
                {
                    newPinCodeConfirm = newPinCodeConfirm.Remove(newPinCodeConfirm.Length - 1);
                    PinCodeConfirm();
                }
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "3";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "3";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "3";
                    PinCodeConfirm();
                }
            }
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "1";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "1";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "1";
                    PinCodeConfirm();
                }
            }
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "2";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "2";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "2";
                    PinCodeConfirm();
                }
            }
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "4";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "4";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "4";
                    PinCodeConfirm();
                }
            }
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "5";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "5";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "5";
                    PinCodeConfirm();
                }
            }
        }

        private void btn6_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "6";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "6";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "6";
                    PinCodeConfirm();
                }
            }
        }

        private void btn7_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "7";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "7";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "7";
                    PinCodeConfirm();
                }
            }
        }

        private void btn8_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "8";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "8";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "8";
                    PinCodeConfirm();
                }
            }
        }

        private void btn9_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "9";
                    updateShowPin();
                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "9";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "9";
                    PinCodeConfirm();
                }
            }
           
        }

        private void btn0_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length < 4)
                {
                    pinCode += "0";
                    updateShowPin();

                }
            }
            else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length < 4)
                {
                    newPinCode += "0";
                    newPin();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length < 4)
                {
                    newPinCodeConfirm += "0";
                    PinCodeConfirm();
                }
            }
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            if (state == State.LOGIN)
            {
                if (pinCode.Length == 4)
            {
                if (new Database().isPinCorrect(id, Int32.Parse(pinCode)))
                {
                    enableKeyboard(false);
                    state = State.MAINSCREEN;
                        initMainScreen();
                }
                else
                {
                    numberOfAttempts -= 1;
                    enterPin();
                }
            }
        }
           else if (state == State.CHANGEPASSWORD)
            {
                if (newPinCode.Length == 4)
                {
                    state = State.CONFIRMCHANGEPASSWORD;
                    PinCodeConfirm();
                }
            }
            else if (state == State.CONFIRMCHANGEPASSWORD)
            {
                if (newPinCodeConfirm.Length == 4)
                {
                  if(newPinCode == newPinCodeConfirm)
                    {
                        g.Clear(Color.White);
                        new Database().changePassword(id, Int32.Parse(newPinCodeConfirm));
                        g.DrawString(messages[10], new Font("Tahoma", 18), Brushes.Green, new Point(150, 200));
                        setLeft1(messages[7]);
                        pictureBox1.Image = picture;
                    }
                    else
                    {
                        g.Clear(Color.White);
                        g.DrawString(messages[11], new Font("Tahoma", 18), Brushes.Red, new Point(150, 200));
                        setLeft1(messages[7]);
                        pictureBox1.Image = picture;
                    }
                }
            }
            else if(state == State.WITHDRAWMONEY)
            {
                calculateAmount();
                createTransaction();
            }
            else if (state == State.OTHERVALUE)
            {
                if (Int32.Parse(value) % 10 == 0)
                {
                    wAmount = Int32.Parse(value);
                    createTransaction();
                }
                else
                {
                    error(messages[18]);
                }
                
            }
        }
        private void error(string errorString)
        {
            state = State.ERROR;
            g.Clear(Color.White);
            g.DrawString(errorString, new Font("Tahoma", 18), Brushes.Red, new Point(150, 200));
            setLeft1(messages[7]);
            pictureBox1.Image = picture;
        }
        private void createTransaction()
        {
           if( new Database().getBalance(id) > wAmount)
            {
                confirmWithdraw();
            }
            else
            {
                error(messages[19]);
            }
        }
        private void otherValue()
        {
            state = State.OTHERVALUE;
            g.Clear(Color.White);
            toggleButtons(true, false, false, false, false, false, false, false);
            setLeft1(messages[7]);
            g.DrawString(messages[17], new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            g.DrawString(value + " €", new Font("Tahoma", 18), Brushes.Black, new Point(150, 200));
            pictureBox1.Image = picture;

        }
        private void confirmWithdraw()
        {
            state = State.CONFIRMWITHDRAW;
            g.Clear(Color.White);
            toggleButtons(false, false, false, true, false, false, false, true);
            g.DrawString(messages[14], new Font("Tahoma", 18), Brushes.Green, new Point(150, 150));
            setLeft4(messages[15]);
            setRight4(messages[16]);
            pictureBox1.Image = picture;
        }
        private void calculateAmount()
        {
            if (state == State.WITHDRAWMONEY)
            {
                for (int i = 0; i < 6; i++)
                {
                    if (array[i] != 0)
                    {
                        int typeM = 0;
                        switch (i)
                        {
                            case 0:
                                typeM = 10;
                                break;
                            case 1:
                                typeM = 20;
                                break;
                            case 2:
                                typeM = 50;
                                break;
                            case 3:
                                typeM = 100;
                                break;
                            case 4:
                                typeM = 200;
                                break;
                            case 5:
                                typeM = 500;
                                break;
                        }
                        wAmount += array[i] * typeM;
                    }
                }
            }
        }
        private void btn_left4_Click(object sender, EventArgs e)
        {
            if (state == State.CHOOSELANGUAGE)
            {
                language = Lang.SLOVAK;
                messages = new Strings(language).getMessages();
                if (new Database().isCardBlocked(id))
                {
                    cardBlocked();
                }
                else
                {
                    enterPin();
                }

                
                state = State.LOGIN;
            }
            else if(state == State.WITHDRAWMONEY)
            {
                array[5]++;
                withdrawMoney();
            }
            else if(state == State.CONFIRMWITHDRAW)
            {
                new Database().withdrawMoney(id,wAmount);
                initMainScreen();
            }
        }

        private void btn_right4_Click(object sender, EventArgs e)
        {
            if (state == State.CHOOSELANGUAGE)
            {
                language = Lang.ENGLISH;
                messages = new Strings(language).getMessages();
                if (new Database().isCardBlocked(id))
                {
                    cardBlocked();
                }
                else
                {
                    enterPin();
                }
               
                state = State.LOGIN;
            }
            else if(state == State.MAINSCREEN)
            {
                
                Form1 form1 = new Form1();
                this.Hide();
                form1.Show();

            }
            else if(state == State.WITHDRAWMONEY)
            {
                otherValue();
            }
            else if (state == State.CONFIRMWITHDRAW)
            {
                
                initMainScreen();
            }

        }
        private void initMainScreen()
        {
            array = new int[] { 0, 0, 0, 0, 0, 0 };
            state = State.MAINSCREEN;
            toggleButtons(true, true, false, false, true, false, false, true);
            g.Clear(Color.White);
            setLeft1(messages[3]);
            setLeft2(messages[4]);
            setRight1(messages[5]);
            setRight4(messages[6]);
        }
        private void changePassword()
        {
            state = State.CHANGEPASSWORD;
            g.Clear(Color.White);
            enableKeyboard(true);
            toggleButtons(true, false, false, false, false, false, false, false);
            newPin();
        }

        private void btn_left1_Click(object sender, EventArgs e)
        {
            if(state == State.MAINSCREEN)
            {
               array = new int[] { 0, 0, 0, 0, 0, 0 };
                value = "";
                withdrawMoney();

            }
            else if(state == State.CHANGEPASSWORD || state == State.CONFIRMCHANGEPASSWORD || state == State.BALANCE || state == State.WITHDRAWMONEY || state == State.OTHERVALUE)
            {
                newPinCode = "";
                newPinCodeConfirm = "";
                initMainScreen();
            }
        }
        private void withdrawMoney()
        {
            state = State.WITHDRAWMONEY;
            enableKeyboard(true);
            g.Clear(Color.White);
            toggleButtons(true, true, true, true, true, true, true, true);
            setLeft1(messages[7]);
            if (array[3] > 0)
                setLeft2(array[3] + "x 100€");
            else
                setLeft2("100€");
            if (array[4] > 0)
                setLeft3(array[4] + "x 200€");
            else
                setLeft3("200€");

            if (array[5] > 0)
                setLeft4(array[5] + "x 500€");
            else
                setLeft4("500€");

            if (array[0] > 0)
                setRight1(array[0]+"x 10€");
            else
                setRight1("10€");

            if (array[1] > 0)
                setRight2(array[1] + "x 20€");
            else
                setRight2("20€");

            if (array[2] > 0)
                setRight3(array[2] + "x 50€");
            else
                setRight3("50€");
            setRight4(messages[13]);
        }
        private void btn_right1_Click(object sender, EventArgs e)
        {
            if(state == State.MAINSCREEN)
            {
                changePassword();
                enableKeyboard(true);
            }
            else if (state == State.WITHDRAWMONEY)
            {
                array[0]++;
                withdrawMoney();


            }
        }

        private void btn_right2_Click(object sender, EventArgs e)
        {
            if (state == State.WITHDRAWMONEY)
            {
                array[1]++;
                withdrawMoney();


            }
        }

        private void btn_right3_Click(object sender, EventArgs e)
        {
            if (state == State.WITHDRAWMONEY)
            {
                array[2]++;
                withdrawMoney();
            }
        }

        private void btn_left3_Click(object sender, EventArgs e)
        {
            if(state == State.WITHDRAWMONEY)
            {
                array[4]++;
                withdrawMoney();
            }
        }

        private void btn_left2_Click(object sender, EventArgs e)
        {
            if(state == State.MAINSCREEN)
            {
                state = State.BALANCE;
                showBalance();
            }
            else if (state == State.WITHDRAWMONEY)
            {
                array[3]++;
                withdrawMoney();
            }
        }
        private void showBalance()
        {
            g.Clear(Color.White);
            toggleButtons(true, false, false, false, false, false, false, false);
            setLeft1(messages[7]);
            g.DrawString(messages[12], new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            g.DrawString(""+new Database().getBalance(id)+ " €", new Font("Tahoma", 18), Brushes.Black, new Point(150, 200));
            pictureBox1.Image = picture;
        }
        private void newPin()
        {

            g.Clear(Color.White);
            setLeft1(messages[7]);
            g.DrawString(messages[8] , new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            String pin = "";
            for (int i = 0; i < newPinCode.Length; i++)
                pin += "*";
            g.DrawString(pin, new Font("Tahoma", 18), Brushes.Black, new Point(150, 200));
            pictureBox1.Image = picture;
        }
        
        private void PinCodeConfirm()
        {
            g.Clear(Color.White);
            setLeft1(messages[7]);
            g.DrawString(messages[9] , new Font("Tahoma", 18), Brushes.Black, new Point(150, 150));
            String pin = "";
            for (int i = 0; i < newPinCodeConfirm.Length; i++)
                pin += "*";
            g.DrawString(pin, new Font("Tahoma", 18), Brushes.Black, new Point(150, 200));
            pictureBox1.Image = picture;
        }
    }
}
