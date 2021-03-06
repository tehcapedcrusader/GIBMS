/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_files;

import com.jfoenix.controls.*;
import core.AGData;
import core.Entity;
import core.Integrator;
import guiMediators.Commons;
import guiMediators.EntityControls;
import guiMediators.tableViewHandler;
import handlers.ValidationHandler.*;
import handlers.dbConcurrent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Isuru Udukala
 */
public class CustomerController implements Initializable
{
    @FXML
    public JFXTextField text_lcid;
    @FXML
    private JFXTextField text_nic;
    @FXML
    private ToggleGroup tgroup_gender;
    @FXML
    private ToggleGroup tgroup_marital;
    @FXML
    private ToggleGroup tgroup_servicetype;
    @FXML
    private ToggleGroup tgroup_sector;
    @FXML
    private JFXRadioButton rb_male;
    @FXML
    private JFXRadioButton rb_female;
    @FXML
    private JFXRadioButton rb_married;
    @FXML
    private JFXRadioButton rb_notmarried;
    @FXML
    private JFXRadioButton rb_state;
    @FXML
    private JFXRadioButton rb_statecorp;
    @FXML
    private JFXRadioButton rb_selfemployed;
    @FXML
    private AnchorPane subanchor_tca;
    @FXML
    private JFXTextField text_fullname;
    @FXML
    private JFXDatePicker date_dob;
    @FXML
    private JFXTextField text_pphone;
    @FXML
    private JFXTextField text_email;
    @FXML
    private JFXTextField text_haddress;
    //customer controls
    @FXML
    private JFXTextField text_company;
    @FXML
    private JFXTextField text_position;
    @FXML
    private JFXDatePicker date_empl_start;
    @FXML
    private JFXTextField text_wphone;
    @FXML
    private JFXTextField text_accnum;
    @FXML
    private JFXTextField text_accbank;
    @FXML
    private JFXTextField text_accbranch;
    @FXML
    private JFXTextField text_earncareer;
    @FXML
    private JFXTextField text_earnbusiness;
    @FXML
    private JFXTextField text_earnhouses;
    @FXML
    private JFXTextField text_earnvehicles;
    @FXML
    private JFXTextField text_earnland;
    @FXML
    private JFXTextField text_spnic;
    @FXML
    private JFXTextField text_spname;
    @FXML
    private JFXTextField text_spprofession;
    @FXML
    private JFXTextField text_spcareer;
    @FXML
    private JFXTextField text_spbusiness;
    @FXML
    private JFXTextField text_sphouses;
    @FXML
    private JFXTextField text_spvehicles;
    @FXML
    private JFXTextField text_spland;
    @FXML
    private JFXRadioButton rb_permanent;
    @FXML
    private JFXRadioButton rb_temporary;
    @FXML
    private TableView<Entity> table_customer_search;
    @FXML
    private JFXButton btn_custsearch;
    @FXML
    private AnchorPane anchor_customer;
    @FXML
    private JFXTextField text_csnic;
    @FXML
    private JFXTextField text_csname;
    //TAB ADD LOAN
    @FXML
    private AnchorPane subanchor_tla;
    @FXML
    private JFXTextField text_lamount;
    @FXML
    private JFXTextField text_lexppayback;
    @FXML
    private JFXTextField text_lbank;
    @FXML
    private JFXTextField text_lbranch;
    @FXML
    private JFXTextField text_laccount;
    @FXML
    private JFXTextField text_lg1nic;
    @FXML
    private JFXTextField text_lg1name;
    @FXML
    private JFXDatePicker date_lg1dob;
    @FXML
    private JFXTextField text_lg1address;
    @FXML
    private JFXTextField text_lg1phone;
    @FXML
    private JFXRadioButton rb_lg1male;
    @FXML
    private ToggleGroup tgroup_lg1gender;
    @FXML
    private JFXRadioButton rb_lg1female;
    @FXML
    private JFXTextField text_lg1income;
    @FXML
    private JFXRadioButton rb_lmonthly;
    @FXML
    private JFXRadioButton rb_lpaycheck;
    @FXML
    private JFXRadioButton rb_lbank;
    @FXML
    private JFXTextField text_lg2nic;
    @FXML
    private JFXTextField text_lg2name;
    @FXML
    private JFXDatePicker date_lg2dob;
    @FXML
    private JFXTextField text_lg2address;
    @FXML
    private JFXTextField text_lg2phone;
    @FXML
    private JFXRadioButton rb_lg2male;
    @FXML
    private ToggleGroup tgroup_lg2gender;
    @FXML
    private JFXRadioButton rb_lg2female;
    @FXML
    private JFXTextField text_lg2income;
    @FXML
    private JFXButton btn_lcidsearch;
    @FXML
    private JFXTextField text_linterest;
    @FXML
    private ToggleGroup tgroup_paybackmode;
    @FXML
    private TableView<?> table_loan_search;
    @FXML
    private AnchorPane subanchor_ts;
    @FXML
    private AnchorPane subanchor_tcs;
    @FXML
    private AnchorPane subanchor_tls;
    @FXML
    private Label lbl_interest;
    @FXML
    private JFXTextField text_cscompany;
    @FXML
    private JFXTextField text_csaddress;
    @FXML
    private JFXButton btn_loansearchdate;
    @FXML
    private JFXTextField text_lsas;
    @FXML
    private JFXTextField text_lsae;
    @FXML
    private JFXButton btn_loansearchamount;
    @FXML
    private JFXDatePicker date_lsds;
    @FXML
    private JFXDatePicker date_lsde;
    @FXML
    private Label label_customerrecords;
    @FXML
    private Label label_loanrecords;
    @FXML
    private JFXButton btn_irepcust;
    @FXML
    private JFXButton btn_ireploan;
    @FXML
    private AnchorPane subanchor_tls1;
    @FXML
    private Label label_loanrecords1;
    @FXML
    private Label label_totalloans;
    @FXML
    private Label label_totalintallments;


