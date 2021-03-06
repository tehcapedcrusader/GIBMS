/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paniya;


import com.jfoenix.controls.*;
import core.Entity;
import core.Integrator;
import guiMediators.Commons;
import guiMediators.EntityControls;
import guiMediators.tableViewHandler;
import handlers.ValidationHandler;
import handlers.ValidationHandler.NICValidator;
import handlers.dbConcurrent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author praneethjayawickrama
 */
public class FXMLTemplateController implements Initializable {

    @FXML
    private AnchorPane cashflow_anchorpane;
    @FXML
    private TabPane cashflow_tabpane;
    @FXML
    private AnchorPane bvr_anchorpane;
    @FXML
    private JFXDatePicker bvr_date;
    @FXML
    private HBox bvr_hbox;
    @FXML
    private JFXRadioButton bvr_voucher;
    @FXML
    private ToggleGroup bvr_tgroup;
    @FXML
    private JFXRadioButton bvr_receipt;
    @FXML
    private JFXTextField bvr_totalamount;
    @FXML
    private JFXTextField bvr_debitamount;
    @FXML
    private JFXTextField bvr_chequeno;
    @FXML
    private JFXDatePicker bvr_chequedate;
    @FXML
    private JFXTextField bvr_description;
    @FXML
    private JFXTextField bvr_creditamount;
    @FXML
    private JFXTextField bvr_serialno;
    @FXML
    private JFXTextField bvr_branchno;
    @FXML
    private JFXTextField bvr_branchname;
    @FXML
    private JFXTextField bvr_companyid;
    @FXML
    private JFXTextField bvr_companyname;
    @FXML
    private JFXTextField bvr_transactioncode;
    @FXML
    private JFXTextField bvr_transactionname;
    @FXML
    private JFXTextField bvr_paymenttype;
    @FXML
    private JFXTextField bvr_nic;
    @FXML
    private JFXTextField bvr_narration;
    @FXML
    private TableView<?> bvr_addmember_table;
    @FXML
    private AnchorPane bvr_list_anchorpane;
    @FXML
    private Label bvr_serialno111;
    @FXML
    private TableView<?> bvr_add_table;
    @FXML
    private AnchorPane cb_anchorpane;
    @FXML
    private JFXDatePicker cb_id;
    @FXML
    private TableView<?> cb_table;
    @FXML
    private JFXTextField cb_cbalance;
    @FXML
    private JFXTextField cb_dbalance;
    @FXML
    private AnchorPane cb_list_anchorpane;
    @FXML
    private TableView<?> cb_summary_table;
    @FXML
    private AnchorPane gl_anchorpane;
    @FXML
    private GridPane gl_transactioncode;
    @FXML
    private JFXTextField gl_dbalance;
    @FXML
    private TableView<?> gl_table;
    @FXML
    private JFXTextField gl_tc;
    @FXML
    private JFXTextField gl_cbalance;
    @FXML
    private JFXTextField gl_search;
    @FXML
    private AnchorPane tb_anchorpane;
    @FXML
    private JFXDatePicker tb_id;
    @FXML
    private JFXTextField tb_debitbdbalance;
    @FXML
    private TableView<?> tb_table;
    @FXML
    private JFXTextField tb_creditbdbalance;
    @FXML
    private AnchorPane dsr_anchorpane;
    @FXML
    private TableView<?> dsr_table;
    @FXML
    private AnchorPane tc_anchorpane;
    @FXML
    private Label bvr_serialno1;
    @FXML
    private TableView<?> tc_table;
    @FXML
    private JFXTextField tc_transactioncode;
    @FXML
    private JFXTextField tc_transactionname;
    @FXML
    private AnchorPane cl_anchorpane;
    @FXML
    private TableView<?> cl_table;
    @FXML
    private JFXTextField cl_companyid;
    @FXML
    private JFXTextField cl_companyname;
    @FXML
    private JFXTextField cl_branchno;
    
