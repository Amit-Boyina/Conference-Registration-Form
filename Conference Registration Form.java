//This is a Javafx based application that is used to calculates the registration fees for a conference and the workshops included with those


// Package name
package com.example.final_oops;


/*  Standard libraries, classes and methods that are to be imported to run standard nodes of a Javafx function */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Final_Project extends Application
{
    /**{@code @RadioButtons General Registration and Student Registration options}
     * These options are the ones that appear on the first form */
    RadioButton General_Reg, Student_Reg;

    /**{@code @ToggleGroup First_Group} Using Toggle Group for General_Reg and Student_Reg Radio Buttons to make sure only one of them is selected*/
    ToggleGroup First_Group = new ToggleGroup();

    /**{@code @CheckBox Opening_Dinner, E_Comm, Web_Future, Visual_Basic and Security_Network} to add optional selection of
     * Opening Night Dinner, And the 4 optional Pre-conference workshops along with the charges for them:
     * Optional Preconference workshops
     * Workshop                               Fee
     * 1) Introduction to E-commerce 		  $295
     * 2) The Future of the Web               $295
     * 3) Advance Visual Basic                $395
     * 4) Network Security                    $395 */
    CheckBox Opening_Dinner, E_Comm, Web_Future, Visual_Basic, Security_Network;

    /** {@code @Buttons Next, Calculate and Close} The three buttons used in the three forms which open the next form if there is one and close the current form*/
    Button Next, Calculate, Close;

    /** {@code @Text Display_Text} A simple Text node to display the total fees of the conference registration*/
    Text Display_Text;

    /** {@code @String[] Options_Text} A string array to store all the options to be displayed as the optional preconference workshop available to select
     * Using Checkbox*/
    String[] Options_Text = {"Introduction to E-commerce: $295", "The Future of the Web: $295", "Advanced Java Programming: $395", "Network Security: $395"};

    /** {@code @double[] Options_Cost} A double array to store cost of all the options available to select for preconference workshops
     * Using Setuserdata*/
    double[] Options_Cost = {295, 295, 395, 395};

    /** Overridden method start from Application class which uses
     *  of root stage like @param Primary_Stage*/
    @Override
    public void start(Stage Primary_Stage)
    {
        // Creating Vbox Containers (Branch Node) for each to sort all nodes vertically, 3 in total
        VBox Vbox_Obj_1 = new VBox();
        VBox Vbox_Obj_2 = new VBox();
        VBox Vbox_Obj_3 = new VBox();
        /* Creating Scene Containers (Branch Node) for each stage, 3 in total
         * Each scene is 300 pixels wide and 400 pixels tall */
        Scene Scene_1 = new Scene(Vbox_Obj_1, 300, 300);
        Scene Scene_2 = new Scene(Vbox_Obj_2, 300, 300);
        Scene Scene_3 = new Scene(Vbox_Obj_3, 300, 300);
        // Creating two more forms using stages
        Stage Secondary_Stage = new Stage();
        Stage Tertiary_Stage = new Stage();


        // Setting the vertical spacing between each node in a vbox as 20 pixels
        Vbox_Obj_1.setSpacing(20);
        // Setting the alignment of each node in the center of the container vbox
        Vbox_Obj_1.setAlignment(Pos.CENTER);
        // Setting the amount of padding around the edges of the vbox container for its child nodes
        // The padding is 20 pixels wide
        Vbox_Obj_1.setPadding(new Insets(20));
        // Adding the first Scene to the first stage
        Primary_Stage.setScene(Scene_1);
        // Setting its title as Conference Registration
        Primary_Stage.setTitle("Conference Registration");

        // Setting the Radiobutton values and the description that will be displayed with them
        // The General Registration button that costs $895
        General_Reg = new RadioButton("General Registration ($895)");
        General_Reg.setUserData(895.0);
        // The Student Registration button that costs $495
        Student_Reg = new RadioButton("Student Registration ($495)");
        Student_Reg.setUserData(495.0);
        // Adding General Registration radiobutton to the Toggle group
        General_Reg.setToggleGroup(First_Group);
        // Setting General Registration radiobutton to true
        // So at least on option is selected before we continue to the optional preconference workshop list
        General_Reg.setSelected(true);
        // Adding Student Registration radiobutton to the Toggle group
        Student_Reg.setToggleGroup(First_Group);
        // Setting up the Opening Night optional dinner checkbox with the data set to $30
        Opening_Dinner = new CheckBox("Opening Night Dinner ($30)");
        Opening_Dinner.setUserData(30.0);

        // Setting up the "Next" button
        // When it is pressed, the primary or first stage will close
        // And second stage that has the preconference workshops option list pops up
        // Using lambda implementation
        Next = new Button("Next");
        Next.setOnAction(e ->
        {
            Secondary_Stage.show();
            Primary_Stage.close();
        });


        // Adding General Register Radio Button Node to the Vbox 1
        Vbox_Obj_1.getChildren().add(General_Reg);
        // Adding Student Register Radio Button Node to the Vbox 1
        Vbox_Obj_1.getChildren().add(Student_Reg);
        // Adding Opening Night Dinner Checkbox Node to the Vbox 1
        Vbox_Obj_1.getChildren().add(Opening_Dinner);
        // Adding Next Button Node to the Vbox 1
        Vbox_Obj_1.getChildren().add(Next);


        // Setting the title for second form with the Optional Workshops list
        Secondary_Stage.setTitle("Optional Workshops");
        Secondary_Stage.setScene(Scene_2);
        // Setting the vertical spacing between each node in a vbox as 20 pixels
        Vbox_Obj_2.setSpacing(20);
        // Setting the alignment of each node to the center left of the vbox
        Vbox_Obj_2.setAlignment(Pos.CENTER_LEFT);
        // Setting the amount of padding around the edges of the vbox container for its child nodes
        // The padding is 20 pixels wide
        Vbox_Obj_2.setPadding(new Insets(20));

        // Setting up the Four optional preconference workshop checkbox list
        // Setting up the Introduction to E-Commerce checkbox
        E_Comm = new CheckBox(Options_Text[0]);
        E_Comm.setUserData(Options_Cost[0]);

        // Setting the future of the Web Checkbox
        Web_Future = new CheckBox(Options_Text[1]);
        Web_Future.setUserData(Options_Cost[1]);

        // Setting up the Advance Visual Basic Checkbox
        Visual_Basic = new CheckBox(Options_Text[2]);
        Visual_Basic.setUserData(Options_Cost[2]);

        // Setting up the Network Security Checkbox
        Security_Network = new CheckBox(Options_Text[3]);
        Security_Network.setUserData(Options_Cost[3]);

        // Setting up the "Calculate button that closes the current stage/form"
        // And opens the final form that holds the final amount
        // Also calls the Summation function that calculates the total fees that the is owned
        // Using lambda implementation
        Calculate = new Button("Calculate");
        Calculate.setOnAction(e ->
        {
            Secondary_Stage.close();
            Tertiary_Stage.show();
            Total_Fees_Calculator();
        });

        // Adding all the nodes to  the second vbox container
        // Adding a text node to the vbox
        Vbox_Obj_2.getChildren().add(new Label("Select an Option Workshop: "));
        // Adding the Introduction to E-Commerce checkbox
        Vbox_Obj_2.getChildren().add(E_Comm);
        // Adding the future of the Web Checkbox
        Vbox_Obj_2.getChildren().add(Web_Future);
        // Adding the Advance Visual Basic Checkbox
        Vbox_Obj_2.getChildren().add(Visual_Basic);
        // Adding the Network Security Checkbox
        Vbox_Obj_2.getChildren().add(Security_Network);
        // Adding the calculate button
        Vbox_Obj_2.getChildren().add(Calculate);

        // Setting the title for the final slide that displays the total fees owned
        Tertiary_Stage.setTitle("Total Fees");
        // Adding Scene 3 to the Tertiary Stage
        Tertiary_Stage.setScene(Scene_3);
        // Setting the vertical spacing between each node in a vbox as 20 pixels
        Vbox_Obj_3.setSpacing(20);
        // Setting the alignment of each node in the center of the container vbox
        Vbox_Obj_3.setAlignment(Pos.CENTER);
        // Setting the amount of padding around the edges of the vbox container for its child nodes
        // The padding is 20 pixels wide
        Vbox_Obj_3.setPadding(new Insets(20));
        // Adding a text that displays the cost of the conference registration
        Display_Text = new Text("Cost: $0.00");
        // Creating a new button "Close" that closes this screen
        Close = new Button("Close");
        // This Button closes this window and ends the program
        // Using lambda implementation
        Close.setOnAction(e -> Tertiary_Stage.close());

        // Adding the elements to the third Vbox
        // Adding the display text node to the pane
        Vbox_Obj_3.getChildren().add(Display_Text);
        // Adding the close button node to the container vbox
        Vbox_Obj_3.getChildren().add(Close);

        // Using show to start the function initially
        // To show the First screen
        Primary_Stage.show();
    }

    /** The Function @Total_Fees_Calculator
     * that calculates the final sum of all the fees related to the selected options
     * It is a void function that does not have any parameters */
    private void Total_Fees_Calculator()
    {
        // Creating a temporary variable that stores the total sum of all charges and fees
        double Total_Sum = 0;

        // If the Radio button General Registration is selected add its fee
        if (General_Reg.isSelected())
        {
            Total_Sum += (Double) General_Reg.getUserData();
        }

        // If the Radio button Student Registration is selected add its fee
        if (Student_Reg.isSelected())
        {
            Total_Sum += (Double) Student_Reg.getUserData();
        }

        // If the Checkbox Opening night dinner is selected add its fee
        if (Opening_Dinner.isSelected())
        {
            Total_Sum += (Double) Opening_Dinner.getUserData();
        }

        // If the Checkbox Introduction to E-commerce is selected add its fee
        if (E_Comm.isSelected())
        {
            Total_Sum += (Double) E_Comm.getUserData();
        }

        // If the Checkbox The Future of the Web is selected add its fee
        if (Web_Future.isSelected())
        {
            Total_Sum += (Double) Web_Future.getUserData();
        }

        // If the Checkbox Advance Visual Basic is selected add its fee
        if (Visual_Basic.isSelected())
        {
            Total_Sum += (Double) Visual_Basic.getUserData();
        }

        // If the Checkbox Network Security is selected add its fee
        if (Security_Network.isSelected())
        {
            Total_Sum += (Double) Security_Network.getUserData();
        }

        // Modifying the "Display_Text" Text node to display the actual cost
        Display_Text.setText(String.format("Cost: $%.2f", Total_Sum));
    }

    // The main Driver Function
    public static void main(String[] args)
    {
        // Using "launch" method to launch the application
        // It then calls the start method automatically
        launch(args);
    }
}