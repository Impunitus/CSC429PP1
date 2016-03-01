package userinterface;

// system imports
<<<<<<< HEAD
import java.util.Vector;
import java.util.Enumeration;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
=======
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
<<<<<<< HEAD
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
=======
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

<<<<<<< HEAD
// project imports
import impresario.IModel;
import model.Book;
import model.BookCollection; 

//===============================================================
public class BookCollectionView extends View
{
	protected TableView<BookTableModel> tableOfBooks;
	protected Button doneButton;

	public BookCollectionView(IModel model)
	{
		super(model, "BookCollectionView");

		VBox container = new VBox(10);
		container.setPadding(new Insets(15, 5, 5, 5));
		container.setPrefWidth(600);
=======
import java.util.Vector;
import java.util.Enumeration;

// project imports
import impresario.IModel;
import model.Account;
import model.AccountCollection;

//==============================================================================
public class BookCollectionView extends View
{
	protected TableView<BookTableView> tableOfBooks;
	protected Button cancelButton;
	protected Button submitButton;

	protected MessageView statusLog;


	//--------------------------------------------------------------------------
	public BookCollectionView(IModel wsc)
	{
		super(wsc, "BookCollectionView");

		// create a container for showing the contents
		VBox container = new VBox(10);
		container.setPadding(new Insets(15, 5, 5, 5));
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3

		// create our GUI components, add them to this panel
		container.getChildren().add(createTitle());
		container.getChildren().add(createFormContent());

<<<<<<< HEAD
		getChildren().add(container);
		
		populateFields();
	}

=======
		// Error message area
		container.getChildren().add(createStatusLog("                                            "));

		getChildren().add(container);

		populateFields();
	}

	//--------------------------------------------------------------------------
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
	protected void populateFields()
	{
		getEntryTableModelValues();
	}

<<<<<<< HEAD
	protected void getEntryTableModelValues()
	{
		ObservableList<BookTableModel> tableData = FXCollections.observableArrayList();
		try
		{
			Vector entryList = (Vector)myModel.getState("Books");
			Enumeration entries = entryList.elements();

			while (entries.hasMoreElements())
=======
	//--------------------------------------------------------------------------
	protected void getEntryTableModelValues()
	{

		ObservableList<BookTableModel> tableData = FXCollections.observableArrayList();
		try
		{
			BookCollection bookCollection = (BookCollection)myModel.getState("BookList");

	 		Vector entryList = (Vector)bookCollection.getState("Books");
			Enumeration entries = entryList.elements();

			while (entries.hasMoreElements() == true)
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
			{
				Book nextBook = (Book)entries.nextElement();
				Vector<String> view = nextBook.getEntryListView();

<<<<<<< HEAD
				BookTableModel nextTableRowData = new BookTableModel(view);
				tableData.add(nextTableRowData);
				
			}

			tableOfBooks.setItems(tableData);
		}
		catch (Exception e)
		{
			// Do nothing for now
		}
	}

	private Node createTitle()
	{
		Text titleText = new Text("                            "+
								  "LIBRARY SYSTEM"+
								  "                            ");
		titleText.setFont(Font.font("Garamond", FontWeight.BOLD, 20));
		titleText.setTextAlignment(TextAlignment.CENTER);
		titleText.setFill(Color.BLACK);
		
		return titleText;
	}

	// Create the main form contents
=======
				// add this list entry to the list
				BookTableModel nextTableRowData = new BookTableModel(view);
				tableData.add(nextTableRowData);

			}

			tableOfAccounts.setItems(tableData);
		}
		catch (Exception e) {//SQLException e) {
			// Need to handle this exception
		}
	}

	// Create the title container
	//-------------------------------------------------------------
	private Node createTitle()
	{
		HBox container = new HBox();
		container.setAlignment(Pos.CENTER);

		Text titleText = new Text("        LIBRARY SYSTEM        ");
		titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		titleText.setWrappingWidth(300);
		titleText.setTextAlignment(TextAlignment.CENTER);
		titleText.setFill(Color.DARKGREEN);
		container.getChildren().add(titleText);

		return container;
	}

	// Create the main form content
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
	//-------------------------------------------------------------
	private VBox createFormContent()
	{
		VBox vbox = new VBox(10);
<<<<<<< HEAD
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text prompt = new Text("SEARCH RESULTS");
		prompt.setWrappingWidth(350);
		prompt.setTextAlignment(TextAlignment.CENTER);
=======

		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
       	grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text prompt = new Text("LIST OF BOOKS");
        prompt.setWrappingWidth(350);
        prompt.setTextAlignment(TextAlignment.CENTER);
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
        prompt.setFill(Color.BLACK);
        grid.add(prompt, 0, 0, 2, 1);

		tableOfBooks = new TableView<BookTableModel>();
<<<<<<< HEAD
		tableOfBooks.setEditable(false);
		tableOfBooks.setPrefWidth(600);

		TableColumn bookIdColumn = new TableColumn("Book Id");
		bookIdColumn.setMinWidth(100);
		bookIdColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("bookId"));