    private EntityControls bvr_addControls,bvr_addmemberControls, cashbookControls, general_ledgerControls, trial_balanceControls, transaction_codeControls, company_listControls ;
    private tableViewHandler bvr_addmember_handle,bvr_add_handle, cashbook_handle,cashbook_summary_handle, general_ledger_handle, trial_balance_handle,dsr_handle, transaction_code_handle, company_list_handle ;
    private dbConcurrent nbconn;
    JFXTabPane jfxcashflow_tabpane;
    final int max_tc = 999 ;
    final int maxbranchno = 10;
    final int maxserialno = 999999;
    final double maxmemberamount = 500000;    
    @FXML
    private JFXTextField bvr_list_total;
    @FXML
    private JFXButton ireport;
    @FXML
    private JFXButton bvr_findbranchname;
    @FXML
    private JFXButton bvr_findcompanyname;
    @FXML
    private JFXButton bvr_findtransactionname;
            
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        nbconn = dbConcurrent.getInstance();
        
       
        jfxcashflow_tabpane = Integrator.integrate(cashflow_anchorpane);
       
        
        initializeRadioButtons();
        initializebvr_addInputs();
        initializebvr_addmemberInputs();
        initializecashbookInputs();
        initializegeneral_ledgerInputs();
        initializetrial_balanceInputs();
        initializetransaction_codeInputs();
        initializecompany_listInputs();
        initializetcButtons();
        initializeclButtons();
        initializebvr_addButtons();
        initializebvr_addmemberButtons();
        initializecbButtons();
        initializetbButtons();
        initializeglButtons();
        initializecashbookButtons();
        initializegoglButtons();
        initializebvr_search();
        initializetabepane();
        initializeglpop();
        initializeglpop1();
        initializeglpop2();
        initializeglpop3();
        initializeNodes();
       }    
    
     private void initializeNodes() {
         
         
         ireport.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    String path = "/Volumes/Media/Home/isuru/Documents/NetBeansProjects/GIBMS/src/reports/isuru1.jrxml";
                    JasperReport jr =JasperCompileManager.compileReport(path);
                    JasperPrint jp =JasperFillManager.fillReport(jr,null,nbconn.get());
                    JasperViewer.viewReport(jp,false);
                }
                catch(Exception e)
                {
                    System.out.println("ireport error : \n" + e);
                }
            }
        });

      
        
    }
    
    
    

    private void initializetransaction_codeInputs() {
        
         transaction_codeControls = new EntityControls("transaction_code", nbconn);
         transaction_codeControls.add("transaction_code", tc_transactioncode, new ValidationHandler.IntegerValidator());
         transaction_codeControls.add("transaction_name", tc_transactionname);
         
    }

    private void initializecompany_listInputs() {
        
         company_listControls = new EntityControls("company_list", nbconn);
         company_listControls.add("company_id", cl_companyid);
         company_listControls.add("branch_no", cl_branchno, new ValidationHandler.IntegerValidator());
         company_listControls.add("company_name", cl_companyname);
         
         
         
         
    }

   

    private void initializeRadioButtons() {
        
    }
    

    private void initializebvr_addInputs() {
        
         bvr_voucher.setUserData("Voucher");
         bvr_receipt.setUserData("Receipt");
       
         bvr_addControls = new EntityControls("bvr_add", nbconn);
         bvr_addControls.add("voucher_receipt", bvr_tgroup);
         bvr_addControls.add("date", bvr_date, new ValidationHandler.pastDateValidator());
         bvr_addControls.add("serial_no", bvr_serialno, new ValidationHandler.IntegerValidator());
         bvr_addControls.add("transaction_code", bvr_transactioncode, new ValidationHandler.IntegerValidator());
         bvr_addControls.add("transaction_name", bvr_transactionname);
         bvr_addControls.add("branch_no", bvr_branchno, new ValidationHandler.IntegerValidator());
         bvr_addControls.add("branch_name", bvr_branchname);
         bvr_addControls.add("payment_type", bvr_paymenttype);
         bvr_addControls.add("cheque_no", bvr_chequeno);
         bvr_addControls.add("cheque_date", bvr_chequedate, new ValidationHandler.pastDateValidator());
         bvr_addControls.add("total_amount",bvr_totalamount, new ValidationHandler.DoubleValidator());
         bvr_addControls.add("narration",bvr_narration );
         bvr_addControls.add("company_id",bvr_companyid, new ValidationHandler.IntegerValidator() );
         bvr_addControls.add("company_name",bvr_companyname );
        
            
    }

    private void initializebvr_addmemberInputs() {
       
         bvr_addmemberControls = new EntityControls("bvr_addmember",nbconn);
         bvr_addmemberControls.add("serial_no", bvr_serialno, new ValidationHandler.IntegerValidator());
         bvr_addmemberControls.add("nic", bvr_nic , new NICValidator());
         bvr_addmemberControls.add("description",bvr_description);
         bvr_addmemberControls.add("credit_amount",bvr_creditamount, new ValidationHandler.DoubleValidator() );
         bvr_addmemberControls.add("debit_amount",bvr_debitamount , new ValidationHandler.DoubleValidator());
         
           
    }

    private void initializecashbookInputs() {
        
        cashbookControls = new EntityControls("cashbook", nbconn);
        cashbookControls.add("cashbook_id",cb_id);
        cashbookControls.add("credit_bring_down_balance",cb_cbalance, new ValidationHandler.DoubleValidator());
        cashbookControls.add("debit_bring_down_balance",cb_dbalance, new ValidationHandler.DoubleValidator()); 
    }

    private void initializegeneral_ledgerInputs() {
        
        general_ledgerControls = new EntityControls("general_ledger", nbconn);
        general_ledgerControls.add("transaction_code",gl_tc, new ValidationHandler.IntegerValidator());
        general_ledgerControls.add("credit_bring_down_balance",gl_cbalance, new ValidationHandler.DoubleValidator());
        general_ledgerControls.add("debit_bring_down_balance",gl_dbalance, new ValidationHandler.DoubleValidator());
         
         
    }

    private void initializetrial_balanceInputs() {
        
        trial_balanceControls = new EntityControls("trial_balance", nbconn);
        trial_balanceControls.add("trial_balance_id",tb_id);
        trial_balanceControls.add("credit_bring_down_balance",tb_creditbdbalance, new ValidationHandler.DoubleValidator());
        trial_balanceControls.add("debit_bring_down_balance",tb_debitbdbalance, new ValidationHandler.DoubleValidator());
         
    }

   

    private void initializeButtons() {
        
      //cb_cbalance.setText(Entity.parseFromQuery("select sum(credit_amount) as 'total' from bvr_addmember", nbconn).get(0).getAsString("total"));
    }

    private void initializeclButtons() {
        
         Commons.subAnchorButton tc = new Commons.subAnchorButton(tc_anchorpane, "ADD CODES", Commons.ADD_PERSON_GLYPH);
         tc.setCoordinates(750, 120);
         tc.setButtonLength(160);
         JFXButton addButton = tc.getButton();
        
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Entity pnj = transaction_codeControls.getValues();
                pnj.validate(true);
                int p=pnj.consolidate();
                
               transaction_codeControls.clearControls();
               
               transaction_code_handle = new tableViewHandler(tc_table,"select* from transaction_code",nbconn);
                    transaction_code_handle.writeToTable();
                    
                    
            }
        });
        
        
                    
        
    }

    private void initializetcButtons() {
        
        
         Commons.subAnchorButton cl = new Commons.subAnchorButton(cl_anchorpane, "ADD COMPANY", Commons.ADD_PERSON_GLYPH);
         cl.setCoordinates(750, 120);
         cl.setButtonLength(180);
         JFXButton addButton = cl.getButton();
        
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Entity pnj = company_listControls.getValues();
                pnj.validate(true);
                int p=pnj.consolidate();
                
               company_listControls.clearControls();
               
               company_list_handle = new tableViewHandler(cl_table,"select* from company_list",nbconn);
                    company_list_handle.writeToTable();
                    
                    
            }
        });
                    
        
    }

    
    private void initializebvr_addButtons() {
        
        Commons.subAnchorButton bvr_add = new Commons.subAnchorButton(bvr_anchorpane, "SAVE", Commons.HAMBURGER_GLYPH);
         bvr_add.setCoordinates(390, 610);
         bvr_add.setButtonHeigth(20);
         bvr_add.setButtonLength(200);
         JFXButton addButton = bvr_add.getButton();
         
         addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Entity pnj = bvr_addControls.getValues();
                pnj.validate(true);
                int p=pnj.consolidate();
                
               //bvr_addControls.clearControls();
               
               bvr_add_handle = new tableViewHandler(bvr_add_table,"select* from bvr_add",nbconn);
                    bvr_add_handle.writeToTable();
               jfxcashflow_tabpane.getSelectionModel().select(1);     
                    
            }
        });
         
        bvr_list_total.setText(Entity.parseFromQuery("select sum(total_amount) as 'totl' from bvr_add", nbconn).get(0).getAsString("totl"));
     
        
    }
    
    

    private void initializebvr_addmemberButtons() {
        
         Commons.subAnchorButton cb = new Commons.subAnchorButton(bvr_anchorpane, "ADD MEMBER", Commons.ADD_PERSON_GLYPH);
         cb.setCoordinates(565, 330);
         cb.setButtonHeigth(10);
         cb.setGlyphWidth(15);
         cb.setButtonLength(180);
         JFXButton addButton = cb.getButton();
         
         addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Entity pnj = bvr_addmemberControls.getValues();
                pnj.validate(true);
                int p=pnj.consolidate();
                
                Entity pnn = bvr_addControls.getValues();
                pnn.validate(true);
                int n=pnn.consolidate();
                
               //bvr_addmemberControls.clearControls();
               
                bvr_addmember_handle = new tableViewHandler(bvr_addmember_table,"select a.serial_no,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
                    bvr_addmember_handle.writeToTable();
                    
                    
            }
        });
         
       Commons.subAnchorButton dl = new Commons.subAnchorButton(bvr_anchorpane, "DELETE", Commons.DELETE_GLYPH);
         dl.setCoordinates(750, 330);
         dl.setButtonHeigth(10);
         dl.setGlyphWidth(15);
         dl.setButtonLength(180);
         JFXButton deleteButton = dl.getButton();  
       deleteButton.setOnAction(new EventHandler<ActionEvent>()
           
       
       {
            @Override
            public void handle(ActionEvent e)
              {
                Entity delete = bvr_addmember_handle.fetchExtendedSelection("serial_no", "nic");
                delete.deleteFromDB();
                bvr_addmember_handle.writeToTable();
              }
            
           });
        
        
    }

    private void initializecbButtons() {
        Commons.subAnchorButton cb = new Commons.subAnchorButton(cb_anchorpane, "SAVE", Commons.ADD_PERSON_GLYPH);
         //cb.setCoordinates(750, 120);
         cb.setButtonHeigth(10);
         cb.setGlyphWidth(15);
         cb.setButtonLength(160);
         JFXButton addButton = cb.getButton();
         
         addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Entity pnj = cashbookControls.getValues();
                pnj.validate(true);
                int p=pnj.consolidate();
                
               //cashbookControls.clearControls();
               
               cashbook_summary_handle = new tableViewHandler(cb_summary_table,"select * from cashbook",nbconn);
               cashbook_summary_handle.writeToTable();
               jfxcashflow_tabpane.getSelectionModel().select(3);     
                    
            }
        });
         
    }
    
   private void initializeglButtons() {
        Commons.subAnchorButton gl = new Commons.subAnchorButton(gl_anchorpane, "SAVE", Commons.ADD_PERSON_GLYPH);
         //gl.setCoordinates(750, 120);
         gl.setButtonHeigth(10);
         gl.setGlyphWidth(15);
         gl.setButtonLength(160);
         JFXButton addButton = gl.getButton();
         
           addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Entity pnj = general_ledgerControls.getValues();
                pnj.validate(true);
                int p=pnj.consolidate();
                
               //general_ledgerControls.clearControls();
               
               trial_balance_handle = new tableViewHandler(tb_table,"select* from general_ledger",nbconn);
                    trial_balance_handle.writeToTable();
                    jfxcashflow_tabpane.getSelectionModel().select(5);
                    
                    
            }
        });
        
        
    }      
        
        
    

    private void initializetbButtons() {
        Commons.subAnchorButton tb = new Commons.subAnchorButton(tb_anchorpane, "SAVE", Commons.ADD_PERSON_GLYPH);
         //tb.setCoordinates(750, 120);
         tb.setButtonHeigth(10);
         tb.setGlyphWidth(15);
         tb.setButtonLength(160);
         JFXButton addButton = tb.getButton();
         
          addButton.setOnAction((ActionEvent e) -> {
            Entity pnj = trial_balanceControls.getValues();
            pnj.validate(true);
            int p=pnj.consolidate();
            
            //trial_balanceControls.clearControls();
            
            dsr_handle = new tableViewHandler(dsr_table,"select* from trial_balance",nbconn);
            dsr_handle.writeToTable();
            jfxcashflow_tabpane.getSelectionModel().select(6);
            
        });
         
       
        
        
    }

    

          
   

    private void initializecashbookButtons() {
        
        Commons.subAnchorButton gl = new Commons.subAnchorButton(bvr_anchorpane, "ADD CASHBOOK", Commons.LIST_GLYPH);
         gl.setCoordinates(595,610 );
         gl.setButtonHeigth(20);
         //gl.setGlyphWidth(20); 
         gl.setButtonLength(200);
         JFXButton addButton = gl.getButton();
         
         addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
               jfxcashflow_tabpane.getSelectionModel().select(2);
            }
        });
        
    }

    private void initializegoglButtons() {
        
        Commons.subAnchorButton gl = new Commons.subAnchorButton(bvr_anchorpane, "ADD GENERAL LEDGER", Commons.LIST_GLYPH);
         gl.setCoordinates(145,610 );
         gl.setButtonHeigth(20);
         gl.setGlyphWidth(15); 
         gl.setButtonLength(240);
         JFXButton addButton = gl.getButton();
         
         addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                jfxcashflow_tabpane.getSelectionModel().select(4);
            }
        });
     
    }

    private void initializebvr_search() {
        Commons.subAnchorButton cb = new Commons.subAnchorButton(bvr_anchorpane, "", Commons.SEARCH_GLYPH);
         cb.setCoordinates(285, 90);
         cb.setButtonHeigth(9);
         cb.setGlyphWidth(12);
         cb.setButtonLength(40);
         JFXButton searchButton = cb.getButton();
         
         Commons.subAnchorButton hi = new Commons.subAnchorButton(bvr_anchorpane, "", Commons.HAMBURGER_GLYPH);
         hi.setCoordinates(330, 90);
         hi.setButtonHeigth(9);
         hi.setGlyphWidth(12);
         hi.setButtonLength(40);
         JFXButton searchhistoryButton = hi.getButton();
         
          searchhistoryButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                history.getPopOver(nbconn, bvr_serialno, searchhistoryButton);
            }
        });
        
         bvr_addmember_handle = new tableViewHandler(bvr_addmember_table, "select * from bvr_addmember;", nbconn);
    
        
         cb_cbalance.setText(Entity.parseFromQuery("select sum(credit_amount) as 'total' from bvr_addmember", nbconn).get(0).getAsString("total"));
    
         
         cb_dbalance.setText(Entity.parseFromQuery("select sum(debit_amount) as 'totall' from bvr_addmember", nbconn).get(0).getAsString("totall"));
     
         searchButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) 
            {   
            
           bvr_addmember_handle = new tableViewHandler(bvr_addmember_table,"select a.serial_no,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
               bvr_addmember_handle.writeToTable();
                       
                    Entity search=new Entity("select a.serial_no,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
                    search.add("a.serial_no",bvr_serialno.getText());
                    System.out.println(search);
                    bvr_addmember_handle.writeToTable(search.executeAsSearch());
                    
            }    
        });
}       


    private void initializetabepane() {
        
         jfxcashflow_tabpane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
        {
            
             
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                
                 cashbook_handle = new tableViewHandler(cb_table, "select a.serial_no,a.date,a.branch_name,a.transaction_name,a.narration,b.nic,b.description,a.payment_type,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
       
                cashbook_handle.writeToTable();
                
                
                transaction_code_handle = new tableViewHandler(tc_table, "select* from transaction_code",nbconn);
       
                transaction_code_handle.writeToTable();
                
                
                 company_list_handle = new tableViewHandler(cl_table, "select* from company_list",nbconn);
       
                company_list_handle.writeToTable();
                
                
                dsr_handle = new tableViewHandler(dsr_table, "select* from trial_balance",nbconn);
       
                dsr_handle.writeToTable();
                
                
                general_ledger_handle = new tableViewHandler(gl_table, "select a.transaction_code,a.transaction_name,a.date,a.branch_no,a.serial_no,a.narration,a.company_name,a.voucher_receipt,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
       
                general_ledger_handle.writeToTable();
                
                
                cashbook_summary_handle = new tableViewHandler(cb_summary_table, "select* from cashbook",nbconn);
       
                cashbook_summary_handle.writeToTable();
                
                
                trial_balance_handle = new tableViewHandler(tb_table, "select* from general_ledger",nbconn);
       
                trial_balance_handle.writeToTable();
                
                
                bvr_add_handle = new tableViewHandler(bvr_add_table, "select* from bvr_add",nbconn);
       
                bvr_add_handle.writeToTable();
                
               
                
                
                
            }
        });
    }

    private void initializeglpop() {
        
        Commons.subAnchorButton cb = new Commons.subAnchorButton(gl_anchorpane, "SEARCH", Commons.SEARCH_GLYPH);
         cb.setCoordinates(285, 80);
         cb.setButtonHeigth(9);
         cb.setGlyphWidth(12);
         cb.setButtonLength(110);
         JFXButton searchButton = cb.getButton();
         
         Commons.subAnchorButton hi = new Commons.subAnchorButton(gl_anchorpane, "HISTORY", Commons.HAMBURGER_GLYPH);
         hi.setCoordinates(400, 80);
         hi.setButtonHeigth(9);
         hi.setGlyphWidth(12);
         hi.setButtonLength(110);
         JFXButton searchhistoryButton = hi.getButton();
         
          searchhistoryButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                history.getPopOvergl(nbconn, gl_search, searchhistoryButton);
              
                
            }
        });
        
        general_ledger_handle = new tableViewHandler(gl_table, "select a.transaction_code,a.transaction_name,a.date,a.branch_no,a.serial_no,a.narration,a.company_name,a.voucher_receipt,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no", nbconn);
    
        
         searchButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {   
            
           general_ledger_handle = new tableViewHandler(gl_table,"select a.transaction_code,a.transaction_name,a.date,a.branch_no,a.serial_no,a.narration,a.company_name,a.voucher_receipt,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
               general_ledger_handle.writeToTable();
                       
                    Entity search=new Entity("select a.transaction_code,a.transaction_name,a.date,a.branch_no,a.serial_no,a.narration,a.company_name,a.voucher_receipt,b.nic,b.description,b.credit_amount,b.debit_amount from bvr_add a inner join bvr_addmember b on a.serial_no =b.serial_no",nbconn);
                    search.add("a.transaction_code",gl_search.getText());
                    System.out.println(search);
                    general_ledger_handle.writeToTable(search.executeAsSearch());
                    
            }    
        });
    }

    private void initializeglpop1() {
         
         
          bvr_findbranchname.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                history.getPopOver1(nbconn, bvr_branchname, bvr_findbranchname);
              
                
            }
        });
    }

    private void initializeglpop2() {
        
         
          bvr_findcompanyname.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                history.getPopOver2(nbconn, bvr_companyname, bvr_findcompanyname);
              
                
            }
        });
    }

    private void initializeglpop3() {
         
         
          bvr_findtransactionname.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                history.getPopOver3(nbconn, bvr_transactionname, bvr_findtransactionname);
              
                
            }
        });
    }
    

   
    
}
                