    //dummy function acting as seperator between autogenerated @FXML tags and code
    private void seperatorFunc() {}

    private EntityControls personControls, customerControls, spouseControls;
    private EntityControls loanControls, guar1Controls, guar2Controls;
    private boolean customer_override = false;
    private boolean loan_override = false;
    private tableViewHandler custable_handle, loantable_handle;
    private dbConcurrent nbconn;

    final int MAXIMUM_LOAN_PAYBACK_DURATION = 48;
    final double MAXIMUM_ALLOWED_INTEREST = 2.0;
    final int MAXIMUM_LOAN_VALUE = 500000;

    JFXDialog dialog;
    int LOGGED_BRANCH = 1;
    JFXTabPane jfxtabpane;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        nbconn = dbConcurrent.getInstance();

        initializeCustomerControls();
        initializeLoanControls();

        jfxtabpane = Integrator.integrate(anchor_customer);
        jfxtabpane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                //second tab has search
                if ((int) newValue == 3 && !customer_override)
                {
                    custable_handle.writeToTable();
                }
                else if ((int) newValue == 4 && !loan_override)
                {
                    loantable_handle.writeToTable();
                }
                else if ((int) newValue == 5)
                {
                    label_totalloans.setText(Entity.parseFromQuery("select sum(amount) as total from loanplan;", nbconn).get(0).getAsString("total"));
                    label_totalintallments.setText(Entity.parseFromQuery("select sum(monthly_installment) as total from loanplan;", nbconn).get(0).getAsString("total"));
                }
            }
        });
    }


    private void add_customer()
    {
        int person_stat = -1, customer_stat = -1, spouse_stat = -1;
        Entity person, customer, spouse = null;

        if (personControls.triggerValidators() && customerControls.triggerValidators())
        {
            person = personControls.getValues();
            customer = customerControls.getValues();
        }
        else
        {
            displayDialog(0, 1, "customer", 1);
            return;
        }

        System.out.println(person);
        System.out.println(customer);

        if (!spouseControls.isDisabled())
        {
            spouse = spouseControls.getValues();
            if (spouseControls.triggerValidators())
            {
                spouse.add("customer_id", customer.getAGKey());
                spouse.validate(true);
                //spouse_stat = spouse.consolidate();
                if (spouse.getAGKey() != null)
                    customer.add("spouse_id", spouse.getAGKey());
            }
        }
        else
            spouse_stat = 0;

        person_stat = person.consolidate();
        customer_stat = customer.consolidate();

        if (person_stat == 0 && customer_stat == 0 && spouse_stat == 0)
        {
            personControls.clearControls();
            customerControls.clearControls();
            spouseControls.clearControls();

            displayDialog(0, 0, "customer", 1);
        }
        else
            displayDialog(0, 1, "customer", 1);
    }

    private void update_customer()
    {
        Entity up_person, up_customer, up_spouse;

        if (personControls.triggerValidators() && customerControls.triggerValidators())
        {
            up_person = personControls.getValues();
            up_customer = customerControls.getValues();

            AGData agd = AGData.getInstance();
            up_customer.add("customer_id", agd.get("customer_id"));
        }
        else
        {
            displayDialog(0, 1, "customer", 2);
            return;
        }

        up_person.update();
        up_customer.update();

        if (!spouseControls.isDisabled())
        {
            up_spouse = spouseControls.getValues();
            if (spouseControls.triggerValidators())
            {
                AGData agd = AGData.getInstance();
                up_spouse.add("spouse_id", agd.get("spouse_id"));
                //                up_spouse.add("customer_id", up_customer.getAGKey());
                up_spouse.validate(true);
                up_spouse.update();
            }
        }

        personControls.clearControls();
        customerControls.clearControls();
        spouseControls.clearControls();

        displayDialog(0, 0, "customer", 2);
    }


    private void add_loan()
    {
        Entity loanplan, guarantor1, guarantor2;
        int loanstat, g1stat, g2stat;
        if (loanControls.triggerValidators() && guar1Controls.triggerValidators() && guar2Controls.triggerValidators())
        {
            loanplan = loanControls.getValues();
            loanplan.add("monthly_installment", calculate_interest());

            guarantor1 = guar1Controls.getValues();
            guarantor2 = guar2Controls.getValues();
        }
        else
        {
            displayDialog(1, 1, "loan", 1);
            return;
        }

        loanstat = loanplan.consolidate();
        g1stat = guarantor1.consolidate();
        g2stat = guarantor2.consolidate();

        displayDialog(1, 0, "loan", 1);
    }

    public void initializeCustomerControls()
    {
        custable_handle = new tableViewHandler(table_customer_search, "select * from customer_view", nbconn);


        rb_male.setUserData("M");
        rb_female.setUserData("F");

        rb_married.setUserData("M");
        rb_notmarried.setUserData("N");

        rb_state.setUserData("S");
        rb_statecorp.setUserData("C");
        rb_selfemployed.setUserData("E");

        rb_permanent.setUserData("P");
        rb_temporary.setUserData("T");


        personControls = new EntityControls("person", nbconn);
        new ExistingNICValidator(nbconn).register(text_nic);
        personControls.add(new Object[][]
                {
                        {"nic", text_nic, new NICDOBCrossValidator(date_dob)},
                        {"full_name", text_fullname},
                        {"email", text_email, new EmailValidator()},
                        {"dob", date_dob, new birthdayValidator()},
                        {"phone", text_pphone, new PhoneValidator()},
                        {"address", text_haddress},
                        {"gender", tgroup_gender},
                        {"marital_status", tgroup_marital}
                });

        customerControls = new EntityControls("customer_state", nbconn);
        customerControls.add(new Object[][]
                {
                        {"nic", text_nic},
                        {"work_phone", text_wphone, new PhoneValidator()},
                        {"emp_sector", tgroup_sector},
                        {"company", text_company},
                        {"position", text_position},
                        {"emp_startdate", date_empl_start, new pastDateValidator()},
                        {"service_nature", tgroup_servicetype},
                        {"account_num", text_accnum},
                        {"account_branch", text_accbranch},
                        {"account_bank", text_accbank},
                        {"earn_career", text_earncareer, new IntegerValidator()},
                        {"earn_business", text_earnbusiness, new IntegerValidator()},
                        {"earn_houses", text_earnhouses, new IntegerValidator()},
                        {"earn_vehicles", text_earnvehicles, new IntegerValidator()},
                        {"earn_land", text_earnland, new IntegerValidator()},
                });

        spouseControls = new EntityControls("spouse", nbconn);
        spouseControls.add(new Object[][]
                {
                        {"nic", text_spnic, new NICValidator()},
                        {"name", text_spname},
                        {"profession", text_spprofession},
                        {"earn_career", text_spcareer, new IntegerValidator()},
                        {"earn_business", text_spbusiness, new IntegerValidator()},
                        {"earn_houses", text_sphouses, new IntegerValidator()},
                        {"earn_vehicles", text_spvehicles, new IntegerValidator()},
                        {"earn_land", text_spland, new IntegerValidator()}
                });

        spouseControls.disable();
        tgroup_marital.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
            {
                if (newValue != null)
                {
                    if (newValue.getUserData().equals("M"))
                        spouseControls.enable();
                    else
                        spouseControls.disable();
                }
            }
        });

        //add person button
        Commons.subAnchorButton apsab = new Commons.subAnchorButton(subanchor_tca, "ADD CUSTOMER", Commons.ADD_PERSON_GLYPH);
        apsab.setButtonLength(160);
        JFXButton addpersonButton = apsab.getButton();

        addpersonButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                add_customer();
            }
        });

        Commons.subAnchorButton upd_sab = new Commons.subAnchorButton(subanchor_tca, "UPDATE CUSTOMER", Commons.UPDATE_GLYPH);
        upd_sab.setGlyphSize(18, 15);
        upd_sab.setButtonLength(200);
        JFXButton btn_updatecustomer = upd_sab.getButton();
        btn_updatecustomer.setVisible(false);

        btn_updatecustomer.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                update_customer();
            }
        });

        Commons.subAnchorButton reset_custsab = new Commons.subAnchorButton(subanchor_tca, null, Commons.RESET_GLYPH);
        reset_custsab.setButtonDepth(1);
        reset_custsab.setGlyphSize(18, 15);
        reset_custsab.setCoordinates(930, 595);
        reset_custsab.setButtonTooltip("Reset table");
        reset_custsab.setStyle(Commons.BTNSTYLE_3);
        JFXButton btn_resetcustfields = reset_custsab.getButton();
        btn_resetcustfields.setVisible(false);

        btn_resetcustfields.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                btn_updatecustomer.setVisible(false);
                addpersonButton.setVisible(true);
                btn_resetcustfields.setVisible(false);

                personControls.clearControls();
                customerControls.clearControls();
                spouseControls.clearControls();
            }
        });


        //update, delete customer
        Commons.subAnchorButton ucsab = new Commons.subAnchorButton(subanchor_tcs, "UPDATE RECORD", Commons.UPDATE_GLYPH);
        ucsab.setButtonDepth(1);
        ucsab.setGlyphWidth(20);
        ucsab.setButtonSize(180, 40);
        ucsab.setCoordinates(200, 605);
        ucsab.setStyle(Commons.BTNSTYLE_2);
        JFXButton btn_upcust = ucsab.getButton();

        btn_upcust.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (custable_handle.getSelection() != null)
                {
                    Entity personS = custable_handle.fetchExtendedSelection("person", "NIC");
                    Entity customerS = custable_handle.fetchExtendedSelection("customer_state", "stateid", "customer_id");
                    Entity spouseS = custable_handle.fetchExtendedSelection("spouse", "spouseid", "spouse_id");

                    AGData agd = AGData.getInstance();
                    agd.add("customer_id", customerS.getObject("customer_id"));
                    agd.add("spouse_id", customerS.getObject("spouse_id"));

                    personControls.setValues(personS);
                    customerControls.setValues(customerS);
                    spouseControls.setValues(spouseS);
                    jfxtabpane.getSelectionModel().select(0);

                    addpersonButton.setVisible(false);
                    btn_updatecustomer.setVisible(true);
                    btn_resetcustfields.setVisible(true);
                }
            }
        });


        Commons.subAnchorButton dcsab = new Commons.subAnchorButton(subanchor_tcs, "DELETE RECORD", Commons.DELETE_GLYPH);
        dcsab.setButtonDepth(1);
        dcsab.setGlyphWidth(20);
        dcsab.setButtonSize(180, 40);
        dcsab.setCoordinates(600, 605);
        dcsab.setStyle(Commons.BTNSTYLE_2);
        JFXButton btn_delcust = dcsab.getButton();

        btn_delcust.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (custable_handle.getSelection() != null)
                {
                    if (custable_handle.fetchExtendedSelection("customer_state", "NIC").deleteFromDB())
                    {
                        try
                        {
                            dialog.close();
                        }
                        catch (Exception ex)
                        {
                        }
                        dialog = initializeDialog(3, ContentFactory.getDialog("SUCESSFULLY DELETED", "Record was successfully removed from the system", 1));
                        dialog.show();
                    }
                    else
                    {
                        try
                        {
                            dialog.close();
                        }
                        catch (Exception ex)
                        {
                        }
                        dialog = initializeDialog(3, ContentFactory.getDialog("DELETING RECORD FAILED", "Internal error encountered while deleting records", 2));
                        dialog.show();
                    }
                }
            }
        });

        Commons.subAnchorButton rcsab = new Commons.subAnchorButton(subanchor_tcs, null, Commons.RESET_GLYPH);
        rcsab.setButtonDepth(1);
        rcsab.setGlyphSize(18, 15);
        rcsab.setCoordinates(930, 595);
        rcsab.setButtonTooltip("Reset table");
        rcsab.setStyle(Commons.BTNSTYLE_3);
        JFXButton btn_resetcust = rcsab.getButton();

        btn_resetcust.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                custable_handle.writeToTable();
                customer_override = false;
            }
        });


        btn_custsearch.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Entity customerSearch = new Entity("select * from customer_view", nbconn);
                customerSearch.add(new Object[][]
                        {
                                {"nic", text_csnic.getText()},
                                {"full name", text_csname.getText()},
                                {"company", text_cscompany.getText()},
                                {"home address", text_csaddress.getText()}
                        });

                custable_handle.writeToTable(customerSearch.executeAsSearch());
                customer_override = true;
                jfxtabpane.getSelectionModel().select(3);
            }
        });

        //ireportmarker
        btn_irepcust.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    String path = "/Volumes/Media/Home/isuru/Documents/NetBeansProjects/GIBMS/src/reports/isuru1.jrxml";
                    JasperReport jr = JasperCompileManager.compileReport(path);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null, nbconn.get());
                    JasperViewer.viewReport(jp, false);
                }
                catch (Exception e)
                {
                    System.out.println("ireport error : \n" + e);
                }
            }
        });
    }

    private void initializeLoanControls()
    {
        btn_loansearchdate.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    String dstart = date_lsds.getValue().format(DateTimeFormatter.ISO_DATE);
                    String dend = date_lsde.getValue().format(DateTimeFormatter.ISO_DATE);
                    String dquery = "select * from loanplan where timestamp between '" + dstart + "' and '" + dend + "';";
                    loantable_handle.writeToTable(Entity.parseFromQuery(dquery, nbconn));
                    loan_override = true;
                    jfxtabpane.getSelectionModel().select(4);
                }
                catch (Exception e)
                {
                }
            }
        });

        btn_loansearchamount.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    int lower = Integer.parseInt(text_lsas.getText());
                    int upper = Integer.parseInt(text_lsae.getText());
                    String aquery = "select * from loanplan where amount between " + lower + " and " + upper + ";";
                    loantable_handle.writeToTable(Entity.parseFromQuery(aquery, nbconn));
                    loan_override = true;
                    jfxtabpane.getSelectionModel().select(4);
                }
                catch (Exception e)
                {
                }
            }
        });

        rb_lmonthly.setUserData("M");
        rb_lpaycheck.setUserData("P");
        rb_lbank.setUserData("B");

        rb_lg1male.setUserData("M");
        rb_lg1female.setUserData("F");

        rb_lg2male.setUserData("M");
        rb_lg2female.setUserData("F");

        loanControls = new EntityControls("loanplan", nbconn);
        loanControls.add(new Object[][]
                {
                        {"customer_id", text_lcid},
                        {"amount", text_lamount, new DoubleValidator(MAXIMUM_LOAN_VALUE)},
                        {"interest", text_linterest, new DoubleValidator(MAXIMUM_ALLOWED_INTEREST)},
                        {"payback_duration", text_lexppayback, new IntegerValidator(MAXIMUM_LOAN_PAYBACK_DURATION)},
                        {"payback_method", tgroup_paybackmode},
                        {"bank", text_lbank},
                        {"branch", text_lbranch},
                        {"account", text_laccount},
                        {"guarantor1", text_lg1nic},
                        {"guarantor1_income", text_lg1income, new DoubleValidator()},
                        {"guarantor2", text_lg2nic},
                        {"guarantor2_income", text_lg2income, new DoubleValidator()},
                        {"branch_id", LOGGED_BRANCH}
                });

        guar1Controls = new EntityControls("person", nbconn);
        guar1Controls.add(new Object[][]
                {
                        {"nic", text_lg1nic, new NICDOBCrossValidator(date_lg1dob)},
                        {"full_name", text_lg1name},
                        {"dob", date_lg1dob, new birthdayValidator()},
                        {"phone", text_lg1phone, new PhoneValidator()},
                        {"address", text_lg1address},
                        {"gender", tgroup_lg1gender}
                });

        guar2Controls = new EntityControls("person", nbconn);
        guar2Controls.add(new Object[][]
                {
                        {"nic", text_lg2nic, new NICDOBCrossValidator(date_lg2dob)},
                        {"full_name", text_lg2name},
                        {"dob", date_lg2dob, new birthdayValidator()},
                        {"phone", text_lg2phone, new PhoneValidator()},
                        {"address", text_lg2address},
                        {"gender", tgroup_lg2gender}
                });


        EntityControls tmp_bankgroup = new EntityControls(null, null);
        tmp_bankgroup.add(new Object[][]
                {
                        {"X", text_lbank},
                        {"Y", text_lbranch},
                        {"Z", text_laccount}
                });
        tmp_bankgroup.disable();
        tgroup_paybackmode.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
            {

                if (newValue != null)
                {
                    if (newValue.getUserData().equals("B"))
                    {
                        tmp_bankgroup.enable();
                    }
                    else
                    {
                        tmp_bankgroup.disable();
                    }
                }
            }
        });


        lbl_interest.setStyle("-fx-font-family: \"Roboto condensed\"; -fx-font-size: 24px; -fx-font-weight: Normal;");
        text_lamount.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                if (newValue)
                    calculate_interest();
            }
        });

        text_lexppayback.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                if (newValue)
                    calculate_interest();
            }
        });

        text_linterest.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                if (newValue)
                    calculate_interest();
            }
        });

        calculate_interest();
        Commons.subAnchorButton alsab = new Commons.subAnchorButton(subanchor_tla, "ADD LOAN REQUEST", Commons.ADD_PERSON_GLYPH);
        alsab.setButtonLength(200);
        JFXButton addloanButton = alsab.getButton();

        addloanButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                add_loan();
            }
        });

        //update, delete loan
        Commons.subAnchorButton ulsab = new Commons.subAnchorButton(subanchor_tls, "UPDATE RECORD", Commons.UPDATE_GLYPH);
        ulsab.setButtonDepth(1);
        ulsab.setGlyphWidth(20);
        ulsab.setButtonSize(180, 40);
        ulsab.setCoordinates(200, 605);
        ulsab.setStyle(Commons.BTNSTYLE_2);
        JFXButton btn_uploan = ulsab.getButton();


        Commons.subAnchorButton dlsab = new Commons.subAnchorButton(subanchor_tls, "DELETE RECORD", Commons.DELETE_GLYPH);
        dlsab.setButtonDepth(1);
        dlsab.setGlyphWidth(20);
        dlsab.setButtonSize(180, 40);
        dlsab.setCoordinates(600, 605);
        dlsab.setStyle(Commons.BTNSTYLE_2);
        JFXButton btn_delloan = dlsab.getButton();

        btn_delloan.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (loantable_handle.getSelection() != null)
                {
                    try
                    {
                        Entity loanD = loantable_handle.fetchExtendedSelection("loanplan", "loanid");
                        Entity guar1D = loantable_handle.fetchExtendedSelection("person", "guarantor1", "nic");
                        Entity guar2D = loantable_handle.fetchExtendedSelection("person", "guarantor2", "nic");

                        System.out.println(loanD);
                        System.out.println(guar1D);
                        System.out.println(guar2D);

                        loanD.deleteFromDB();
                        guar1D.deleteFromDB();
                        guar2D.deleteFromDB();

                        try
                        {
                            dialog.close();
                        }
                        catch (Exception ex)
                        {
                        }
                        dialog = initializeDialog(4, ContentFactory.getDialog("SUCESSFULLY DELETED", "Record was successfully removed from the sysetem", 1));
                        dialog.show();
                    }
                    catch (Exception e)
                    {
                        try
                        {
                            dialog.close();
                        }
                        catch (Exception ex)
                        {
                        }
                        dialog = initializeDialog(4, ContentFactory.getDialog("DELETING RECORD FAILED", "Internal error encountered while deleting records", 2));
                        dialog.show();
                        System.out.println(e);
                    }
                }
            }
        });

        Commons.subAnchorButton rlsab = new Commons.subAnchorButton(subanchor_tls, null, Commons.RESET_GLYPH);
        rlsab.setButtonDepth(1);
        rlsab.setGlyphSize(18, 15);
        rlsab.setCoordinates(930, 595);
        rlsab.setButtonTooltip("Reset table");
        rlsab.setStyle(Commons.BTNSTYLE_3);
        JFXButton btn_resetloan = rlsab.getButton();

        btn_resetloan.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                loantable_handle.writeToTable();
                loan_override = false;
            }
        });

        btn_lcidsearch.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ContentFactory.getPopOver(nbconn, text_lcid, btn_lcidsearch);
            }
        });

        loantable_handle = new tableViewHandler(table_loan_search, "select * from loanplan;", nbconn);


        Commons.subAnchorButton updl_sab = new Commons.subAnchorButton(subanchor_tla, "UPDATE LOAN", Commons.UPDATE_GLYPH);
        updl_sab.setButtonLength(200);
        JFXButton btn_updateloan = updl_sab.getButton();
        btn_updateloan.setVisible(false);

        btn_updateloan.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                update_loan();
            }
        });

        Commons.subAnchorButton reset_loansab = new Commons.subAnchorButton(subanchor_tla, null, Commons.RESET_GLYPH);
        reset_loansab.setButtonDepth(1);
        reset_loansab.setGlyphSize(18, 15);
        reset_loansab.setCoordinates(930, 595);
        reset_loansab.setButtonTooltip("Reset table");
        reset_loansab.setStyle(Commons.BTNSTYLE_3);
        JFXButton btn_resetloanfields = reset_loansab.getButton();
        btn_resetloanfields.setVisible(false);

        btn_resetloanfields.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                btn_updateloan.setVisible(false);
                addloanButton.setVisible(true);
                btn_resetloanfields.setVisible(false);

                loanControls.clearControls();
                guar1Controls.clearControls();
                guar2Controls.clearControls();
            }
        });


        btn_uploan.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (loantable_handle.getSelection() != null)
                {
                    Entity loanS = loantable_handle.fetchExtendedSelection("loanplan", "loanid");
                    Entity guar1S = loantable_handle.fetchExtendedSelection("person", "guarantor1", "nic");
                    Entity guar2S = loantable_handle.fetchExtendedSelection("person", "guarantor2", "nic");
                    //
                    //                    System.out.println(loanS);
                    //                    System.out.println(guar1S);
                    //                    System.out.println(guar2S);


                    //                    cb_cbalance.setText(Entity.parseFromQuery("select sum(credit_amount) as 'total' from bvr_addmember", nbconn).get(0).getAsString("total"));


                    AGData agd = AGData.getInstance();
                    agd.add("loanid", loanS.getObject("loanid"));

                    loanControls.setValues(loanS);
                    guar1Controls.setValues(guar1S);
                    guar2Controls.setValues(guar2S);
                    jfxtabpane.getSelectionModel().select(1);

                    addloanButton.setVisible(false);
                    btn_updateloan.setVisible(true);
                    btn_resetloanfields.setVisible(true);
                }
            }
        });


        btn_ireploan.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    String path = "/Volumes/Media/Home/isuru/Documents/NetBeansProjects/GIBMS/src/reports/isuru2.jrxml";
                    JasperReport jr = JasperCompileManager.compileReport(path);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null, nbconn.get());
                    JasperViewer.viewReport(jp, false);
                }
                catch (Exception e)
                {
                    System.out.println("ireport error : \n" + e);
                }
            }
        });
    }

    private Double calculate_interest()
    {
        Double installment = null;
        try
        {
            if (text_lamount.validate() && text_linterest.validate() && text_lexppayback.validate())
            {
                double amount = Double.parseDouble(text_lamount.getText());
                double interest = Double.parseDouble(text_linterest.getText()) / 100;
                int months = Integer.parseInt(text_lexppayback.getText());

                installment = amount / months + amount * interest;

                lbl_interest.setText(String.format("Rs. %.2f", installment));
                lbl_interest.setTextFill(Paint.valueOf("#68bf5f"));
            }
            else
            {
                lbl_interest.setText("Unavailable");
                lbl_interest.setTextFill(Paint.valueOf("#CB503F"));
            }
        }
        catch (Exception e)
        {
            lbl_interest.setText("Unavailable");
            lbl_interest.setTextFill(Paint.valueOf("#CB503F"));
        }
        return installment;
    }

    private JFXDialog initializeDialog(int tabnum, JFXDialog dialog)
    {
        Control control;
        int translate = 0;
        switch (tabnum)
        {
            case 0:
                control = text_nic;
                translate = -445;
                break;
            case 1:
                control = text_lamount;
                translate = -445;
                break;
            case 2:
                control = text_csname;
                break;
            case 3:
                control = label_customerrecords;
                break;
            case 4:
                control = label_loanrecords;
                break;
            default:
                return null;
        }
        //testingmarker
        System.out.println(control);
        dialog.setDialogContainer((StackPane) control.getParent().getParent());
        dialog.setTranslateY(translate);

        return dialog;
    }

    public void displayDialog(int tabnum, int status, String recordtype, int optype)
    {
        String operation;
        switch (optype)
        {
            case 1:
                operation = "CONSOLIDATION";
                break;
            case 2:
                operation = "UPDATE";
                break;
            case 3:
                operation = "DELETE";
                break;
            default:
                return;
        }

        switch (status)
        {
            case 0:
                try
                {
                    dialog.close();
                }
                catch (Exception ex)
                {
                }
                dialog = initializeDialog(tabnum, ContentFactory.getDialog(operation + " SUCESSFUL", recordtype + " record added to database successfully", 1));
                dialog.show();
                break;
            case 1:
                try
                {
                    dialog.close();
                }
                catch (Exception ex)
                {
                }
                dialog = initializeDialog(tabnum, ContentFactory.getDialog("FIELDS EMPTY/INVALID", "Please fill out all required fields correctly", 2));
                dialog.show();
                break;
            case 2:
                try
                {
                    dialog.close();
                }
                catch (Exception ex)
                {
                }
                dialog = initializeDialog(tabnum, ContentFactory.getDialog(operation + " FAILED", "failed due to an internal error", 2));
                dialog.show();
                break;
            default:
                break;
        }
    }

    private void update_loan()
    {
        Entity up_loan, up_guar1, up_guar2;

        if (personControls.triggerValidators() && customerControls.triggerValidators())
        {
            up_loan = loanControls.getValues();
            up_guar1 = guar1Controls.getValues();
            up_guar2 = guar2Controls.getValues();

            AGData agd = AGData.getInstance();
            up_loan.add("loanid", agd.get("loanid"));
        }
        else
        {
            displayDialog(1, 1, "loan", 2);
            return;
        }

        up_loan.update();
        up_guar1.update();
        up_guar2.update();

        loanControls.clearControls();
        guar1Controls.clearControls();
        guar2Controls.clearControls();

        displayDialog(1, 0, "loan", 2);
    }
}