		TableColumn authorColumn = new TableColumn("Author");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("author"));

		TableColumn titleColumn = new TableColumn("Title");
		titleColumn.setMinWidth(100);
		titleColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("title"));

		TableColumn pubYearColumn = new TableColumn("Publication Year");
=======
		tableOfBooks.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		TableColumn bookIDColumn = new TableColumn("Book ID") ;
		bookNumberColumn.setMinWidth(100);
		bookNumberColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("bookId"));

		TableColumn bookAuthorColumn = new TableColumn("Author") ;
		bookAuthorColumn.setMinWidth(100);
		bookAuthorColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("author"));

		TableColumn titleColumn = new TableColumn("Title") ;
		titleColumn.setMinWidth(100);
    titleColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("title"));

		TableColumn pubYearColumn = new TableColumn("Publication Year") ;
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
		pubYearColumn.setMinWidth(100);
		pubYearColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("pubYear"));

<<<<<<< HEAD
		TableColumn statusColumn = new TableColumn("Status");
		statusColumn.setMinWidth(100);
		statusColumn.setCellValueFactory(
	                new PropertyValueFactory<BookTableModel, String>("bookStatus"));
		
		tableOfBooks.getColumns().addAll(bookIdColumn,
										 authorColumn,
										 titleColumn,
										 pubYearColumn,
										 statusColumn);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPrefSize(115, 150);
		scrollPane.setContent(tableOfBooks);

		
		doneButton = new Button("Done");
 		doneButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					((BookCollection)myModel).done();
				}
			});
		HBox btnContainer = new HBox(100);
		btnContainer.setAlignment(Pos.CENTER);
		btnContainer.getChildren().add(doneButton);
=======
    TableColumn statusColumn = new TableColumn("Book Status");
    statusColumn.setMinWidth(100);
    statusColumn.setCellValueFactory(
                  new PropertyValueFactory<BookTableModel, String>("status"));

		tableOfBooks.getColumns().addAll(bookIDColumn, bookAuthorColumn, titleColumn
                                          pubYearColumn, statusColumn);

		tableOfBooks.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event)
			{
				if (event.isPrimaryButtonDown() && event.getClickCount() >=2 ){
					processAccountSelected();
				}
			}
		});
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPrefSize(115, 150);
		scrollPane.setContent(tableOfAccounts);

		submitButton = new Button("Submit");
 		submitButton.setOnAction(new EventHandler<ActionEvent>() {

       		     @Override
       		     public void handle(ActionEvent e) {
       		     	clearErrorMessage();
					// do the inquiry
					processAccountSelected();

            	 }
        	});

		cancelButton = new Button("Back");
 		cancelButton.setOnAction(new EventHandler<ActionEvent>() {

       		     @Override
       		     public void handle(ActionEvent e) {
					/**
					 * Process the Cancel button.
					 * The ultimate result of this action is that the transaction will tell the teller to
					 * to switch to the transaction choice view. BUT THAT IS NOT THIS VIEW'S CONCERN.
					 * It simply tells its model (controller) that the transaction was canceled, and leaves it
					 * to the model to decide to tell the teller to do the switch back.
			 		*/
					//----------------------------------------------------------
       		     	clearErrorMessage();
       		     	myModel.stateChangeRequest("CancelAccountList", null);
            	  }
        	});

		HBox btnContainer = new HBox(100);
		btnContainer.setAlignment(Pos.CENTER);
		btnContainer.getChildren().add(submitButton);
		btnContainer.getChildren().add(cancelButton);
>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3

		vbox.getChildren().add(grid);
		vbox.getChildren().add(scrollPane);
		vbox.getChildren().add(btnContainer);

		return vbox;
	}

<<<<<<< HEAD
	public void updateState(String key, Object value)
	{
		
	}
=======


	//--------------------------------------------------------------------------
	public void updateState(String key, Object value)
	{
	}

	//--------------------------------------------------------------------------
	protected void processAccountSelected()
	{
		AccountTableModel selectedItem = tableOfAccounts.getSelectionModel().getSelectedItem();

		if(selectedItem != null)
		{
			String selectedAcctNumber = selectedItem.getAccountNumber();

			myModel.stateChangeRequest("AccountSelected", selectedAcctNumber);
		}
	}

	//--------------------------------------------------------------------------
	protected MessageView createStatusLog(String initialMessage)
	{
		statusLog = new MessageView(initialMessage);

		return statusLog;
	}


	/**
	 * Display info message
	 */
	//----------------------------------------------------------
	public void displayMessage(String message)
	{
		statusLog.displayMessage(message);
	}

	/**
	 * Clear error message
	 */
	//----------------------------------------------------------
	public void clearErrorMessage()
	{
		statusLog.clearErrorMessage();
	}
	/*
	//--------------------------------------------------------------------------
	public void mouseClicked(MouseEvent click)
	{
		if(click.getClickCount() >= 2)
		{
			processAccountSelected();
		}
	}
   */

>>>>>>> a674cd59d55d275dab62a50996dc851e6242b9e3
}
